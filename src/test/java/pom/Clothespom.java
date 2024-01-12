package pom;

import lombok.Data;
import org.openqa.selenium.By;
@Data
public class Clothespom {
    private Clothespom (){
    }
    public static Clothespom Instance;
    private static Clothespom getInstance(){
        if(Instance != null){
            return getInstance();
        }else return new Clothespom();
    }

    protected final By clothesbtn = By.linkText("Clothes");
    protected  final By jerseysclbtn = By.xpath("(//div[contains(text(),'Jerseys')])[1]");
    protected final  By text         = By.className("card-title");
}
