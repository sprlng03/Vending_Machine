package th.ac.kmitl.se;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SystemTest {
    
    static WebDriver driver;

    @BeforeAll
    static public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://fekmitl.pythonanywhere.com/kratai-bin");
    }

    @Test
    public void test1() throws java.io.IOException {
        System.out.println("Test 1");
        WebElement login = driver.findElement(By.id("start"));
        login.click();
        //Wait for the next page
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("btn_cancel")));
        //Add Tum Thai and Tum Poo
        WebElement add_tum_thai_button = driver.findElement(By.id("add_tum_thai"));
        WebElement add_tum_poo_button = driver.findElement(By.id("add_tum_poo"));

        add_tum_thai_button.click();
        add_tum_thai_button.click();
        add_tum_poo_button.click();

        WebElement checkout_button = driver.findElement(By.id("btn_check_out"));
        checkout_button.click();

        WebElement confirm_button = driver.findElement(By.id("btn_confirm"));
        confirm_button.click();

        WebElement credit_card = driver.findElement(By.name("txt_credit_card_num"));
        credit_card.sendKeys("1234");

        WebElement name = driver.findElement(By.name("txt_name_on_card"));
        name.sendKeys("John");

        WebElement pay_button = driver.findElement(By.id("btn_pay"));
        pay_button.click();

        WebElement click_item = driver.findElement(By.className("ImgTumThai"));
        if(!click_item.isEmpty()) {
            click_item.click();
        }

        // Print the first result
        System.out.println(firstResult.getText());

    }


    @Test
    public void test2() throws java.io.IOException {
        System.out.println("Test 2");
        WebElement login = driver.findElement(By.id("start"));
        login.click();
        //Wait for the next page
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("btn_cancel")));
        //Add Tum Thai and Tum Poo
        WebElement add_tum_thai_button = driver.findElement(By.id("add_tum_thai"));
        WebElement add_tum_poo_button = driver.findElement(By.id("add_tum_poo"));
        
        //add maximum items
        add_tum_thai_button.click();
        add_tum_thai_button.click();
        add_tum_thai_button.click();
        add_tum_thai_button.click();



        // Print the first result
        System.out.println(firstResult.getText());

    
    }
}

