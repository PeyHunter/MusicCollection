package com.example.musiccollection.Controller;

import com.example.musiccollection.Model.Album;
import com.example.musiccollection.Model.Artist;
import com.example.musiccollection.Service.AlbumService;
import com.example.musiccollection.Service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController
{
    @Autowired
    AlbumService albumService;

    @Autowired
    private ArtistService artistService;

    @GetMapping("/")
    public String index(Model model)
    {
        List<Album> albumList = albumService.fetchAllAlbum();
        model.addAttribute("albumList", albumList);
        return "Home/index";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        List<Artist> artistList = artistService.fetchAllArtist();  // Get all artists
        model.addAttribute("artistList", artistList);  // Pass artists to the form
        model.addAttribute("album", new Album());  // Empty album object to bind form fields
        return "Home/add";  // Show the album form
    }



    @GetMapping("/add")
    public String addForm() {
        return "home/add"; // Show the album form
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Album album)
    {
        albumService.addAlbum(album);
        return "redirect:/";
    }


}


