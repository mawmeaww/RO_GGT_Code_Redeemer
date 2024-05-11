import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Redeemer {
    public static void main(String[] args) {
        // Set the path of EdgeDriver
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Administrator\\Desktop\\Ragnarok Online GGT Code Redeemer\\RO_GGT_Code_Redeemer\\msedgedriver.exe");

        // Initialize EdgeDriver
        WebDriver driver = new EdgeDriver();

        // Navigate to the website
        driver.get("https://www.gnjoy.in.th/Account/Login");

        // Locate the email and password fields and enter credentials
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("nonokub123@hotmail.com");
        delay();

        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Markmario02-");
        delay();

        WebElement submitButton = driver.findElement(By.id("btnSubmit"));
        submitButton.click();
        delay();

        // Locate and click on the redeem code button
        WebElement redeemButton = driver.findElement(By.linkText("เติมไอเท็มโค้ด"));
        redeemButton.click();
        delay();

        WebElement Class3 = driver.findElement(By.cssSelector("img[src=\"https://img.gnjoy.in.th/gnjoy/Images/iconragnarok.png\"]"));
        Class3.click();
        delay();

        Select id = new Select(driver.findElement(By.id("RagnarokOnlineAccountName")));
        id.selectByIndex(1);
        delay();

        Select server = new Select(driver.findElement(By.id("Hsid")));
        server.selectByIndex(1);
        delay();

        WebElement codeField = driver.findElement(By.id("Code"));
        codeField.sendKeys("0929-765D-4151-853B");
        delay();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        delay();

        driver.findElement(By.cssSelector(".recaptcha-checkbox-border")).click();
        delay();

        // Wait for the "ถัดไป" anchor element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.pt-4.col-8.text-center > a.btn-next.mx-2")));

        // Click on the "btnOk" element
        okButton.click();
    }

    private static void delay() {
        // Delay for 1 second
        try {
            Thread.sleep(1000); // 1000 milliseconds = 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
