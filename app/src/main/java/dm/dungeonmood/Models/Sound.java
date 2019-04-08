package dm.dungeonmood.Models;

/**
 * Created by Jesus on 4/5/2019.
 */

public class Sound {
    public String category;
    public String title;
    public String details;
    public String url;

    public Sound(String c, String t, String d, String u) {
        category = c;
        title = t;
        details = d;
        url = u;
    }
}