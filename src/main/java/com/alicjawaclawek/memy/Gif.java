package com.alicjawaclawek.memy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Gif {
    private String name;
    private boolean favorite;
    private int categoryId;


    public String getFilePath() {
        return "/gifs/" + name + ".gif";

    }
    public static List<Gif> GIFS = new ArrayList<>();
//blok statyczny sluzy do inicjalizacji zmiennych statycznych
    //wykonywany na samym poczatku uruchomienia pliku
    //hard kodowanie danych
    //symulacja bazy danych bez bazy danych

    static {

        GIFS.add(new Gif("android-explosion",true,1));
        GIFS.add(new Gif("ben-and-mike",false,2));
        GIFS.add(new Gif("book-dominos",true,3));
        GIFS.add(new Gif("compiler-bot",false,1));
        GIFS.add(new Gif("cowboy-coder",true,2));
        GIFS.add(new Gif("infinite-andrew",true,3));
    }
}
