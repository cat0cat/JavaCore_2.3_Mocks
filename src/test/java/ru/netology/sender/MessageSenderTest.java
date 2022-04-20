package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

class MessageSenderTest {
    Map<String, String> map;
    GeoService geoService;
    LocalizationService localizationService;
    MessageSender messageSender;

    @BeforeEach
    void setUp() {
        map = new HashMap<>();
        geoService = Mockito.mock(GeoService.class);
        localizationService = Mockito.mock(LocalizationService.class);
        messageSender = new MessageSenderImpl(geoService,localizationService);
    }

    @Test
    @DisplayName("IP в России")
    void sendMessageRussia() {
        Mockito.when(geoService.byIp("172.0.32.11"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn( "Добро пожаловать");
        map.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");
        String expected = "Добро пожаловать";
        String actual = messageSender.send(map);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("IP в США")
    void sendMessageUSA() {
        Mockito.when(geoService.byIp("96.44.183.149"))
                .thenReturn(new Location("New York", Country.USA, null, 0));
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn( "Welcome");
        map.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        String expected = "Welcome";
        String actual = messageSender.send(map);
        Assertions.assertEquals(expected, actual);
    }

}
