package guru.qa;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

/*
Написать свои параметризованные тесты,
НЕ связанные с поиском в яндексе или гугле.
Помимо самих тестов, оформить тесткейсы к ним в текстовых файлах.

В идеале опробовать максимальное количество разных вариантов Argument-провайдеров (разные аннотации)
 */

public class HW9_ParameterizedTest {

    String URL = "https://github.com/qa-guru";
    SelenideElement reposFilter = $("#your-repos-filter");
    ElementsCollection repositorySearchResult = $$("a");
    SelenideElement checkingTextOnPage = $("a.Link--primary.markdown-title");
    SelenideElement checkingTitle = $("strong.mr-2.flex-self-stretch");
    String repoName = "qa_guru_9_8_files";
    String checkingText = "JUnit 5 examples";

    //@Disabled
    @DisplayName("Поиск в github репозитория qa_guru_9_8_files")
    @Tag("blocker")
    @Test
    void repositorySearchTest() {
        open(URL);
        reposFilter.scrollTo().setValue(repoName);
        repositorySearchResult.find(text(repoName)).click();
        checkingTextOnPage.shouldHave(text(checkingText));
    }

    @CsvSource(value = {
            "qa_guru_9_8_files~ JUnit 5 examples",
            "qa_guru_9_2_java~ java examples"
    },
            delimiter = '~')
    @DisplayName("Поиск в github")
    @Tag("blocker")
    @ParameterizedTest(name = "Поиск в github репозитория {0} и проверка отображения текста {1}")
    void selenideSearchTest(String repoName, String checkingText) {
        open(URL);
        reposFilter.scrollTo().setValue(repoName);
        repositorySearchResult.find(text(repoName)).click();
        checkingTextOnPage.shouldHave(text(checkingText));
    }

    @ValueSource(strings = {"qa_guru_9_8_files", "qa_guru_9_2_java"})
    @DisplayName("Поиск в github")
    @Tag("blocker")
    @ParameterizedTest(name = "Поиск в github репозитория {0}")
    void selenideSearchTest(String repoName) {
        open(URL);
        reposFilter.scrollTo().setValue(repoName);
        repositorySearchResult.find(text(repoName)).click();
        checkingTitle.shouldHave(text(repoName));
    }
}
