import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task4 {

  SoftAssert softAssert = new SoftAssert();

  @Test
  public void checkingCheckboxes() {
    ChromeOptions options = new ChromeOptions();
    HashMap<String, Object> chromePrefs = new HashMap<>();
    chromePrefs.put("credentials_enable_service", false);
    chromePrefs.put("profile.password_manager_enabled", false);
    options.setExperimentalOption("prefs", chromePrefs);
    options.addArguments("--disable-popup-blocking");
    options.addArguments("--disable-infobars");
    options.addArguments("--start-maximized");//максимальный экран
    options.addArguments("--incognito");//инкогнито
    options.addArguments("--disable-notification");//убрать уведомленияя
    options.addArguments("--headless");//без открытия интерфейса
    WebDriver driver = new ChromeDriver(options);

    driver.get("http://the-internet.herokuapp.com/inputs");

    WebElement input = driver.findElement(By.tagName("input"));
    String testValues = "132";
    input.clear();
    input.sendKeys(testValues);
    input.sendKeys(Keys.ARROW_UP);
    String valueAfterUp = input.getAttribute("value");
    int valueAfterUpInt = Integer.parseInt(valueAfterUp);
    int expectedValueAfterUp = Integer.parseInt(testValues) + 1;

    softAssert.assertEquals(valueAfterUpInt, expectedValueAfterUp);

    input.sendKeys(Keys.ARROW_DOWN);
    String valueAfterDown = input.getAttribute("value");
    int valueAfterDownInt = Integer.parseInt(valueAfterDown);
    int expectedValueAfterDown = expectedValueAfterUp - 1;

    softAssert.assertEquals(valueAfterDownInt, expectedValueAfterDown);
    softAssert.assertAll();

    driver.quit();
  }
}