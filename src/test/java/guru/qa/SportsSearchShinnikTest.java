package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;

public class SportsSearchShinnikTest {
    @BeforeEach
    void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        open("https://www.sports.ru/");

    }

    @CsvFileSource(resources = "/test_data/sportsSearch.csv")
    @ParameterizedTest(name = "При поиске по команде {0} в результатах находим ссылку на {1}")
    @Tag("SearchSports.ru")
    void succcessfulSearchShinnik(String searchQuery0, String expectedLink0) {
        $(".navigation-search__toggle").click();
        $(".navigation-search__input").click();
        $(".navigation-search__input").setValue(searchQuery0).pressEnter();
        $("class=\"overBox\"").$("titleH1").find(byLinkText(expectedLink0));
    }

}
