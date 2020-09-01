package com.alicjawaclawek.memy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String showCategories(ModelMap map) {
        map.put("categories", Category.ALL_CATEGORIES);
        return "categories";
    }

    @GetMapping("/category/{id}")
    public String category(@PathVariable int id, ModelMap map) {
        Category category = Category.ALL_CATEGORIES.stream().filter(c -> c.getId() == id).findFirst().get();
        map.put("category", category);
        List<Gif> gifList = new ArrayList<>();
        for (Gif gif : Gif.GIFS
        ) {
            if (gif.getCategoryId() == id) {
                gifList.add(gif);
            }
        }
        map.put("gifs", gifList);
        return "category";
    }

    //    @GetMapping("/?q={word}#")
//    public String question(@PathVariable String word, ModelMap map) {
//
////        map.put("category",Category.ALL_CATEGORIES.stream().filter(c -> c.getName().contains(word)).findFirst().get());
//        map.put("gifs", Gif.GIFS.stream().
//                filter(g -> g.getName().contains(word)).findFirst().get());
//
//        return "question";
//    }
    /*
    RequestParam oznacza ze parametr bedzie wysylany do adresu url o nazwie name /gifs/search?name=ben
     */
    @GetMapping("/gifs/search")
    public String searchGifs(@RequestParam String q, ModelMap map) {

        List<Gif> gifs = new ArrayList<>();
        for (Gif gif : Gif.GIFS) {
            if (gif.getName().contains(q)) {
                gifs.add(gif);
            }
        }
        map.put("gifs", gifs);
        return "home";
    }
}

