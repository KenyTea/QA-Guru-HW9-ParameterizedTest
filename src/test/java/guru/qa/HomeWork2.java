package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.*;
//import org.junit.jupiter.rules.TestRule;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork2 {
//    @Rule
//    public  TestRule report = new TestReporter();



    @BeforeAll
    static void beforeAll() {
        System.out.println("This is the before all method!");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("This is the after all method!");
    }

    @BeforeEach
    void openYandex() {
        System.out.println("        open(\"ya.ru\")");
    }

    @AfterEach
    void takeScreen() {
        System.out.println("        takeScreen();");
    }

    @Test
    void firstTest() {
        // Открываем браузер
        open("https://demoqa.com/automation-practice-form");

        // Проверяем дто страница загрузилась
        $(byText("Student Registration Form")).shouldBe(Condition.visible);
        //$(byText("Student Registration Form")).waitUntil(Condition.visible,50000);
        // Заполняем поле firstName
        $("#firstName").setValue("Alex");
        // Заполняем поле lastName
        $("#lastName").setValue("Vass");
        // Заполняем поле userEmail
        $("#userEmail").setValue("Vass@gmail.com");
        // Кликаем Gender radio button
        $(byText("Male")).click();
        // Заполняем поле Mobile(10 Digits)
        $("#userNumber").setValue("+77773557777");//.pressTab();
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

        // Заполняем поле Subjects
        //$("#subjectsContainer").scrollTo();
        $("#subjectsContainer").click();
        $("#subjectsContainer").pressEnter();
        //$x("//div[@id='subjectsContainer']").pressEnter();
        //$("#example-modal-sizes-title-lg").shouldBe(Condition.text("Thanks for submitting the form"));
        // Кликаем Hobbies checkbox
        //$("#custom-control-label").scrollTo();
        //$("#custom-control-label").click();

    }




}
