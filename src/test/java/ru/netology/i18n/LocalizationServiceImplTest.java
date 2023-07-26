package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import static org.junit.jupiter.api.Assertions.*;
public class LocalizationServiceImplTest {

    @Test
    public void localizationServiceImplTest() {
        LocalizationServiceImpl message = new LocalizationServiceImpl();
        assertEquals("Добро пожаловать", message.locale(Country.RUSSIA));
    }
}


