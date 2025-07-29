import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class TestDemo {


  @Test
  public void seleniumTest() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");//максимальный экран
    options.addArguments("--incognito");//инкогнито
    options.addArguments("--disable-notification");//убрать уведомленияя
    options.addArguments("--headless");//без открытия интерфейса
    options.addArguments("--headless");//без открытия интерфейса


    WebDriver driver = new ChromeDriver();
    driver.get("https://the-enternet.herokuapp.com/");

    driver.quit();
  }
}
