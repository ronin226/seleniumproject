import com.codeborne.selenide.Selenide;
        import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.time.temporal.ChronoUnit.SECONDS;


public class MailTest {

    @Test
    public void test() {

        Selenide.open("https://mail.ru/");

        $(".ph-login").click();
        switchTo().frame($$("iframe").filter(attributeMatching("src", ".*login.*")).first());
        $("[name=\"username\"]").sendKeys("twelvem125");
        $("[data-test-id=\"next-button\"]").click();
        $("[name=\"password\"]").sendKeys("123qweASD4rf");
        $("[data-test-id=\"submit-button\"]").click();
        $$(".ll-sj__normal")
                .shouldHave(sizeGreaterThan(0), Duration.of(10, SECONDS))
                .last().click();
        $(".thread-subject").shouldHave(text("Добро пожаловать"));
    }
}