package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;

public class AvitoSearchTests {
    @BeforeEach
    void setUp(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        open("https://www.avito.ru/");

    }
    @ValueSource(strings = {
         "play station 4", "play station 5"
    })
    @Test
    @Tag("Search")
    @ParameterizedTest(name = "Поиск {0} даёт результаты")
    void succcessfulSearchTest(String searchQueary) {
        $(".input-input-Zpzc1").setValue(searchQueary).pressEnter();
        $("[data-marker=\"page-title/count\"]");

    }
}
