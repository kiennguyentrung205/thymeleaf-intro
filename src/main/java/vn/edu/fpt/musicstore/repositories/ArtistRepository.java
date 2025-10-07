package vn.edu.fpt.musicstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.fpt.musicstore.entities.Artist;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {

}
