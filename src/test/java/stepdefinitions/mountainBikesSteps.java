package stepdefinitions;

import enums.ExpectedConditionType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pom.Bikespom;

import java.time.Duration;
import java.util.List;

public class mountainBikesSteps extends BaseMethods {
    Bikespom bikespom;

    {

        bikespom = Bikespom.getInstance();
    }

    @Given("User is in {string} website")
    public void userIsInWebsite(String arg0) {

        driver.get("https://demos.telerik.com/aspnet-core/eshop");
    }

    @When("click login btn")
    public void clickLoginBtn() {

        getElement(bikespom.getLoginBtn()).click();
    }

    @And("User hover categories button")
    public void userHoverCategoriesButton() {
        Actions actions = new Actions(driver);
        WebElement element = getElement(bikespom.getCtgrBtn());
        actions.moveToElement(element).click().perform();
    }

    @And("User clicks Bikes button")
    public void userClicksBikesButton() {
        getElement(bikespom.getBike()).click();
    }

    @And("User clicks Mountain Bikes button")
    public void userClicksMountainBikesButton() {
        getElement(bikespom.getMountainBike()).click();
    }
    @And("Clicks Discounted items only")
    public void clicksDiscountedItemsOnly() {
      getElement(bikespom.getDiscBtn()).click();
    }
    @Then("discounted item should be displayed on the page")
    public void discountedItemShouldBeDisplayedOnThePage() {
        List<WebElement> elements = driver.findElements(By.className("discount-pct"));
        for (WebElement element : elements) {
            String actualtext = element.getText();
            String expectedtext = "20% off";
            Assert.assertEquals(actualtext, expectedtext);
        }
    }

    @And("Clicks {string} {string} filter checkbox")
    public void clicksFilterCheckbox(String s, String locator) {
        String[] array = s.split("&");
        String loc = "//*[@id='" + locator + "Picker']//li";
        By checkboxLoc = By.xpath(loc);
        getWait();
        List<WebElement> elements = getElements(checkboxLoc);

        for (WebElement element : elements) {
            for(int i = 0 ; i<array.length; i++){
                if (element.getText().equalsIgnoreCase(array[i])) {
                    element.findElement(By.tagName("input")).click();
                }
            }

            }
        }
    @Then("user should  see {string} items on the page")
    public void userShouldSeeItemsOnThePage(String s) throws InterruptedException {
        Thread.sleep(2000);
        explicitWait(bikespom.getPagesize() , ExpectedConditionType.VISIBLE , 30);
        getElement(bikespom.getPagesize()).click();
        getJsExecutor().executeScript("arguments[0].click();",getElement(bikespom.getPagesize48()));
        String[] array = s.split("&");


        List<WebElement> elements = getElements(bikespom.getText());
        for (WebElement element : elements) {
            for (int i = 0; i < array.length; i++) {
                boolean flag = false;
                if (element.getText().contains(s)) {
                    flag = true;
                }
                Assert.assertTrue(flag);
            }
        }
    }
    @Given("User want to see rating")
    public void userWantToSeeRating() {
    }

    @And("User Clicks {string} radio button")
    public void userClicksRadioButton(String value) throws InterruptedException {
        Thread.sleep(5000);
        String[] array = value.split("&");
        for (String a : array) {
            String locator = bikespom.getRatingCheckboxes();
            locator = locator.replace("rate", a);
            getJsExecutor().executeScript("arguments[0].click();", getElement(By.xpath(locator)));
        }

    }

    @Then("user should see  {string}  stars bikes on the page")
    public void userShouldSeeStarsBikesOnThePage(String rating) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> elements = getElements(By.className("avg-rating"));
        for(WebElement element: elements) {
            Assert.assertTrue(element.getText().toLowerCase().contains(rating.toLowerCase()));
        }
    }


    @When("User choose price interval from {string} {string}")
    public void userChoosePriceIntervalFrom(String from, String to ) {
        getWait();
       String s = bikespom.getPriceTab();
       s=s.replace("price", "$"+ from);
       getAction().dragAndDrop(getElement(bikespom.getFromCircle()), getElement(By.xpath(s))).perform();

        String s2 = bikespom.getPriceTab();
        s2=s2.replace("price", "$"+ to);
        getAction().dragAndDrop(getElement(bikespom.getToCircle()), getElement(By.xpath(s2))).perform();

    }

    @Then("user should  see {string} {string} items on the page")
    public void userShouldSeeAndItemsOnThePage(String from, String to) throws InterruptedException {
        Thread.sleep(3000);
    double fromNum = Double.parseDouble(from.replace(",","").replace("$",""));
    double toNum = Double.parseDouble(to.replace(",","").replace("$",""));
    List<WebElement> list = getElements(bikespom.getPriceText());
    for(WebElement element: list){
        double price =Double.parseDouble(element.getText().replace(",", "").replace("$",""));
        Assert.assertTrue(fromNum<=price && fromNum<=toNum);
    }



    }
}