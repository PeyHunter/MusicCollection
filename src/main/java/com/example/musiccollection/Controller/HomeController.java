package com.example.musiccollection.Controller;

import com.example.musiccollection.Model.*;
import com.example.musiccollection.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController
{
    @Autowired
    private AlbumService albumService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private TrackService trackService;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private RecordLabelService recordLabelService;

    @GetMapping("/")
    public String index(Model model) {
        List<Address> addressList = addressService.fetchAllAddress();
        List<Album> albumList = albumService.fetchAllAlbum();
        List<Track> trackList = trackService.fetchAllTrack();
        List<Artist> artistList = artistService.fetchAllArtist();
        List<RecordLabel> recordLabelList = recordLabelService.fetchAllRecordLabel();

        // Add data to the model
        model.addAttribute("addressList", addressList);
        model.addAttribute("albumList", albumList);
        model.addAttribute("trackList", trackList);
        model.addAttribute("artistList", artistList);
        model.addAttribute("recordLabelList", recordLabelList);

        // Add empty album, track, artist, and record label objects for the form
        model.addAttribute("address", new Address());
        model.addAttribute("album", new Album());
        model.addAttribute("track", new Track());
        model.addAttribute("artist", new Artist());
        model.addAttribute("recordLabel", new RecordLabel());

        // Add the albumToUpdate to the model, if it exists
        model.addAttribute("albumToUpdate", new Album());

        return "Home/index";
    }

    @GetMapping("/artists")
    public String getArtists(Model model) {
        List<Artist> artists = artistService.fetchAllArtist();  // Make sure Address is fetched with Artist
        model.addAttribute("artistList", artists);
        return "artists";
    }


    @GetMapping("/addAlbum")
    public String addAlbumForm(Model model) {
        List<Artist> artistList = artistService.fetchAllArtist();
        List<RecordLabel> recordLabelList = recordLabelService.fetchAllRecordLabel();
        model.addAttribute("artistList", artistList);
        model.addAttribute("recordLabelList", recordLabelList);
        return "addAlbum";
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

    @PostMapping("/deleteArtist/{artistId}")
    public String deleteArtist(@PathVariable("artistId") int artistId) {
        boolean deleted = artistService.deleteArtist(artistId);
        return "redirect:/#artists";
    }



    @GetMapping("/updateAlbum/{albumId}")
    public String showUpdateAlbumForm(@PathVariable("albumId") Integer albumId, Model model) {
        Album album = albumService.findAlbumById(albumId);
        if (album != null) {
            model.addAttribute("album", album);
            List<Artist> artistList = artistService.fetchAllArtist();
            List<RecordLabel> recordLabelList = recordLabelService.fetchAllRecordLabel();
            model.addAttribute("artistList", artistList);
            model.addAttribute("recordLabelList", recordLabelList);
            return "updateAlbum";  // Thymeleaf template for the update form
        } else {
            // If album not found, redirect to the album list page
            return "redirect:/#albums";
        }
    }

    @PostMapping("/updateAlbum")
    public String updateAlbum(@RequestParam Integer albumId, @RequestParam String title,
                              @RequestParam Integer releaseYear, @RequestParam(required = false) Integer artistId,
                              @RequestParam(required = false) Integer labelId, RedirectAttributes redirectAttributes) {
        try {
            // Fetch the album by its ID
            Album albumToUpdate = albumService.findAlbumById(albumId);
            if (albumToUpdate != null) {
                // If artistId and labelId are provided (not null), fetch Artist and RecordLabel
                if (artistId != null) {
                    Artist artist = artistService.findArtistById(artistId);
                    if (artist != null) {
                        albumToUpdate.setArtist(artist); // Set the Artist object (not just the ID)
                    } else {
                        redirectAttributes.addFlashAttribute("error", "Artist not found.");
                        return "redirect:/#albums";  // Redirect to index page
                    }
                }

                if (labelId != null) {
                    RecordLabel recordLabel = recordLabelService.findRecordLabelById(labelId);
                    if (recordLabel != null) {
                        albumToUpdate.setRecordLabel(recordLabel); // Set the RecordLabel object (not just the ID)
                    } else {
                        redirectAttributes.addFlashAttribute("error", "Record Label not found.");
                        return "redirect:/#albums";  // Redirect to index page
                    }
                }

                // Update the album details
                albumToUpdate.setTitle(title);
                albumToUpdate.setReleaseYear(releaseYear);

                // Save the updated album
                albumService.updateAlbum(albumToUpdate);

                // Add a success message to the redirectAttributes
                redirectAttributes.addFlashAttribute("message", "Album updated successfully!");

                // Redirect back to the index page
                return "redirect:/#albums";  // Redirect to index page
            } else {
                // If album not found, show an error
                redirectAttributes.addFlashAttribute("error", "Album not found.");
                return "redirect:/#albums";  // Redirect to index page
            }
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "An error occurred while updating the album.");
            return "redirect:/";  // Redirect to index page with error
        }
    }


}







