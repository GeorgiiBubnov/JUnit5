package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchPage {

    private SelenideElement inputSearch = $("#mod_search_searchword"),
            checkExpectedLink = $(".result-title:nth-child(1) > a");

    private ElementsCollection checkResult = $$("[class='search-results']");


    public SearchPage openPage() {
        open("https://www.1spbgmu.ru/");

        return this;
    }

    public SearchPage inputSearch(String text) {
        inputSearch.setValue(text).pressEnter();

        return this;
    }

    public SearchPage checkResult() {
        checkResult.shouldBe(CollectionCondition.sizeGreaterThan(0));

        return this;

    }

    public SearchPage checkExpectedLink(String text) {
        checkExpectedLink.shouldHave(text(text));

        return this;
    }
}
