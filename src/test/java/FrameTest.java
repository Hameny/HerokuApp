import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

  @Test
  public void checkFrames() {
    driver.get("https://the-internet.herokuapp.com/iframe");
    driver.findElement(By.xpath("/html/body/div[4]/div/div/button")).click();
    driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
    WebElement iframeElement = driver.findElement(
        By.xpath("//p[text()='Your content goes here.']"));
    String iframeText = iframeElement.getText();

    assertEquals(iframeText, "Your content goes here.", "Не выполнено,ошибка");
  }
}