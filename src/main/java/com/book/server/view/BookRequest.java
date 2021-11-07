package com.book.server.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    @JsonProperty(value="id", required=true, index = 10)
    @Schema(description = "UNIQUE Identifier.",
            example = "1", required = true)
    private long id;


    @JsonProperty(value="title", required=true, index = 20)
    @Schema(description = "Name of the title.",
            example = "Effective Java", required = true)
    @NotBlank
    @Size(min = 0, max = 20)
    private String title;


    @JsonProperty(value="author", required=true, index = 30)
    @Schema(description = "Name of the author.",
            example = "Joshua Bloch", required = true)
    @NotBlank
    @Size(min = 0, max = 30)
    private String author;

}
