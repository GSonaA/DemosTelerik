package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pom.Bikespom;
import pom.Clothespom;

import java.util.List;

public class jerseysClothesSteps extends BaseMethods {
    Clothespom clothespom;
   {

        clothespom= Clothespom.Instance;
    }
   @And("User clicks Clothes button")
    public void userClicksClothesButton(){
     getElement(clothespom.getClothesbtn()).click();
   }

    @And("User clicks Jerseys clothes")
    public void userClicksJerseysClothes() {
        getElement(clothespom.getJerseysclbtn()).click();
        
    }

    @Then("Jerseys clothes should be displayed on the page")
    public void jerseysClothesShouldBeDisplayedOnThePage() {
        
    }

    @And("User clicks discount item only radio button")
    public void userClicksDiscountItemOnlyRadioButton() {
    }

    @And("Clicks {string} filter checkboxes")
    public void clicksFilterCheckboxes(String model) {
       getWait();
        List<WebElement> elements = getElements(By.xpath("//*[@id='modelPicker']//li"));
        for(WebElement element: elements){
           element.findElement(By.tagName("index")); element.click();
            System.out.println(element.getText()+"____________");
        }
    }

    @Then("user should  see {string} items on the pages")
    public void userShouldSeeItemsOnThePages(String model) throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> elements = getElements(clothespom.getText());
        for(WebElement element: elements){
            Assert.assertTrue(element.getText().toLowerCase().contains(model.toLowerCase()));
        }
    }
}
