package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class HW9_ParameterizedTest {

    String URL = "https://github.com/qa-guru";
    SelenideElement reposFilter = $("#your-repos-filter");
    ElementsCollection repositorySearchResult = $$("a");
    ElementsCollection checkingTextOnPage = $$("Box-header position-relative");
    String repoName = "qa_guru_9_8_files";
    String checkingText = "JUnit 5 examples";

    @DisplayName("Поиск в github репозитория qa_guru_9_8_files")
    @Tag("blocker")
    @Test
    void selenideSearchTest() {
        open(URL);
        reposFilter
                .scrollTo()
                .setValue(repoName);
        repositorySearchResult.find(Condition.text(repoName)).click();
        checkingTextOnPage.find(Condition.text(checkingText));

    }
}
