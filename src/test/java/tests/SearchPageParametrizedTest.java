package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.SearchPage;


@DisplayName("Параметризированные вэб-тесты на сайт ПСПбГМУ")

public class SearchPageParametrizedTest {

    SearchPage searchPage = new SearchPage();


    @ValueSource(strings = {
            "heart", "brain", "сердце", "мозг"
    })
    @ParameterizedTest(name = "Поисковый запрос {0} не должен отдавать пустой список результатов")
    @DisplayName("Поисковый запрос не должен отдавать пустой список результатов")
    @Tags({
            @Tag("SMOKE"),
            @Tag("WEB")
    })
    void notEmptyCardListAfterSearch(String searchQuery) {
        searchPage.openPage()
                .inputSearch(searchQuery)
                .checkResult();

    }

    @CsvFileSource(resources = "/test_data/firstLinkAfterSearch.csv")
    @ParameterizedTest(name = "Для поискового запроса {0} в первой карточке должен быть текст {1}")
    @DisplayName("Поисковый запрос должен выдавать определенный текст")
    @Tags({
            @Tag("REGRESS"),
            @Tag("MOBILE")
    })
    void firstLinkAfterSearch(String searchQuery, String expectedLink) {
        searchPage.openPage()
                .inputSearch(searchQuery)
                .checkExpectedLink(expectedLink);

    }

}
