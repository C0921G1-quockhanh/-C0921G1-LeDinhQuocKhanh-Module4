package qk.song_information.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import qk.song_information.model.Song;
import qk.song_information.model.SongDto;
import qk.song_information.service.ISongService;

import javax.validation.Valid;
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
        model.addAttribute("songDto",new SongDto());
        return "create";
    }

    @PostMapping(value = "/save")
    public String save(@Validated @ModelAttribute(name = "songDto") SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto,song);
            this.iSongService.save(song);
            redirectAttributes.addFlashAttribute("msg","Add new song successfully!");
            return "redirect:/song";
        }

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
