package ru.gb.spring_web_API.model;

import lombok.Data;

@Data
public class CharacterResponse {
    private CharacterSchema[] results;
    private Info info;
}
