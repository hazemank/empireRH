package GestionClient;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestModifClient {

    @Test
    public void TestModifClient() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.itgate-group.com/");

        // find element input mail
        WebElement username = driver.findElement(By.name("email"));
        username.sendKeys("Manel@gmail.com");


        // find element input password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("manel");

        // Find the login button and click it
        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();



        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement gererEmployesLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@data-i18n='Gérer les employés']")));
        // Click the 'Gérer les employés' link
        gererEmployesLink.click();

        WebElement employesLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@data-i18n='Employés']")));
        employesLink.click();
        WebElement internesLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@data-i18n='Internes']")));
        internesLink.click();

        WebElement editLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@id='table-body']/tr[1]/td[9]//a[@title='Edit employé']")));
        Actions actions = new Actions(driver);
        actions.moveToElement(editLink).click().perform();
//modifier prenom
        WebElement firstNameInput = driver.findElement(By.id("id_first_name"));
        firstNameInput.clear();
        firstNameInput.sendKeys("ahmed_modifier");
driver.quit();
    }
}
