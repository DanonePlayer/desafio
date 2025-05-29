package com.desafio.desafio.application.receita.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReceitaDTO {
    @JsonProperty("publisher")
    private String publisher;
    @JsonProperty("title")
    private String title;
    @JsonProperty("source_url")
    private String sourceUrl;
    @JsonProperty("recipe_id")
    private String recipeId;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("social_rank")
    private double socialRank;
    @JsonProperty("publisher_url")
    private String publisherUrl;
}
