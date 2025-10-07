package vn.edu.fpt.musicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.fpt.musicstore.entities.Artist;
import vn.edu.fpt.musicstore.services.ArtistService;

import java.util.List;

@Controller
public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @RequestMapping(value = {"/artist", "/artist/list"})
    public String artitsList(Model model) {
        List<Artist> list = artistService.findAll();
        model.addAttribute("artists", list);
        return "artist/list";
    }

    @RequestMapping(value = "artist/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("artist",artistService.findById(id));
        return "artist/edit";
    }

    @RequestMapping(value = "artist/new")
    public String newArtist(Model model) {
        model.addAttribute("artist", new Artist());
        return "artist/create";
    }

    @RequestMapping(value = "artist/delete/{id}")
    public String deleteArtist(Model model, @PathVariable("id") int id) {
        return "artist/delete";
    }

    @RequestMapping(value = "/artist/create", method = RequestMethod.POST)
    public String create(@ModelAttribute(name = "artist") Artist artist) {
        System.out.println("Artist name:" + artist.getArtistName());
        return "redirect:/artist";
    }
}
