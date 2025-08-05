import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task5 {
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

    driver.get("http://the-internet.herokuapp.com/typos");
    List<WebElement> paragraphs = driver.findElements(By.tagName("p"));
    WebElement text = paragraphs.get(1);
    String testText = "Sometimes you'll see a typo, other times you won`t.";

    Assert.assertEquals(text.getText(),testText);

    driver.quit();
  }
}
