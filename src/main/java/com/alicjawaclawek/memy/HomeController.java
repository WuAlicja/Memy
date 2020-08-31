package com.alicjawaclawek.memy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    //model map sluzy do przekazywania zmiennej do html
    @GetMapping("/")
    public String getHome(ModelMap map) {
        map.put("gifs",Gif.GIFS);
        return "home";
    }
    @GetMapping("/favorites")
    public String getFavorites(ModelMap map) {
        map.put("gifs",Gif.GIFS);
        return "favorites";
    }

}
