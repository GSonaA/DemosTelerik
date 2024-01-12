package stepdefinitions;

import driversession.Createdriversession;
import enums.ExpectedConditionType;
import net.bytebuddy.pool.TypePool;
import netscape.javascript.JSException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;
public class BaseMethods {
    WebDriverWait wait;

    protected WebDriver driver;
    private Actions actions;

    {
        driver = Createdriversession.driver;
    }

    protected void getWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
    }

    protected List<WebElement> getElements(By locater) {

        return driver.findElements(locater);
    }

    protected WebElement getElement(By locater) {
        return driver.findElement(locater);
    }

    protected void explicitWait(By locater, ExpectedConditionType expectedCondition, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        switch (expectedCondition) {

            case VISIBLE: {
                wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
                break;
            }
            case INVISIBLE: {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(locater));
                break;
            }
            case CLICKABLE: {
                wait.until(ExpectedConditions.elementToBeClickable(locater));
                break;
            }
            case PRESENCE: {
                wait.until(ExpectedConditions.presenceOfElementLocated(locater));
                break;
            }
            default:
                throw new IllegalArgumentException("Wrong");
        }
    }
    protected Actions getAction(){
        if(actions == null){
            actions= new Actions(driver);
        }
        return actions;
    }
    protected  void clickElementLocation(By locator){
        getAction().moveToElement(getElement(locator)).click().perform();
    }
protected JavascriptExecutor getJsExecutor(){
    return (JavascriptExecutor) driver;
}
}
