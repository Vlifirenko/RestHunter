package resthunter.adapters.interfaces;

import java.util.List;

import resthunter.content.model.Category;

/**
 * Created by blood_000 on 31.05.2014.
 */
public interface CategoryFinder {

    List<Category> findAll();

}
