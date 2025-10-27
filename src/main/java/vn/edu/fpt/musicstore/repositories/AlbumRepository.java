package vn.edu.fpt.musicstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.fpt.musicstore.entities.Album;
import vn.edu.fpt.musicstore.entities.Artist;
@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

    Album getAlbumByArtistId_ArtistId(int artistId);
}
