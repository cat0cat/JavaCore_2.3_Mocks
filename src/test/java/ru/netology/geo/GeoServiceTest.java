package ru.netology.geo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceTest {

    @Test
    @DisplayName("проверка определения геолокации по ip")
    void byIp() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location expected = new Location(("New York"), Country.USA, "Wall Street", 26);
        Location actual = geoService.byIp("96.0.0.1 ");
        assertEquals(expected.getCity(), actual.getCity());
        assertEquals(expected.getCountry(), actual.getCountry());
    }
}