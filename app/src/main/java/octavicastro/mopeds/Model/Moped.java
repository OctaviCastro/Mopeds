package octavicastro.mopeds.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Moped extends RealmObject{

    @PrimaryKey
    private int id;

    private String name;
    private String company;
    private int image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
