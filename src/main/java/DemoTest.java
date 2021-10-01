import environment.EnviromentManager;
import environment.RunEnvironment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class DemoTest {

    @Before
    public void startBrowser() throws MalformedURLException {
        EnviromentManager.initWebDriver();
    }

    @Test
    public void demo()  {
        WebDriver driver = RunEnvironment.getWebDriver();
    //    driver.get("http://jenkins-m-cs-01.dccs.cartasi.local:4444/wd/hub");
        driver.get("https://www.google.it");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement el = driver.findElement(By.xpath("//*[@id='L2AGLb']/div"));
        el.click();

        WebElement el1 = driver.findElement(By.name("q"));
        el1.click();
        el1.sendKeys("Nexi");

        WebElement el2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/ul/li[1]/div/div[2]/div[1]/span"));
        el2.click();

        WebElement el3 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/h3"));
        el3.click();

        String homeUrl = driver.getTitle();
        System.out.println(homeUrl);
    }

    @After
    public void tearDown() {
        EnviromentManager.shutDownDriver();
    }
}
