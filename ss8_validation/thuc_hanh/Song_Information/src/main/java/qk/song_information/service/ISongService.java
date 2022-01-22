package qk.song_information.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import qk.song_information.model.Song;

import java.util.Optional;

public interface ISongService {
    public Optional<Song> findByID(Integer id);

    public void save(Song song);

    public Page<Song> findAll(Pageable pageable);
}
