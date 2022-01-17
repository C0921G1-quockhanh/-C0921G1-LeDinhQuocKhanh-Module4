package qk.music_application.model;

import javax.persistence.*;

@Entity
@Table
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    protected String name;
    protected String artist;
    protected String typeOfMusic;

    public Music() {
    }

    public Music(String name, String artist, String typeOfMusic) {
        this.name = name;
        this.artist = artist;
        this.typeOfMusic = typeOfMusic;
    }

    public Music(int id, String name, String artist, String typeOfMusic) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.typeOfMusic = typeOfMusic;
    }

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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTypeOfMusic() {
        return typeOfMusic;
    }

    public void setTypeOfMusic(String typeOfMusic) {
        this.typeOfMusic = typeOfMusic;
    }
}
