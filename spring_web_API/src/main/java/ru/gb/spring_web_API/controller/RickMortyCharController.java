package ru.gb.spring_web_API.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.gb.spring_web_API.model.CharacterResponse;
import ru.gb.spring_web_API.model.CharacterSchema;


@Controller
@RequestMapping("/api")
public class RickMortyCharController {

    @Value("${rickandmortyapi.baseurl}")
    private String BASE_URL;

    @Value("${rickandmortyapi.characterurl}")
    private String CHAR_URL;

    @GetMapping("/characters")
    public String getCharacters(Model model, @RequestParam(defaultValue = "1") int page) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CharacterResponse> response = restTemplate.getForEntity(CHAR_URL + "?page=" + page, CharacterResponse.class);
        CharacterResponse characterResponse = response.getBody();
        model.addAttribute("characters", characterResponse.getResults());
        model.addAttribute("page", page);
        model.addAttribute("hasNext", characterResponse.getInfo().getNext() != null);
        return "list-characters";
    }

    @GetMapping("/character")
    public String getCharacter(Model model, @RequestParam("characterId") int characterId) {
        RestTemplate restTemplate = new RestTemplate();
        CharacterSchema character = restTemplate.getForObject(CHAR_URL + "/" + characterId, CharacterSchema.class);
        model.addAttribute("character", character);
        return "single-character";
    }







}
