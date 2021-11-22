package guru.qa;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PageObject {
    String URL = "https://github.com/qa-guru";
    SelenideElement reposFilter = $("#your-repos-filter");
    ElementsCollection repositorySearchResult = $$("a");
    SelenideElement checkingTextOnPage = $("a.Link--primary.markdown-title");
    SelenideElement checkingTitle = $("strong.mr-2.flex-self-stretch");
    String repoName = "qa_guru_9_8_files";
    String checkingText = "JUnit 5 examples";
}
