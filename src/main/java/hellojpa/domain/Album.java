package hellojpa.domain;

import jakarta.persistence.Entity;

@Entity
public class Album extends Item {

    private String artist;
    private String ect;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getEct() {
        return ect;
    }

    public void setEct(String ect) {
        this.ect = ect;
    }
}
