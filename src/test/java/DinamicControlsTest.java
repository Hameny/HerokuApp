import static org.testng.Assert.assertFalse;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DinamicControlsTest extends BaseTest {

  @Test
  public void checkDynamicControls() {
    driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    driver.findElement(By.xpath("//button[text()='Remove']")).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
    wait.until(
        ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@type = 'checkbox']")));
    WebElement isFiledEnabled = driver.findElement(By.xpath("//input[@type = 'text']"));

    assertFalse(isFiledEnabled.isEnabled());

    driver.findElement(By.xpath("//button[text()='Enable']")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type = 'text']")));
  }
}
