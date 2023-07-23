import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TestMessageSender {




    @Test
    void Test () {
        Location local = Mockito.mock(Location.class);
        when(local.getCountry())
                .thenReturn(Country.valueOf("USA"));

        GeoService geo = Mockito.mock(GeoService.class);
        when(geo.byIp((String) any()))
                .thenReturn(local);

        LocalizationService locServ = Mockito.mock(LocalizationService.class);
        when(locServ.locale(local.getCountry()))
                .thenReturn("RUSSIA");

        MessageSenderImpl message = new MessageSenderImpl(geo,locServ);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("1", "2");
        assertEquals("RUSSIA",message.send(headers));

    }

    @Test
    public void TestReturnMessage() {
        LocalizationServiceImpl message = new LocalizationServiceImpl();
        assertEquals("Welcome", message.locale(Country.USA));
        assertEquals("Добро пожаловать", message.locale(Country.RUSSIA));
    }

    @Test
    void TestLocation (){
        GeoServiceImpl geo = new GeoServiceImpl();
        assertEquals(Country.USA, geo.byIp("90.").getCountry());
        assertEquals(Country.RUSSIA, geo.byIp("180.").getCountry());

    }

}
