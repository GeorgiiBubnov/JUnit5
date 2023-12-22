package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private ElementsCollection languageElement = $$("ul li"),
            buttons = $$(".menu li.deeper:not(.nav-child");
    private SelenideElement title = $("h1");

    public MainPage openPage() {
        open("https://www.1spbgmu.ru/");

        return this;
    }

    public MainPage chooseLanguage(String text) {
        languageElement.find(Condition.text(text)).click();

        return this;
    }

    public MainPage checkTitle(String text) {
        title.shouldHave(Condition.text(text));

        return this;
    }

    public MainPage checkButtons(List<String> text) {
        buttons.shouldHave(texts(text));

        return this;
    }
}
