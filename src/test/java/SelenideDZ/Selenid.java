package SelenideDZ;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Selenid {
    @Test
    void firstTest() {

        //Открыть страницу
        open("https://github.com/");
        //Поиск по слову selenide
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        //Открыть первую ссылку в поиске
        $$("ul.repo-list li").first().$("a").click();
        //Открыть wiki
        $("#wiki-tab").click();
        //"Показать еще 2 страницы"
        $(byText("Show 2 more pages…")).click();
        //Клик по SoftAssertions
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        //Проверить, что на странице есть раздел с кодом для JUnit5
        $("#wiki-content").shouldHave(text("Using JUnit5 extend test class:"));
    }
}

