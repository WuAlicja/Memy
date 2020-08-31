package com.alicjawaclawek.memy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Gif {
    private String name;


    public String getFilePath() {
        return "/gifs/" + name + ".gif";

    }
    public static List<Gif> GIFS = new ArrayList<>();
//blok statyczny sluzy do inicjalizacji zmiennych statycznych
    //wykonywany na samym poczatku uruchomienia pliku
    //hard kodowanie danych
    //symulacja bazy danych bez bazy danych

    static {

        GIFS.add(new Gif("android-explosion"));
        GIFS.add(new Gif("ben-and-mike"));
        GIFS.add(new Gif("book-dominos"));
        GIFS.add(new Gif("compiler-bot"));
        GIFS.add(new Gif("cowboy-coder"));
        GIFS.add(new Gif("infinite-andrew"));
    }
}
