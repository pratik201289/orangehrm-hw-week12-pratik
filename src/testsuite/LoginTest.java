package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

  String baseUrl = "https://opensource-demo.orangehrmlive.com/";

  @Before
  public void setBaseUrl(){
   openBrowser(baseUrl);
  }
  @Test
  public void userShouldLoginSuccessfullyWithValidCredentials(){

      // Find the username field and send username
      sendTextToElement(By.name("username"), "Admin");

      // Find the password field and send password
      sendTextToElement(By.name("password"), "admin123");

      // Find the login button and click on it
      clickOnElement(By.xpath("//button[@type = 'submit']"));
      //This is from requirement
      String expectedText = "Dashboard";

      // Find the Dashboard text element and get the text
      String actualText = getTextFromElement(By.xpath("//span/h6[text() = 'Dashboard']"));

      // Verify the Dashboard text is displayed
      Assert.assertEquals("Dashboard text is not displayed",expectedText, actualText);
  }

    @After
    public void teardown(){
        closeBrowser();
    }


}
