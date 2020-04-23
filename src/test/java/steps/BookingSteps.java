package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SearchPage;
import pages.SearchResultPage;

public class BookingSteps {
    String hotelName;
    SearchPage searchPage;
    SearchResultPage searchResultsPage;

    @Given("Hotel name is {string}")
    public void hotelNameIs(String hotelName) {
        this.hotelName = hotelName;
    }

    @When("User opens booking.com")
    public void userOpensBookingCom() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
        searchPage.openPage();
    }

    @And("Performs Search")
    public void performsSearch() {
        searchResultsPage = searchPage.searchHotel(hotelName);
    }

    @Then("Hotel {string} should be on the first page")
    public void hotelShouldBeOnTheFirstPage(String arg0) {
        searchResultsPage.hotelShouldBeInTheList(hotelName);
    }

    @And("has rating {string}")
    public void hasRating(String arg0) {
        searchResultsPage.hasRating();
    }
}
