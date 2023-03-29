package pages;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class PageBase {

    public WebElement getRandomElement(List<WebElement> elements){
        return elements.get(new Random().nextInt(elements.size()));
    }
}