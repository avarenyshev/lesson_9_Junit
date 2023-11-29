package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Selenide.*;

public class AvitoSearchTest {
    @BeforeEach
    void setUp(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        open("https://www.avito.ru/");

    }
    @CsvFileSource(resources = "/test_data/avitoSearch.csv")
    @Test
    @Tag("Search")
    @ParameterizedTest(name = "Поиск {0} даёт результаты")
    void succcessfulSearchTest(String searchQueary) {
        $(".input-input-Zpzc1").setValue(searchQueary).pressEnter();
        $("[data-marker=\"page-title/count\"]");

    }
}
