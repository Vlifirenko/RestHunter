package resthunter.content.model;

/**
 * Created by blood_000 on 31.05.2014.
 */
public class Category {

    public int id;
    public String name;
    public int behind;

    public Category(int id, String name, int behind) {
        this.id = id;
        this.name = name;
        this.behind = behind;
    }
}
