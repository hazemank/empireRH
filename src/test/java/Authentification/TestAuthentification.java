package Authentification;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestAuthentification {

   @Test
    public void testAuthentification_failed(){
       System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
       WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();

       driver.get("https://demo.itgate-group.com/");

       // find element input mail
       WebElement username= driver.findElement(By.name("email"));
       username.sendKeys("blablabla@gmail.com");

       // find element input password
       WebElement password= driver.findElement(By.name("password"));
       password.sendKeys("blablabla");

       // Find the login button and click it
       WebElement loginButton = driver.findElement(By.name("login"));
       loginButton.click();

       WebElement errorMessage = driver.findElement(By.id("swal2-title"));
       assertEquals("error",errorMessage.getText());
       driver.quit();

    }
   @Test
    public void testAuthentification_success(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.itgate-group.com/");

        // find element input mail
        WebElement username= driver.findElement(By.name("email"));
        username.sendKeys("Manel@gmail.com");


        // find element input password
        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("manel");

        // Find the login button and click it
        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();
       // Wait for the element to be present
       // Wait for the element to be present and then click it
       WebDriverWait wait = new WebDriverWait(driver, 3);
       WebElement logoutAvatar = wait.until(ExpectedConditions.elementToBeClickable(
               By.className("avatar-online")));
       assertTrue(logoutAvatar.isDisplayed());
       driver.quit();

   }
}
