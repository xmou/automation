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
        setFieldValue("address.suburbPostcodeState", "2000, Sydney, NSW");
        setFieldValue("address.building", "Global Center");
        setFieldValue("address.unitDetails.unitNumber", "88");
        setFieldValue("address.levelDetails.levelNumber", "8");
        setFieldValue("address.streetDetails.streetNumber", "66");
        setFieldValue("address.streetDetails.streetName", "Clarence ST");

        Thread.sleep(3000);
    }

    private void setFieldValue(String id, String value) {
        driver.findElement(By.id(id)).sendKeys(value);
    }
}