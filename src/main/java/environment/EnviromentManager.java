package environment;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class EnviromentManager {

    public static void initWebDriver() throws MalformedURLException {
        String whereDriver = "local";
        String p1 = "webdriver.chrome.driver";
        String p2 = "C:\\Users\\donzella.TXTGROUP\\OneDrive - TXT e-solutions S.p.A\\Desktop\\Selenium\\chromedriver.exe";
        System.setProperty(p1, p2);
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
