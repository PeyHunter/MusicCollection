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
    public String index(Model model)
    {
        // Fetch all albums, tracks, artists, and record labels
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
            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();  // Print the error for debugging
            model.addAttribute("error", "An error occurred while adding the album.");
            return "addAlbum";
        }
    }

    @PostMapping("/addTrack")
    public String addTrack(@ModelAttribute Track track) {
        trackService.addTrack(track);
        return "redirect:/";
    }

    @PostMapping("/addArtist")
    public String addArtist(@ModelAttribute Artist artist) {
        artistService.addArtist(artist);
        return "redirect:/";
    }

    @PostMapping("/addRecordLabel")
    public String addRecordLabel(@ModelAttribute RecordLabel recordLabel) {
        recordLabelService.addRecordLabel(recordLabel);
        return "redirect:/";
    }


}


