package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork2 {
//    @Rule
//    public  TestRule report = new TestReporter();


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
        $("#userNumber").setValue("7773557777");//.pressTab();
        $("#userNumber").scrollTo();

        // Заполняем поле Date of Birth
        //$("#dateOfBirthInput").scrollTo();
        //$("#dateOfBirthInput").click();
        //$("#dateOfBirthInput").pressEnter();

        //switchTo().frame($("#react-datepicker"));
//        //$("#dateOfBirthInput").setValue("15 Jun 1982").pressEnter();
//        $("#react-datepicker__month-select").selectOption(5);
//        $("#react-datepicker__year-select").selectOption(1982);
//        $("#react-datepicker__day react-datepicker__day--015").click();
       // сначала кликнул на само поле, потом нашел селектор на ввод месяца, через selectOptionByValue передал туда велью месяца, потом нашел селектор на ввод года, через selectOptionByValue передал велью года
        //ну а день ввел так: $$(".react-datepicker__day").find(text("25")).click();

        // Заполняем поле Subjects
        //$("#subjectsContainer").click();
        //$("#subjectsContainer").pressTab();

        // Кликаем Hobbies checkbox
        $(byText("Sports")).click();

        // Загрузка картинки
        $("#uploadPicture").uploadFile(new File("D:\\QA guru\\p1.PNG"));
        //$("#uploadPicture").uploadFile(new File("C:\\IdeaProjects\\qa_guru9_hw2\\p1.PNG"));

        // Заполнение Current Address
        $("#currentAddress").setValue("sssss");

        //
        $(byText("Select State")).click();
        $("#css-1uccc91-singleValue").click();


        sleep(5000);

    }




}
