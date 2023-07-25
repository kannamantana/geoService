package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class MessageSenderTest {

    @Test
    void messageSenderImplTest () {
        Location local = Mockito.mock(Location.class);
        when(local.getCountry())
                .thenReturn(Country.valueOf("USA"));

        GeoService geo = Mockito.mock(GeoService.class);
        when(geo.byIp(any()))
                .thenReturn(local);

        LocalizationService locServ = Mockito.mock(LocalizationService.class);
        when(locServ.locale(local.getCountry()))
                .thenReturn("RUSSIA");

        MessageSenderImpl message = new MessageSenderImpl(geo,locServ);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("1", "2");
        assertEquals("RUSSIA",message.send(headers));

    }



}
