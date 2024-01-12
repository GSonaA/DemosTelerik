package pom;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public class Bikespom {
    private Bikespom(){

    }
private static Bikespom Instance;
    public static Bikespom getInstance(){
        if(Instance != null){
            return Instance;
        } else return new Bikespom();
    }
    private final  By loginBtn     = By.className("k-button-md");
    private final  By ctgrBtn      = By.className("k-menu-link-text");
    private final  By Bike         = By.linkText("Bikes");
    private final  By MountainBike = By.linkText("Mountain Bikes");
    private final  By discBtn      = By.xpath("//*[@id ='discountPicker']//input[@value='2']");
    private final  By text         = By.className("card-title");
    private final  By roadBike     = By.linkText("Road Bikes");
    private final By pagesize = By.xpath("//*[@id=\"allProductsListView_pager\"]/span[1]/span/span[2]/span");
    private final By pagesize48 = By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/ul[1]/li[4]");
    private final String ratingCheckboxes = "//*[@id ='ratingPicker']//input[@value ='rate']";
    private final String priceTab = ("//*[@title ='price']");
    private final By fromCircle = By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[8]/div[2]/div[1]/div[1]/span[1]");
    private final By toCircle = By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[8]/div[2]/div[1]/div[1]/span[2]");
    private final By priceText = By.className("card-price");
}

