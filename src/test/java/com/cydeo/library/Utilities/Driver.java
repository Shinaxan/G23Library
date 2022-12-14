package com.cydeo.library.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    // private constructor , encapsulation , we are closing the access from outside the class , no more creation of this object
    // we have this empty constructor to prevent ppl to create another objects of that class, you will only be able to use getDriver method thats it
    private Driver(){}
    // We make WebDriver private, because we want to close access from outside of class
    // We make it static, because we will use it inside static method

    // the method is Public and the driver is privet

    // for the first time when i call driver it will be Null ,and will gonna be instantiated , so for the second time and after that it will not be null and we will keep using the same driver
   //private static WebDriver driver; // value is null by default

private static InheritableThreadLocal <WebDriver> driverPool = new InheritableThreadLocal<>();
    // we did the above InheritableThreadLocal (is giving me pool of drivers )
    // Create a re-usable utility method which will return same driver instance when we call it
    public static WebDriver getDriver() {

        // it will check if driver is null and if it is we will set up browser inside if statement
        // if you already setup driver and using it again for following line of codes, it will return to same driver
        if (driverPool.get() == null) {

            // We read browserType from configuration.properties with
            // help of ConfigurationReader class' getProperty() method
            String browserType = ConfigurationReader.getProperty("browser");


            switch(browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }

        }

        return driverPool.get();


    }

    // This method will make sure our driver value is always null after using quit() method
    public static void closeDriver(){
        if(driverPool.get() != null){
            driverPool.get().quit(); // this line will terminate the existing driver session. with using this driver will not be even null
            driverPool.remove();
        }

    }
}
