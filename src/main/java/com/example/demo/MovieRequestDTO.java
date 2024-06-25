package com.example.demo;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class MovieRequestDTO {
    private String media_type;
    private int media_id;
    private boolean favorite;

}
