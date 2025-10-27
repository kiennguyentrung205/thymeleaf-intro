package vn.edu.fpt.musicstore.entities;

import jakarta.persistence.*;

@Entity
public class Album {
    @Id
    @Column(name = "albumid")
    private int albumId;
    @Column(name = "title")
    private String title;
    @ManyToOne
    @JoinColumn(name = "artistid")
    private Artist artistId;

    public Album(int albumId, String title) {
        this.albumId = albumId;
        this.title = title;
    }

    public Album() {
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtistId() {
        return artistId;
    }

    public void setArtistId(Artist artistId) {
        this.artistId = artistId;
    }
}
