package com.example.musiccollection.Controller;

import com.example.musiccollection.Model.Album;
import com.example.musiccollection.Service.AlbumService;
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

    @GetMapping("/")
    public String index(Model model)
    {
        List<Album> albumList = albumService.fetchAll();
        model.addAttribute("albumList", albumList);
        return "Home/index";
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


