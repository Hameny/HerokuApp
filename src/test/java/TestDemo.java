import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestDemo {


  @Test
  public void seleniumTest() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://the-enternet.herokuapp.com/");

    driver.quit();
  }
}
