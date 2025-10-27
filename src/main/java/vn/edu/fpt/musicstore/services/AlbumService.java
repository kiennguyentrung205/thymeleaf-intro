package vn.edu.fpt.musicstore.services;

import org.springframework.stereotype.Service;
import vn.edu.fpt.musicstore.entities.Album;
import vn.edu.fpt.musicstore.repositories.AlbumRepository;

@Service
public class AlbumService {
    private AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Album getAlbumByArtistId(int artistId) {
        return albumRepository.getAlbumByArtistId_ArtistId(artistId);
    }
}
