package vn.edu.fpt.musicstore.controller;

import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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
    public String artitsList(Model model, @RequestParam(value = "page", defaultValue = "1") int page, Authentication authentication) {
       UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("username = " + userDetails.getUsername());
        int pageSize = 10;
        Page<Artist> artistsPage = artistService.findPaginated(page-1, pageSize);
        model.addAttribute("artistsPage", artistsPage);
        model.addAttribute("currentPage", page);
//                List<Artist> list = artistService.findAll();
//        model.addAttribute("artists", list);
        return "artist/list";
    }

    @RequestMapping(value = "artist/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("artist", artistService.findById(id));
        return "artist/edit";
    }

    @RequestMapping(value = "artist/new")
    public String newArtist(Model model) {
        model.addAttribute("artist", new Artist());
        return "artist/create";
    }

    @RequestMapping(value = "artist/delete/{id}")
    public String deleteArtist(Model model, @PathVariable("id") int id) {
        System.out.println("Artist id:" + id);
        model.addAttribute("artist", artistService.findById(id));
        return "artist/delete";
    }

    @RequestMapping(value = "/artist/save")
    public String save(@ModelAttribute(name = "artist") Artist artist) {
        System.out.println("Artist name:" + artist.getArtistName());
        artistService.save(artist);
        return "redirect:/artist";
    }

    @RequestMapping(value = "/artist/delete/{id}", method = RequestMethod.POST)
    public String delete(@ModelAttribute(name = "artist") Artist artist) {
        System.out.println("Artist id:" + artist.getArtistId());
        artistService.deleteById(artist.getArtistId());
        return "redirect:/artist";
    }

    @GetMapping(value = "artist/detail/{id}")
    public String details(Model model, @PathVariable("id") int id) {
        System.out.println("hello:" + id);
        model.addAttribute("artist", artistService.findById(id));
        return "artist/detail";
    }

}
