package com.alicjawaclawek.memy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    //model map sluzy do przekazywania zmiennej do html
    @GetMapping("/")
    public String getHome(ModelMap map) {
        map.put("gifs", Gif.GIFS);
        return "home";
    }

    @GetMapping("/favorites")
    public String getFavorites(ModelMap map) {
        List<Gif> gifList = new ArrayList<>();
        for (Gif gif : Gif.GIFS
        ) {
            if (gif.isFavorite()) {
                gifList.add(gif);
            }
        }
        map.put("gifs", gifList);
        return "favorites";
    }

    //name ktory jest zmienny
    /*
    @PathVariable zamienia automatycznie ze sciezki ktora sie zmienia na zmienna Javowa o nazwie name
    git/mike
    String name="mike"
     */
    @GetMapping("/gif/{name}")
    public String getDetails(@PathVariable String name, ModelMap map) {
//        for (int i = 0; i < 6; i++) {
//            if (name.equals(Gif.GIFS.get(i).getName()))
//                map.put("gif", Gif.GIFS.get(i));
//        }

        map.put("gif", Gif.GIFS.stream().
                filter(g -> g.getName().equals(name)).findFirst().get());
        return "gif-details";
    }

    @GetMapping("/categories")
    public String showCategories(ModelMap map){
        map.put("categories",Category.ALL_CATEGORIES);
        return "categories";
    }
}

