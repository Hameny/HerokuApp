import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {
  WebDriver driver;

  @Test
  public void checkContextMenu() {
    driver.get("https://the-internet.herokuapp.com/context_menu");
    Actions actions = new Actions(driver);
    actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();
    //переключаемся в Alert (как в frame)
    String alertText = driver.switchTo().alert().getText();
    assertEquals(alertText, "You selected a context menu");
  }

}
