package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;

import java.util.List;

public class SearchResultPage {
    WebDriver driver;
    By hotelsName = By.cssSelector(".sr-hotel__name");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void hotelShouldBeInTheList(String hotelName){
        boolean isFound = false;
        try {
            Thread.sleep(10000);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        List<WebElement> hotels = driver.findElements(hotelsName);
        for(WebElement element : hotels) {
            isFound = element.getText().equals(hotelName);
            if(isFound) {
                break;
            }
        }
        Assert.assertTrue(isFound, "Отель не найден");
    }

    public void hasRating() {
        WebElement rating = driver.findElement(By.xpath("//span[contains(text(),'Alfa Radon')]/../../../../..//div[contains(text(),'9.2')]"));
        String value = rating.getText();
        assertEquals(value, "9.2", "Rating is not 9.2");
    }
}
