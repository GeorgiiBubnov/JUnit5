package tests;


import com.codeborne.selenide.Condition;
import data.Language;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.MainPage;

import java.util.List;
import java.util.stream.Stream;


@DisplayName("Параметризированные вэб-тесты на сайт ПСПбГМУ")

public class MainPageParametrizedTest {
    MainPage mainPage = new MainPage();

    @EnumSource(Language.class)
    @ParameterizedTest(name = "Заголовок страницы должен выводиться на соответствующем языке {0}")
    @DisplayName("Проверка наименования заголовка страницы для каждого языка")
    @Tags({
            @Tag("SMOKE"),
            @Tag("WEB")
    })
    void checkMainTitleOfLanguage(Language language) {
        mainPage.openPage()
                .chooseLanguage(language.name())
                .checkTitle(language.description);


    }

    static Stream<Arguments> checkDisplayCorrectButtons() {
        return Stream.of(
                Arguments.of(Language.RU,
                        List.of("Университет", "Образование", "Клиника", "Наука", "Международная деятельность",
                                "Общественная жизнь")),
                Arguments.of(Language.EN,
                        List.of("University", "Education", "Science and research", "International Collaboration",
                                "Graduates"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Кнопки меню должны выводиться на соответствующем языке {0}")
    @DisplayName("Проверка кнопок меню страницы для каждого языка")
    @Tags({
            @Tag("REGRESS"),
            @Tag("MOBILE")
    })
    void checkDisplayCorrectButtons(Language language, List<String> expectedButtons) {
        mainPage.openPage()
                .chooseLanguage(language.name())
                .checkButtons(expectedButtons);


    }
}
