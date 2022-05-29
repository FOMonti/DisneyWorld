package com.alkemy.disneyworld.dto.genero;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneroUpdateDto {

    private String oldName;

    private String newName;

    private String image;
}
