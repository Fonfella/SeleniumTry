package environment;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class EnviromentManager {

    public static void initWebDriver() throws IOException {
        Properties p = new Properties();
        p.load(new FileInputStream("src/main/java/Driver/app.properties"));
        String whereDriver = p.getProperty("whereDriver");

        String chromeDriver = p.getProperty("chromeDriver");
        String driverExecute = p.getProperty("driverExecute");
        System.setProperty(chromeDriver, driverExecute);
        URL url = new URL("http://localhost:4444/wd/hub");
    //    URL url = new URL("http://jenkins-m-cs-01.dccs.cartasi.local:4444/wd/hub");

        DesiredCapabilities dc = DesiredCapabilities.chrome();

        if (whereDriver.equals("local")) {
            WebDriver driver = new ChromeDriver();
            RunEnvironment.setWebDriver(driver);
        } else {
            RemoteWebDriver driver = new RemoteWebDriver(url , dc);
            RunEnvironment.setWebDriver(driver);
        }
    }

    public static void shutDownDriver() {
        RunEnvironment.getWebDriver().quit();
    }
}
