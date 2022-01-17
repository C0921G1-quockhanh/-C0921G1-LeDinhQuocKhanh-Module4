package qk.music_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import qk.music_application.model.Music;
import qk.music_application.service.IMusicService;

import java.util.List;

@Controller
@RequestMapping(value = "/music")
public class MusicController {

    @Autowired
    private IMusicService iMusicService;

    @GetMapping(value = "")
    public String list(Model model) {
        List<Music> musics = this.iMusicService.findAll();
        model.addAttribute("musics",musics);

        return "list";
    }

    @GetMapping(value = "/create")
    public String addNew(Model model) {
        model.addAttribute("music",new Music());
        return "create";
    }

    @PostMapping(value = "/save")
    public String save(Music music, RedirectAttributes redirectAttributes) {
//        music.setId(this.iMusicService.findAll().size() + 1);
        this.iMusicService.save(music);
        redirectAttributes.addFlashAttribute("msg","Add new music successfully!");

        return "redirect:/music";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable int id,Model model) {
        model.addAttribute("music",this.iMusicService.findByID(id));
        return "edit";
    }

    @PostMapping(value = "/update")
    public String update(Music music,RedirectAttributes redirectAttributes) {
        this.iMusicService.update(music.getId(),music);
        redirectAttributes.addFlashAttribute("msg","Update music successfully!");

        return "redirect:/music";
    }

    @GetMapping(value = "/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("music",this.iMusicService.findByID(id));
        return "delete";
    }

    @PostMapping(value = "/delete")
    public String delete(Music music, RedirectAttributes redirectAttributes) {
        this.iMusicService.remove(music.getId());
        redirectAttributes.addFlashAttribute("msg","Delete music successfully!");

        return "redirect:/music";
    }

    @GetMapping(value = "/{id}/view")
    public String view (@PathVariable int id,Model model) {
        model.addAttribute("music",this.iMusicService.findByID(id));
        return "view";
    }
}
