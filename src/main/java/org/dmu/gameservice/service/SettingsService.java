package org.dmu.gameservice.service;

import org.dmu.gameservice.entity.SymbolValue;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Service Implementierung für die Settings des Spiels.
 */
@Service
public class SettingsService {

    public Collection<String> getSymbols() {
        return Arrays.stream(SymbolValue.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
