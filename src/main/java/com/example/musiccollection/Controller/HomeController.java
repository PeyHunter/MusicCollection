package com.example.musiccollection.Controller;

import com.example.musiccollection.Model.Album;
import com.example.musiccollection.Service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}


