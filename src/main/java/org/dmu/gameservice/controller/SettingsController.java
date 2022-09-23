package org.dmu.gameservice.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.dmu.gameservice.service.SettingsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * RestController für die Settings des Spiels.
 * Hier wird die Rest-API definiert.
 */
@RestController
@RequestMapping("settings")
@CrossOrigin(origins = { "http://localhost:3000"})
@Data
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class SettingsController {

    final private SettingsService service;

    @GetMapping("/symbols")
    public Collection<String> getSymbols() {
        return service.getSymbols();
    }
}
