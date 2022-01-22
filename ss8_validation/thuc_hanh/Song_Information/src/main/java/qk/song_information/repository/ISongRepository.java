package qk.song_information.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import qk.song_information.model.Song;

@Repository
public interface ISongRepository extends PagingAndSortingRepository<Song,Integer> {
}
