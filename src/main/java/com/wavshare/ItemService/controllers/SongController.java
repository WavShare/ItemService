package com.wavshare.ItemService.controllers;

import com.wavshare.ItemService.models.Song;
import com.wavshare.ItemService.models.SongRequestModel;
import com.wavshare.ItemService.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "song")
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }


    @GetMapping
    public Iterable<Song> getSongs() {
        return songService.getSongs();
    }

    @GetMapping("/{id}")
    public Song getSong(
            @PathVariable UUID id) throws ResponseStatusException {
        Optional<Song> song = songService.getSong(id);
        if (song.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Song with id " + id + " does not exist"
            );
        }
        return song.get();
    }


    @PostMapping
    public Song addSong(@RequestBody SongRequestModel songRequestModel) {
        Song song = convertToEntity(songRequestModel);

        songService.addNewSong(song);
        Optional<Song> returnedSong = songService.getSong(song.getId());
        if (returnedSong.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "The song was not added successfully. Ask the developers to fix this issue."
            );
        }
        return returnedSong.get();
    }


    @DeleteMapping("/{id}")
    public String deleteSong(@PathVariable UUID id) {
        songService.deleteSong(id);
        return "Song with ID " + id + " has been deleted";
    }

    private Song convertToEntity(SongRequestModel songRequestModel) {
        // Some conditional logic is needed
        return new Song(
                songRequestModel.getUserId(),
                songRequestModel.getTitle(),
                songRequestModel.getAudioLink(),
                songRequestModel.getImageLink()
        );
    }
}
