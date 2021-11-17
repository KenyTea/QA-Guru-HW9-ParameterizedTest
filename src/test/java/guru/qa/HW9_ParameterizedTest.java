package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class HW9_ParameterizedTest {

    @DisplayName("Поиск в github репозитория qa_guru_9_8_files")
    @Tag("blocker")
    @Test
    void selenideSearchTest() {
        open("https://github.com/qa-guru");
        $("#your-repos-filter").scrollTo();
        $("#your-repos-filter").setValue("qa_guru_9_8_files");
        // $("#your-repos-filter").click();
        $$("a").find(Condition.text("qa_guru_9_8_files")).click();
        $$("Box-header position-relative").find(Condition.text("JUnit 5 examples"));

    }
}
