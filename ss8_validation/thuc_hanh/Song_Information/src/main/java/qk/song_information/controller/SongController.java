package qk.song_information.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import qk.song_information.model.Song;
import qk.song_information.service.ISongService;

import java.util.Optional;

@Controller
@RequestMapping(value = "/song")
public class SongController {

    @Autowired
    private ISongService iSongService;

    @GetMapping(value = "")
    public String list(Model model, Pageable pageable) {
        Page<Song> songs = this.iSongService.findAll(pageable);
        model.addAttribute("songs",songs);
        return "list";
    }

    @GetMapping(value = "/create")
    public String addNew(Model model) {
        model.addAttribute("song",new Song());
        return "create";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute(name = "song") Song song, RedirectAttributes redirectAttributes) {
        this.iSongService.save(song);
        redirectAttributes.addFlashAttribute("msg","Add new song successfully!");
        return "redirect:/song";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Song> song = this.iSongService.findByID(id);

        if (song.isPresent()) {
            model.addAttribute("song",song.get());
            return "edit";
        } else {
            return "error.404";
        }
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute(name = "song") Song song, RedirectAttributes redirectAttributes) {
        this.iSongService.save(song);
        redirectAttributes.addFlashAttribute("msg","Update song successfully!");
        return "redirect:/song";
    }

}
