package com.wavshare.ItemService.repositories;

import com.wavshare.ItemService.models.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SongRepository extends MongoRepository<Song, UUID> {
}
