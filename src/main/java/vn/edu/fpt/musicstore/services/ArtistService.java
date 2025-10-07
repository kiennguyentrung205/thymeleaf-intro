package vn.edu.fpt.musicstore.services;

import org.springframework.stereotype.Service;
import vn.edu.fpt.musicstore.entities.Artist;
import vn.edu.fpt.musicstore.repositories.ArtistRepository;

import java.util.List;

@Service
public class ArtistService {
    private ArtistRepository artistRepository;
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }
    public List<Artist> findAll() {
        return artistRepository.findAll();
    }
    public Artist findById(int id) {
        return artistRepository.findById(id).orElse(null);
    }
}
