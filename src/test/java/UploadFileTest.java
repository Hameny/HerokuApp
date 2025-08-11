import static org.testng.Assert.assertEquals;

import java.io.File;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class UploadFileTest extends BaseTest {

  @Test
  public void checkFileUpload() {
    File uploadFile = new File("src/test/resources/Text_test.rtf");
    driver.get("https://the-internet.herokuapp.com/upload");
    driver.findElement(By.id("file-upload")).sendKeys(uploadFile.getAbsolutePath());
    driver.findElement(By.id("file-submit")).click();
    String uploadedFile = driver.findElement(By.id("uploaded-files")).getText();
    assertEquals(uploadedFile, uploadFile.getName(), "наименование файла не совпало");
  }
}
