import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FitPeoAutomationAssigment {
	
	public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();

       try {
            
    	   driver.manage().window().maximize();

            
            driver.get("https://www.fitpeo.com");
            
            Thread.sleep(1000);
            WebElement revenueCalculatorLink = driver.findElement(By.linkText("Revenue Calculator"));
            revenueCalculatorLink.click();

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0,300)");
            
            Thread.sleep(1000);
            WebElement slider = driver.findElement(By.xpath("//span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-1sfugkh']"));
            Actions actions = new Actions(driver);
            actions.clickAndHold(slider).moveByOffset(93, 0).release().perform();
            
            Thread.sleep(1000);
            WebElement sliderValueField = driver.findElement(By.xpath("//input[@type='number']"));
            String sliderValue = sliderValueField.getAttribute("value");
            if (!sliderValue.equals("820")) {
                System.out.println("Slider value did not update to 820. Actual value: " + sliderValue);
            } else {
                System.out.println("Slider value updated to 820 successfully.");
            }
            
          Thread.sleep(1000);
          Actions  action= new Actions(driver);
          action.click(sliderValueField).keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).sendKeys(Keys.DELETE).perform();
          sliderValueField.sendKeys("560");
          
          Thread.sleep(1000);
          String updatedSliderValue = sliderValueField.getAttribute("value");
          if (!updatedSliderValue.equals("560")) {
              System.out.println("Slider did not reflect the text field value. Actual value: " + updatedSliderValue);
          } else {
              System.out.println("Slider position updated successfully to 560.");
          }
          
          JavascriptExecutor jse = (JavascriptExecutor) driver;
          jse.executeScript("window.scrollTo(0,800)");


          Thread.sleep(1000);
          List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

          int[] indexesToSelect = {0,1, 2, 7}; 
          for (int i = 0; i < checkboxes.size(); i++) {
              for (int index : indexesToSelect) { 
            	  if (i == index) { 
            		  WebElement checkbox = checkboxes.get(i);
                      if (!checkbox.isSelected()) {
                          checkbox.click();
                      }
                  }
              }
          }  
          
          Thread.sleep(1000);
          WebElement reimbursementHeader = driver.findElement(By.cssSelector("body > div.MuiBox-root.css-3f59le > div.MuiBox-root.css-rfiegf > header > div > p:nth-child(4) > p"));
          String reimbursementValue = reimbursementHeader.getText();
          if (reimbursementValue.contains("$75600")) {
              System.out.println("Total Recurring Reimbursement validated successfully.");
          } else {
              System.out.println("Reimbursement validation failed. Actual value: " + reimbursementValue);
          }
      } catch (Exception e) {
          System.out.println("An error occurred: " + e.getMessage());
      } finally {
          
          driver.quit();
      }
  }

          

          }
                  

     
