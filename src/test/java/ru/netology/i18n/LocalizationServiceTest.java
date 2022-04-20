package ru.netology.i18n;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceTest {
    LocalizationServiceImpl localizationService;

    @BeforeEach
    void setUp() {
        localizationService = new LocalizationServiceImpl();
    }

    @Test
    @DisplayName("проверка возвращаемого текста (Россия)")
    void localeRussia() {
        String expected = "Добро пожаловать";
        String actual = localizationService.locale(Country.RUSSIA);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("проверка возвращаемого текста (США)")
    void localeUSA() {
        String expected = "Welcome";
        String actual = localizationService.locale(Country.USA);
        assertEquals(expected,actual);
    }
}