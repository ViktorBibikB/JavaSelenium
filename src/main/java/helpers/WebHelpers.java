package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebHelpers {
    public static void clickWebElementFromListByText(WebElement element, String text, String tagName) {
        List<WebElement> listSpanElements = element.findElements(By.tagName(tagName));

        for (WebElement elRequired : listSpanElements) {
            if (elRequired.getText().contains(text)) {
                elRequired.click();
                break;
            }
        }
    }
}
