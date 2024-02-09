import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class testNG {

    WebDriver driver;

    @BeforeClass
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "C:\\chromedriver_win32\\edgedriver_win64\\msedgedriver.exe");

        driver = new EdgeDriver();

        driver.get("https://www.igp.com");

        Thread.sleep(3000);

        driver.manage().window().maximize();

    }

   @Test(priority = 1)
   public void testHome() throws InterruptedException, IOException {

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileHandler.copy(screenshot, new File("C:\\Users\\Admin\\Pictures\\Saved Pictures\\pic01.jpg"));

        driver.findElement(By.id("img-black")).click();

       driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

   }

   @Test(priority = 2)
   public void profile() throws InterruptedException, IOException {

       WebElement emailText = driver.findElement(By.id("email"));

       emailText.sendKeys("testmaqsood@maqsood.com");

       WebElement passwordText = driver.findElement(By.id("passwd"));

       passwordText.sendKeys("maqsood@3214");

       File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

       FileHandler.copy(screenshot, new File("C:\\Users\\Admin\\Pictures\\Saved Pictures\\pic02.jpg"));

       WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

       submitButton.click();

       driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
   }

   @Test(priority = 3)
   public void searchFlower () throws IOException, InterruptedException {

        Thread.sleep(2000);

        WebElement search = driver.findElement(By.cssSelector("input[type='text']"));

        search.sendKeys("Flower");

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileHandler.copy(screenshot, new File("C:\\Users\\Admin\\Pictures\\Saved Pictures\\pic03.jpg"));

        driver.findElement(By.cssSelector("img[class='img-responsive']")).click();

       driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
   }

   @Test(priority = 4)
   public void selectFlower() throws IOException, InterruptedException {

       File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

       FileHandler.copy(screenshot, new File("C:\\Users\\Admin\\Pictures\\Saved Pictures\\pic04.jpg"));

        WebElement selectFlower = driver.findElement(By.cssSelector("span[class='sort-svg-new']"));

        selectFlower.click();

        WebElement chooseSort = driver.findElement(By.cssSelector("li[data-text='Price - Low to High']"));

        chooseSort.click();

       driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileHandler.copy(screenshot2, new File("C:\\Users\\Admin\\Pictures\\Saved Pictures\\pic05.jpg"));

       driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.findElement(By.id("openOverlay")).click();

        driver.findElement(By.xpath("//div[@id='show-more-type_of_flowers']")).click();

        driver.findElement(By.cssSelector("label[for='type_of_flowers-orchids']")).click();

        driver.findElement(By.id("closeaw")).click();

       driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,550)", "");

       Thread.sleep(2000);
        
        WebElement flower = driver.findElement(By.xpath("//a[@href='p-opulent-orchids-bouquet-109604']"));

        flower.click();

        //Thread.sleep(10000);

   }

   @Test(priority = 5)
   public void product() throws InterruptedException, IOException {

            //String mainWindowHandle = driver.getWindowHandle();

            //Thread.sleep(3000);

            Set<String> windowHandles = driver.getWindowHandles();
            //driver.navigate().refresh();

            for(String handle : windowHandles) {
                if (!handle.equals(driver.getWindowHandle())) {
                    driver.switchTo().window(handle);
                    break;
                }
            }

            JavascriptExecutor js = (JavascriptExecutor) driver;

            //driver.navigate().to("https://www.igp.com/p-opulent-orchids-bouquet-109604");

            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

           js.executeScript("window.scrollBy(0,350)", "");

           WebElement pincode = driver.findElement(By.cssSelector("input.onlyPincode.pincode-input.input-autocomplete-google-map.initialCheck.p-code-field.input.required.pincode.location-input.pincode-text.no-padding.text-center.Paragraph-16-M--Regular"));

           pincode.sendKeys("793108");

           //driver.findElement(By.cssSelector("button[id='pincode-check-btn' and text()='Check']")).click();

           File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

           FileHandler.copy(screenshot, new File("C:\\Users\\Admin\\Pictures\\Saved Pictures\\pic06.jpg"));

           //driver.navigate().refresh();

        Thread.sleep(3000);

            driver.findElement(By.cssSelector("input.onlyPincode.pincode-input.input-autocomplete-google-map.initialCheck.p-code-field.input.required.pincode.location-input.pincode-text.no-padding.text-center.Paragraph-16-M--Regular")).clear();

           pincode.sendKeys("400072");

           //driver.findElement(By.cssSelector("button[id='pincode-check-btn' and text()='Check']")).click();

       Thread.sleep(2000);

       //driver.findElement(By.xpath("//label[@for='Select_Date']")).click();

       //driver.findElement(By.xpath("//a[@href='#' and text()='12']")).click();

       Thread.sleep(2000);

       //driver.findElement(By.xpath("//span[@class='sddName del-select_last Paragraph-14-S--Regular del-select_0' and text()='Standard']")).click();

       //driver.findElement(By.id("timepicker")).click();

       //driver.findElement(By.cssSelector("option[value='38']")).click();

       File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

       FileHandler.copy(screenshot2, new File("C:\\Users\\Admin\\Pictures\\Saved Pictures\\pic07.jpg"));

       Thread.sleep(1000);
       }

       @Test(priority = 6)
       public void addCart() throws InterruptedException, IOException {

        WebElement addtoCart = driver.findElement(By.xpath("//*[@id=\"add-cart\"]"));

        addtoCart.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.id("close-modal")).click();

        Thread.sleep(1000);

        WebElement proceedCart = driver.findElement(By.xpath("//*[@id=\"add-cart\"]"));

        proceedCart.click();

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileHandler.copy(screenshot, new File("C:\\Users\\Admin\\Pictures\\Saved Pictures\\pic08.jpg"));

        Thread.sleep(5000);
       }

       @Test(priority = 7)
       public void checkout() throws IOException, InterruptedException {

        WebElement chkoutBtn = driver.findElement(By.xpath("//*[@id=\"enabled-button\"]/a"));

        chkoutBtn.click();

           File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

           FileHandler.copy(screenshot, new File("C:\\Users\\Admin\\Pictures\\Saved Pictures\\pic09.jpg"));

       }

       @Test(priority = 8)
       public void fillDetails() throws IOException, InterruptedException {

           //driver.navigate().to("https://www.igp.com/checkout#chkdelivery");

           //driver.findElement(By.xpath("//select[@class='select-gen']")).click();

           //WebElement element = new WebDriverWait(driver, Duration.ofSeconds(8))
                   //.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='fname']")));

           //element.sendKeys("test to not deliver");

           Thread.sleep(2000);

           WebElement fname = driver.findElement(By.name("fname"));
           Actions actions = new Actions(driver);
           actions.moveToElement(fname).click().sendKeys("test do not deliver").build().perform();

           //WebElement pcode = driver.findElement(By.name("pcode"));
           //Actions actions1 = new Actions(driver);
           //actions1.moveToElement(pcode).click().sendKeys(Keys.CONTROL, "110002").sendKeys(Keys.DELETE).sendKeys("400042").build().perform();

           WebElement addr = driver.findElement(By.name("saddr"));
           Actions actions2 = new Actions(driver);
           actions2.moveToElement(addr).click().sendKeys("test do not deliver").build().perform();

           WebElement newaddr = driver.findElement(By.name("saddr2"));
           Actions actions3 = new Actions(driver);
           actions3.moveToElement(newaddr).click().sendKeys("test do not deliver").build().perform();

           Thread.sleep(2000);

           WebElement mob = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
           Actions actions4 = new Actions(driver);
           actions4.moveToElement(mob).click().sendKeys("8899889988").build().perform();

           WebElement altmob = driver.findElement(By.cssSelector("input[placeholder='Alternate No. (Optional)']"));
           Actions actions5 = new Actions(driver);
           actions5.moveToElement(altmob).click().sendKeys("8237902588").build().perform();

           WebElement email = driver.findElement(By.cssSelector("input[placeholder='Recipient Email Id']"));
           Actions actions6 = new Actions(driver);
           actions6.moveToElement(email).click().sendKeys("test@test.com").build().perform();

           File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

           FileHandler.copy(screenshot, new File("C:\\Users\\Admin\\Pictures\\Saved Pictures\\pic10.jpg"));

           Thread.sleep(3000);

           WebElement submitbtn = driver.findElement(By.xpath("//button[@class='btn revamp-c-save-addr-btn address-save-btn z-depth-1 waves-effect revamp-c-save-addr-btn u-case deliver text-center c-save-addr-btn c-btn btn-red ' and text()='Save\n" +
                   "                                                    & Deliver']"));
           Actions actions7 = new Actions(driver);
           actions7.moveToElement(submitbtn).click().build().perform();

           Thread.sleep(1000);

           //driver.findElement(By.xpath("//a[@id='deliver-btn-7088865']")).click();

           JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("window.scrollBy(0,350)", "");

           Thread.sleep(2000);

           WebElement coupon = driver.findElement(By.xpath("//span[@class='coupon-form-focus Paragraph-12-XS--Semibold' and text()='Apply']"));

           coupon.click();

           driver.findElement(By.cssSelector("input[id='coupon']")).sendKeys("xyz");

           Thread.sleep(2000);

           driver.findElement(By.cssSelector("input[id='coupon']")).clear();

           driver.findElement(By.cssSelector("input[id='coupon']")).sendKeys("IGP10");

           Thread.sleep(3000);
       }

       @Test(priority = 9)
       public void makePayment() throws InterruptedException, IOException {

           File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

           FileHandler.copy(screenshot, new File("C:\\Users\\Admin\\Pictures\\Saved Pictures\\pic11.jpg"));

        driver.findElement(By.xpath("//div[@class='payment-option-type  Paragraph-14-S--Semibold ' and text()= '\n" +
                "                                                    UPI\n" +
                "                                                ']")).click();

        WebElement paymentbtn = driver.findElement(By.xpath("//div[@class='btn btn-blue text-center card-edit-btn btn-red revamp-submit-btn' and text()='MAKE\n" +
                "                                                                PAYMENT']"));

        paymentbtn.click();

        Thread.sleep(10000);

       }

       @AfterClass
       public void endTest () {
           driver.close();

           driver.quit();
   }
}
