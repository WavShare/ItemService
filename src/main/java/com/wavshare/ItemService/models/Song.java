package com.wavshare.ItemService.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Document(collection = "song")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Song {

    @Id
    private UUID id;

    @Setter
    private UUID userId;

    @Setter
    private String title;

    @Setter
    private String description;

    private LocalDateTime createdAt;

    @Setter
    private String audioLink;

    @Setter
    private String imageLink;

    @Setter
    private UUID albumId;

    public Song(UUID userId, String title, String audioLink, String imageLink) {
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.title = title;
        this.audioLink = audioLink;
        this.imageLink = imageLink;
    }
}
