package com.wavshare.ItemService.services;

import com.wavshare.ItemService.models.Song;
import com.wavshare.ItemService.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SongService {
    private final SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    // Read methods

    public Iterable<Song> getSongs() {
        return songRepository.findAll();
    }

    public Optional<Song> getSong(UUID id) {
        return songRepository.findById(id);
    }

    // Write methods

    public void addNewSong(Song song) {
        songRepository.save(song);
    }


    // Delete methods

    public void deleteSong(UUID id) {
        boolean exists = songRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Song with id " + id + " does not exist");
        }

        songRepository.deleteById(id);
    }
}
