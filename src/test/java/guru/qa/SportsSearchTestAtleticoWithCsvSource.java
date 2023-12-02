package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SportsSearchTestAtleticoWithCsvSource {
    @BeforeEach
    void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        open("https://www.sports.ru/");

    }

    @CsvSource(value =
            {"Atletico Madrid, https://www.sports.ru/atletico/",
            "Спартак, https://www.sports.ru/spartak/ "})
    @ParameterizedTest(name = "При поиске по команде {0} в результатах находим ссылку на главную страницу {1}")
    @Tag("SearchSports.ru")
    void succcessfulSearchAtletico(String searchQuery, String expectedLink) {
        $(".navigation-search__toggle").click();
        $(".navigation-search__input").click();
        $(".navigation-search__input").setValue(searchQuery).pressEnter();
        $("class=\"overBox\"").$("titleH1").find(byLinkText(expectedLink));
    }
}
