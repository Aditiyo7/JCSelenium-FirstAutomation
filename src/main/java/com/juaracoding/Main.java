package com.juaracoding;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:\\MY DATA\\SQA\\Tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("Open Browser");
        driver.manage().window().maximize();
        JavascriptExecutor js =(JavascriptExecutor) driver;

        driver.get("https://shop.demoqa.com");
        System.out.println("Dashboard Page");
        System.out.println(driver.getTitle());

        //Go to Login page
        delay(3);
        js.executeScript("window.scrollBy(0,400)");
        driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[2]/a")).click();
        System.out.println("Go to Login Page");

        //Login Page
        js.executeScript("window.scrollBy(0,300)");
        delay(3);
        driver.findElement(By.id("username")).sendKeys("aditiyo.nugroho7");
        driver.findElement(By.id("password")).sendKeys("welocme@789");
        driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")).click();
        System.out.println("Button Login Clicked");

        //Order Page
        delay(3);
        js.executeScript("window.scrollBy(0,200)");
        driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/nav/ul/li[2]/a")).click();
        System.out.println("Link Order Clicked");

        //Browse Product Page
        delay(3);
        js.executeScript("window.scrollBy(0,100)");
        driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/div/div[2]/a")).click();
        System.out.println("Button Browse Product Clicked");

        //Product Chosen Page
        delay(3);
        js.executeScript("window.scrollBy(0,1000)");
        driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[5]/div")).click();
        System.out.println("Product Chosen");

        //List Dropdown For Color and Size
        delay(3);
        js.executeScript("window.scrollBy(0,700)");
        WebElement color = driver.findElement(By.id("pa_color"));
        WebElement size = driver.findElement(By.id("pa_size"));
        Select select = new Select(color);
        Select select1 = new Select (size);
        select.selectByValue("black");
        select1.selectByValue("medium");
        System.out.println("Product Color and Size Chosen");

        //Add to cart
        delay(3);
        driver.findElement(By.xpath("//*[@id=\"product-1225\"]/div[1]/div[2]/form/div/div[2]/button")).click();
        System.out.println("Product add to Cart");

        //View Cart
        delay(3);
        driver.findElement(By.id("nav-menu-item-cart")).click();
        js.executeScript("window.scrollBy(0,500)");
        System.out.println("Product added in cart");


        delay(5);
        driver.quit();
    }
    static void delay(long sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}