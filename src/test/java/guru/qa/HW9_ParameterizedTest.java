package guru.qa;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static guru.qa.PageObject.URL;

/*
Написать свои параметризованные тесты,
НЕ связанные с поиском в яндексе или гугле.
Помимо самих тестов, оформить тесткейсы к ним в текстовых файлах.

В идеале опробовать максимальное количество разных вариантов Argument-провайдеров (разные аннотации)
 */

public class HW9_ParameterizedTest {

    /*
    Взять любое предыдущее ДЗ -> создать branch -> сделать три изменения тремя коммитами,
    сделать скрин git log, после чего обьединить три коммита в один общий (rebase -i ).
    Сделать пулл реквест на бранче.

    Разбиться на пары - сделать пулл реквест в чужой репо,
    с какими-нибудь изменениями в коде. Провести CR - написать комментарий, апрувнуть изменения.
     */

    PageObject pageObject = new PageObject();

    @Disabled
    @DisplayName("Поиск в github репозитория qa_guru_9_8_files")
    @Tag("blocker")
    @Test
    void repositorySearchTest() {
        open(URL);
        pageObject.reposFilter.scrollTo().setValue(pageObject.repoName);
        pageObject.repositorySearchResult.find(text(pageObject.repoName)).click();
        pageObject.checkingTextOnPage.shouldHave(text(pageObject.checkingText));
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
        pageObject.reposFilter.scrollTo().setValue(repoName);
        pageObject.repositorySearchResult.find(text(repoName)).click();
        pageObject.checkingTextOnPage.shouldHave(text(checkingText));
    }

    @ValueSource(strings = {"qa_guru_9_8_files", "qa_guru_9_2_java"})
    @DisplayName("Поиск в github")
    @Tag("blocker")
    @ParameterizedTest(name = "Поиск в github репозитория {0}")
    void selenideSearchTest(String repoName) {
        open(URL);
        pageObject.reposFilter.scrollTo().setValue(repoName);
        pageObject.repositorySearchResult.find(text(repoName)).click();
        pageObject.checkingTitle.shouldHave(text(repoName));
    }
}
