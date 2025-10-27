package vn.edu.fpt.musicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.fpt.musicstore.entities.Album;
import vn.edu.fpt.musicstore.entities.Artist;
import vn.edu.fpt.musicstore.services.AlbumService;
import vn.edu.fpt.musicstore.services.ArtistService;

import java.util.List;

@Controller
public class AlbumController {
    private final AlbumService albumService;
    private final ArtistService artistService;

    public AlbumController(AlbumService albumService, ArtistService artistService) {
        this.albumService = albumService;
        this.artistService = artistService;
    }

    @RequestMapping(value = "/album/new")
    public String newAlbum(Model model, @RequestParam(value = "artist", required = false) int artistId) {
        List<Artist> list = artistService.findAll();
        model.addAttribute("artist", artistService.findById(artistId));
        model.addAttribute("artistList", list);
        model.addAttribute("album", albumService.getAlbumByArtistId(artistId));
        return "album/create";
    }

}
