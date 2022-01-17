package qk.music_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qk.music_application.model.Music;
import qk.music_application.repository.IMusicRepository;

import java.util.List;

@Service
public class MusicService implements IMusicService {

    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public List<Music> findAll() {
        return this.iMusicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        this.iMusicRepository.save(music);
    }

    @Override
    public Music findByID(int id) {
        return this.iMusicRepository.findByID(id);
    }

    @Override
    public void update(int id, Music music) {
        this.iMusicRepository.update(id,music);
    }

    @Override
    public void remove(int id) {
        this.iMusicRepository.remove(id);
    }
}
