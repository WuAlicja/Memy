package com.alicjawaclawek.memy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Data
public class Category {

    private int id;
    private String name;

    public static List<Category> ALL_CATEGORIES = new ArrayList<>();

    static{
            ALL_CATEGORIES.add(new Category(1,"Osoby"));
            ALL_CATEGORIES.add(new Category(2,"Sport"));
            ALL_CATEGORIES.add(new Category(3,"Memy"));
    }
//    public static final List<Category> ALL_CATEGORIES = Arrays.asList(
//            new Category(1,"Osoby"),
//            new Category(2,"Sport"),
//            new Category(3,"Memy")
//    );

    public List<Category> getAllCategories(){
        return ALL_CATEGORIES;
    }
    public Category findById(int id){
        for (Category category:ALL_CATEGORIES){
            if (category.getId()==id){
                return category;
            }
        }
        return null;
    }

}
