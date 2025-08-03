import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1 {

  @Test
  public void seleniumTest() {

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

    driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

    WebElement button = driver.findElement(By.xpath("//button[text()='Add Element']"));
    button.click();
    button.click();
    List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));

    if (deleteButtons.size() == 2) {
      System.out.println("На странице найдено ровно 2 кнопки 'Delete'.");
    } else {
      System.out.println("Найдено " + deleteButtons.size() + " кнопок 'Delete'.");
    }
    Assert.assertEquals(deleteButtons.size(), 2);

    deleteButtons.get(0).click();
    deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));

    Assert.assertEquals(deleteButtons.size(), 1);

    driver.quit();
  }
}
