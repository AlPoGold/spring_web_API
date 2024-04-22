package ru.gb.spring_web_API.model;
import lombok.Data;

@Data
public class CharacterSchema {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Origin origin;
    private Location location;
    private String image;
    private String[] episode;
    private String created;

}
