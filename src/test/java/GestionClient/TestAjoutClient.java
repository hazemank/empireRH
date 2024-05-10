package GestionClient;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertEquals;

public class TestAjoutClient {

    @Test

    public void TestAjoutClient_success() {
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

        WebElement buttonAddEmploye = driver.findElement(By.className("add"));
        buttonAddEmploye.click();

        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_first_name")));
        firstName.sendKeys("ahmed");
        WebElement nom = driver.findElement(By.id("id_last_name"));
        nom.sendKeys("hamad");
        WebElement mail = driver.findElement(By.id("id_email"));
        mail.sendKeys("ahmed@gmail.com");
        WebElement phone = driver.findElement(By.id("id_phone"));
        phone.sendKeys("98984500");
        WebElement genderDropdown = driver.findElement(By.id("id_gender"));
        Select selectGender = new Select(genderDropdown);

        // Select the option "M" by its value
        selectGender.selectByValue("M");
        WebElement passwordEmploye = driver.findElement(By.id("id_password"));
        passwordEmploye.sendKeys("A1234567@");
        WebElement adress = driver.findElement(By.id("id_address"));
        adress.sendKeys("adress test");
        WebElement typeFormateur = driver.findElement(By.id("id_staff_type"));
        Select selectFormateur = new Select(typeFormateur);
        selectFormateur.selectByValue("Formateur interne");
        WebElement saveButton = driver.findElement(By.id("add-staff-btn"));
       saveButton.click();
        WebElement secondCellInFirstRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[@id='table-body']/tr[1]/td[2]"))); // Replace 'yourElementId' with the actual ID

assertEquals(firstName+" "+nom,secondCellInFirstRow.getText());
driver.quit();

    }
}
