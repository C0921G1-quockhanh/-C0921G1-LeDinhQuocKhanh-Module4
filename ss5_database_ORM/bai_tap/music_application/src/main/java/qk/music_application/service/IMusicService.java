package qk.music_application.service;

import qk.music_application.model.Music;

import java.util.List;

public interface IMusicService {

    public List<Music> findAll();

    public void save(Music music);

    public Music findByID(int id);

    public void update(int id, Music music);

    public void remove(int id);
}
