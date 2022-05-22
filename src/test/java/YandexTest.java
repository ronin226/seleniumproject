import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YandexTest {

    @Test
    public void test() {

        Selenide.open("https://yandex.ru/video/search?where=all&text=%D0%B2%D0%B8%D0%B4%D0%B5%D0%BE");

        $("[name=\"text\"]").sendKeys("storm");
        $("[type=\"submit\"]").click();
        $(".serp-item_pos_1").hover();
        $(".serp-item_pos_1").shouldHave(cssClass("thumb-preview_active_yes"));
        //$$("#search a>h3")
        //.shouldHave(size(8))
        //.filterBy(text("cheese"))
        //.shouldHave(size(8));
    }
}
