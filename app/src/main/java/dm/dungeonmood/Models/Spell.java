package dm.dungeonmood.Models;

/**
 * Created by Jesus on 4/5/2019.
 */
public class Spell {
    public String name;
    public String school;
    public int level;
    String components;
    public String description;

    public Spell(String n, String s, String c, int l, String d) {
        name = n;
        school = s;
        components=c;
        level=l;
        description = d;
    }
}