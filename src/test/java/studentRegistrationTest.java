
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class studentRegistrationTest {

    private static WebDriver driver = null;

    @Test
    public void registerStudent() {

        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\Drivers\\ChromeDriver\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://demoqa.com/automation-practice-form");

        driver.manage().window().maximize();

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("FirstName");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("LastName");

        WebElement emailId = driver.findElement(By.id("userEmail"));
        emailId.sendKeys("testemail@test.com");

        Actions act =  new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//input[@id = 'gender-radio-1' and @value = 'Male']"))).click().perform();

        WebElement mobileNumber = driver.findElement(By.id("userNumber"));
        mobileNumber.sendKeys("9876543210");

        driver.findElement(By.id("dateOfBirthInput")).click();

        WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
        Select monthCombo = new Select(month);
        monthCombo.selectByVisibleText("March");

        WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
        Select yearCombo = new Select(year);
        yearCombo.selectByVisibleText("1995");

        driver.findElement(By.xpath("//div[@aria-label='Choose Tuesday, March 7th, 1995']")).click();

        driver.findElement(By.id("subjectsInput")).sendKeys("Maths");
        driver.findElement(By.id("subjectsInput")).sendKeys(Keys.TAB);

        Actions action =  new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//input[@id = 'hobbies-checkbox-1' and @value = '1']"))).click().perform();

        WebElement uploadFile = driver.findElement(By.id("uploadPicture"));
        uploadFile.sendKeys(System.getProperty("user.dir")+"\\src\\main\\resources\\Status Code - 200.png");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("231 , S D Road, Agra, Uttar Pradesh, 500003");


        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement selectState = driver.findElement(By.xpath("//div[@class=' css-1wa3eu0-placeholder' and text()='Select State']"));
        WebElement selectCity = driver.findElement(By.xpath("//div[@class=' css-1wa3eu0-placeholder' and text()='Select City']"));
        WebElement submit = driver.findElement(By.id("submit"));

        Actions actionBuilder = new Actions(driver);
        actionBuilder.click(selectState).sendKeys("NCR").sendKeys(Keys.ENTER)
                .click(selectCity).sendKeys("Delhi").sendKeys(Keys.TAB)
                .click(submit)
                .build()
                .perform();

        driver.quit();


    }
}
