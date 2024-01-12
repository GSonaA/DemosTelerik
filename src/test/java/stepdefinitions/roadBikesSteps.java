package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pom.Bikespom;

import java.util.List;

public class roadBikesSteps extends BaseMethods{
Bikespom bikespom;
    public roadBikesSteps(){
        bikespom= Bikespom.getInstance();
    }
    @And("User clicks road bikes button")
    public void userClicksRoadBikesButton() {
     getElement(bikespom.getRoadBike()).click();
    }

    @Then("discounted road bikes item should be displayed on the page")
    public void discountedRoadBikesItemShouldBeDisplayedOnThePage() {
        boolean flag = true;
        List<WebElement> elements = driver.findElements(By.className("discount-pct"));
        for (WebElement element : elements) {
            String actualtext = element.getText();
            if((actualtext.equals("10% off")) || (actualtext.equals("20% off"))){
                flag=true;
            }else
            {
                flag=false;
                break;
            }
        }
        Assert.assertTrue(flag);
    }

    @When("User clicks road{int} radio button")
    public void userClicksRoadRadioButton(int arg0) {
       getWait();
      driver.findElement(By.cssSelector("[value='Road-150']")).click();

    }

    @Then("road{int} bikes should be displayed on the page")
    public void roadBikesShouldBeDisplayedOnThePage(int arg0) throws InterruptedException {
        Thread.sleep(15000);
       List<WebElement> elements = getElements(By.className("card-title"));
       for(WebElement element: elements){
         String actualtext = element.getText();
         Assert.assertTrue(actualtext.contains("Road-150"));
       }
    }

    @And("User clicks road twofivezero radio button")
    public void userClicksRoadTwofivezeroRadioButton() {
        getWait();
        driver.findElement(By.cssSelector("[value='Road-550']")).click();
    }

    @Then("road twofivezero bikes should be displayed on the page")
    public void roadTwofivezeroBikesShouldBeDisplayedOnThePage() throws InterruptedException {
        Thread.sleep(15000);
        List<WebElement> elements = getElements(By.className("card-title"));
        for(WebElement element: elements){
            String actualtext = element.getText();
            Assert.assertTrue(actualtext.contains("Road-250"));
        }
    }
}
