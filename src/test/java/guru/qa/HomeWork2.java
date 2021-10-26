package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork2 {
//    @Rule
//    public  TestRule report = new TestReporter();

    @BeforeEach
    void config() {
        Configuration.startMaximized = true;
    }

    @Test
    void firstTest() {

        // Открываем браузер
        open("https://demoqa.com/automation-practice-form");

        // Проверяем дто страница загрузилась
        //$(byText("Student Registration Form")).shouldBe(Condition.visible);
        $(byText("Student Registration Form")).shouldBe(Condition.visible, Duration.ofMillis(25_000));
        // Заполняем поле firstName
        $("#firstName").setValue("Alex");
        // Заполняем поле lastName
        $("#lastName").setValue("Vass");
        // Заполняем поле userEmail
        $("#userEmail").setValue("Vass@gmail.com");
        // Кликаем Gender radio button
        $(byText("Male")).click();
        // Заполняем поле Mobile(10 Digits)
        $("#userNumber").setValue("7773557777");

        // Заполняем поле Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("5");
        $(".react-datepicker__year-select").selectOptionByValue("1982");
        $$(".react-datepicker__day").find(text("15")).click();

        // Заполняем поле Subjects
        //$("#subjectsInput").scrollTo();
        $("#subjectsInput").click();
        $("#subjectsInput").sendKeys("e");
        $(byText("English")).click();

        // Кликаем Hobbies checkbox
        $(byText("Sports")).click();

        // Загрузка картинки
        $("#uploadPicture").uploadFile(new File("src\\test\\p1.PNG"));

        // Заполнение Current Address
        $("#currentAddress").scrollTo();
        $("#currentAddress").setValue("sssss");

        // Select state
        $("#state").click();
        $(byText("NCR")).click();

        //Select City
        $("#city").click();
        $(byText("Gurgaon")).click();

        // Нажименм кнопку Subjects
        $("#submit").click();

        // Проверка заполнения
        validation("Student Name","Alex Vass");
        validation("Student Email","Vass@gmail.com");
        validation("Student Email","Vass@gmail.com");
        validation("Gender","Male");
        validation("Mobile","7773557777");
        validation("Date of Birth","15 June,1982");
        validation("Subjects","English");
        validation("Hobbies","Sports");
        validation("Hobbies","Sports");
        validation("Picture","p1.PNG");
        validation("Address","sssss");
        validation("State and City","NCR Gurgaon");

        // Для проверки
        sleep(2000);

    }

    void validation(String label, String value) {
        $(".table-responsive").$(byText(label)).parent().shouldHave(text(value));
    }


}
