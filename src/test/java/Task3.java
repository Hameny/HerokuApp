import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task3 {

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

    driver.get("http://the-internet.herokuapp.com/dropdown");

    WebElement dropdownElement = driver.findElement(By.id("dropdown"));
    Select dropdown = new Select(dropdownElement);
    List<WebElement> dropdownOptions = dropdown.getOptions();

    Assert.assertEquals(dropdownOptions.size(), 3);

    dropdown.selectByIndex(1);
    WebElement selectedOptionFirst = dropdown.getFirstSelectedOption();

    softAssert.assertEquals(selectedOptionFirst.getText(), "Option 1");

    dropdown.selectByIndex(2);
    WebElement selectedOptionSecond = dropdown.getFirstSelectedOption();

    softAssert.assertEquals(selectedOptionSecond.getText(), "Option 2");
    softAssert.assertAll();

    driver.quit();
  }
}
