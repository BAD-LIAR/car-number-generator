package ru.gvozdev.numbergenerator.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.gvozdev.numbergenerator.service.NumberService;

@RequestMapping(value = "/number")
@RequiredArgsConstructor
@RestController
public class NumberController {


    private final NumberService numberService;

    @GetMapping("/next")
    public ResponseEntity<?> getNextNumber(){
        return ResponseEntity.ok(numberService.generateNextNumber());
    }

    @GetMapping("/random")
    public ResponseEntity<?> getRandom(){
        return ResponseEntity.ok(numberService.generateRandomNumber());
    }
}
