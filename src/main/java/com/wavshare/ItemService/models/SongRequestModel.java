package com.wavshare.ItemService.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class SongRequestModel {
    private UUID userId;
    private String title;
    private String description;
    private String audioLink;
    private String imageLink;
    private UUID albumId;
}
