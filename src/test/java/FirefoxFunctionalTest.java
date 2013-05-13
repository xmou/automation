import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(BlockJUnit4ClassRunner.class)
public class FirefoxFunctionalTest extends TestCase {

    private WebDriver driver;

    @Before
    public void createDriver() {
        driver = new FirefoxDriver();
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void testLocal() throws Exception {
        driver.get("http://localhost:8080/automation/index.html");
        Thread.sleep(1000);
        setFieldValue("personName", "Biao Wang");
        setFieldValue("personPhone", "18683619867");
        setFieldValue("personWeibo", "@ibiaowang");
        setFieldValue("personGitHub", "biaowang");
        setFieldValue("automationBenifitOne", "Duplication");
        setFieldValue("automationBenifitTwo", "Productivity");

        Thread.sleep(3000);

        selectRadioButton("preferAutomationOption");

        Thread.sleep(3000);

    }

    private void setFieldValue(String id, String value) {
        driver.findElement(By.id(id)).sendKeys(value);
    }

    private void selectRadioButton(String id){
        driver.findElement(By.id(id)).click();
    }
}