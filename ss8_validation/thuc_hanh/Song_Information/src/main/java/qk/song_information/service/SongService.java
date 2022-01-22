package qk.song_information.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import qk.song_information.model.Song;
import qk.song_information.repository.ISongRepository;

import java.util.Optional;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public Optional<Song> findByID(Integer id) {
        return this.iSongRepository.findById(id);
    }

    @Override
    public void save(Song song) {
        this.iSongRepository.save(song);
    }

    @Override
    public Page<Song> findAll(Pageable pageable) {
        return this.iSongRepository.findAll(pageable);
    }
}
