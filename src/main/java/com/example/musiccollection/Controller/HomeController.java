package com.example.musiccollection.Controller;

import com.example.musiccollection.Model.Album;
import com.example.musiccollection.Model.Artist;
import com.example.musiccollection.Model.RecordLabel;
import com.example.musiccollection.Model.Track;
import com.example.musiccollection.Service.AlbumService;
import com.example.musiccollection.Service.ArtistService;
import com.example.musiccollection.Service.RecordLabelService;
import com.example.musiccollection.Service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController
{
    @Autowired
    private AlbumService albumService;

    @Autowired
    private TrackService trackService;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private RecordLabelService recordLabelService;


    @GetMapping("/")
    public String index(Model model) {
        List<Album> albumList = albumService.fetchAllAlbum();
        List<Track> trackList = trackService.fetchAllTrack();
        List<Artist> artistList = artistService.fetchAllArtist();
        List<RecordLabel> recordLabelList = recordLabelService.fetchAllRecordLabel();

        // Add data to the model
        model.addAttribute("albumList", albumList);
        model.addAttribute("trackList", trackList);
        model.addAttribute("artistList", artistList);
        model.addAttribute("recordLabelList", recordLabelList);

        // Add empty album, track, artist, and record label objects for the form
        model.addAttribute("album", new Album());
        model.addAttribute("track", new Track());
        model.addAttribute("artist", new Artist());
        model.addAttribute("recordLabel", new RecordLabel());

        // Add the albumToUpdate to the model, if it exists
        model.addAttribute("albumToUpdate", new Album());

        return "Home/index";
    }



    @GetMapping("/addAlbum")
    public String showAddAlbumForm(Model model) {
        List<Artist> artistList = artistService.fetchAllArtist();  // Fetch artists
        List<RecordLabel> recordLabelList = recordLabelService.fetchAllRecordLabel();  // Fetch record labels
        model.addAttribute("artistList", artistList);
        model.addAttribute("recordLabelList", recordLabelList);
        return "addAlbum";  // Thymeleaf template
    }

    @PostMapping("/addAlbum")
    public String addAlbum(@RequestParam String title, @RequestParam int releaseYear, @RequestParam int artistId, @RequestParam int labelId, Model model) {
        System.out.println("Artist ID: " + artistId);
        System.out.println("Label ID: " + labelId);

        try {
            Artist artist = artistService.findArtistById(artistId);
            RecordLabel recordLabel = recordLabelService.findRecordLabelById(labelId);

            if (artist == null || recordLabel == null) {
                throw new IllegalArgumentException("Invalid artist or label ID");
            }

            // Assuming the Album constructor is defined to take these parameters
            Album newAlbum = new Album(title, releaseYear, artistId, labelId);
            albumService.addAlbum(newAlbum);  // Save the album

            // Redirect to the list of albums after adding the new one
            return "redirect:/#albums";
        } catch (Exception e) {
            e.printStackTrace();  // Print the error for debugging
            model.addAttribute("error", "An error occurred while adding the album.");
            return "addAlbum";
        }
    }

    @PostMapping("/deleteAlbum/{albumId}")
    public String deleteAlbum(@PathVariable("albumId") int albumId)
    {
        boolean deleted = albumService.deleteAlbum(albumId);
        if (deleted)
        {
            return "redirect:/#albums";
        } else
        {
            return "redirect:/#albums";
        }
    }

    @GetMapping("/updateAlbum/{id}")
    public String updateAlbum(@PathVariable("id") int id, Model model) {
        // Fetch the album by ID and add it to the model
        Album album = albumService.findAlbumById(id);

        // Fetch all artists and record labels to populate the dropdowns in the form
        List<Artist> artistList = artistService.fetchAllArtist();
        List<RecordLabel> recordLabelList = recordLabelService.fetchAllRecordLabel();

        // Add attributes to the model
        model.addAttribute("albumToUpdate", album);  // Add album to model
        model.addAttribute("artistList", artistList);  // Add artist list
        model.addAttribute("recordLabelList", recordLabelList);  // Add label list

        // Return the template name for updating the album
        return "Home/index";  // We'll return the same page
    }


    @PostMapping("/updateAlbum")
    public String updateAlbum(@ModelAttribute Album album, @RequestParam int artistId, @RequestParam int labelId) {
        try {
            // Fetch the artist and record label using the IDs
            Artist artist = artistService.findArtistById(artistId);
            RecordLabel recordLabel = recordLabelService.findRecordLabelById(labelId);

            // Check if the artist or label is null
            if (artist == null || recordLabel == null) {
                throw new IllegalArgumentException("Invalid artist or label");
            }

            // Set the artist and record label for the album
            album.setArtist(artist);
            album.setRecordLabel(recordLabel);

            // Update the album
            albumService.updateAlbum(album);

            // Redirect to the homepage after updating the album
            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();
            // In case of errors, redirect back to the homepage
            return "redirect:/";
        }
    }




}







