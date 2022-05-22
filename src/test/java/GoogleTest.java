import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleTest {

    @Test
    public void test() {

        Selenide.open ("https://www.google.com/");

        $("[autofocus]").sendKeys("cheese");
        $("[name =\"btnK\"]").click();
        $("#search a>h3").shouldHave(text("Cheese"));
        $$("#search a>h3")
                .shouldHave(size(8))
                .filterBy(text("cheese"))
                .shouldHave(size(8));

    }

}
