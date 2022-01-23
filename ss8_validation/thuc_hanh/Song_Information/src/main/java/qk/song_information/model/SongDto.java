package qk.song_information.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto {

    protected Integer id;

    @NotEmpty(message = "Name not empty")
    @Size(max = 800,message = "Do not exceed 800 characters")
    @Pattern(regexp = "^[\\w\\s]+$",message = "Do not contain special characters")
    protected String name;

    @NotEmpty(message = "Artist not empty")
    @Size(max = 300,message = "Do not exceed 300 characters")
    @Pattern(regexp = "^[\\w\\s]+$",message = "Do not contain special characters")
    protected String artist;

    @NotEmpty(message = "Type of song not empty")
    @Size(max = 1000,message = "Do not exceed 1000 characters")
    @Pattern(regexp = "^[\\w\\s\\,]+$",message = "Do not contain special characters except ,")
    protected String typeOfSong;

    public SongDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getTypeOfSong() {
        return typeOfSong;
    }

    public void setTypeOfSong(String typeOfSong) {
        this.typeOfSong = typeOfSong;
    }
}
