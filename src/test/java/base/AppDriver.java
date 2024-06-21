package base;

import org.openqa.selenium.WebDriver;

public class AppDriver {

   private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>(); // allows parallel test execution. Java class that provide thread variable to create
    // new thread a each instance.
   // private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver Driver) {
        driver.set(Driver);
        System.out.println("Driver is set");

    }
}
