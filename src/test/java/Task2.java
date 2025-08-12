import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task2 {

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
    //options.addArguments("--headless");//без открытия интерфейса
    WebDriver driver = new ChromeDriver(options);

    driver.get("http://the-internet.herokuapp.com/checkboxes");

    List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type=checkbox]"));
    WebElement firstCheckbox = checkboxes.get(0);
    WebElement secondCheckbox = checkboxes.get(1);

    softAssert.assertFalse(firstCheckbox.isSelected());
    firstCheckbox.click();
    softAssert.assertTrue(firstCheckbox.isSelected());
    softAssert.assertTrue(secondCheckbox.isSelected());
    secondCheckbox.click();
    softAssert.assertFalse(secondCheckbox.isSelected());
    softAssert.assertAll();

    driver.quit();
  }
}
