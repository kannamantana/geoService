package ru.netology.geo;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoServiceImplTest {
    @Test
    void geoServiceImplTest (){
        GeoServiceImpl geo = new GeoServiceImpl();
        assertEquals(Country.RUSSIA, geo.byIp("172.").getCountry());
    }
}
