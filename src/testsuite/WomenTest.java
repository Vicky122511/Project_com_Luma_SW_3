package testsuite;

import browsefactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WomenTest extends BaseTest
{
    String baseurl = "https://magento.softwaretestingboard.com/";
    String expectedText,actualText;
    @Before
    public void setUp()
    {
        openBrowser(baseurl);
    }

    @Test
    public void verifyTheSortByProductNameFilter()
    {
        //Mouse Hover on Women Menu - tops - click on jacket
        WebElement women=driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
        WebElement jacket = driver.findElement(By.xpath("//a[@id='ui-id-11']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(women).build().perform();
        actions.moveToElement(tops).build().perform();
        actions.moveToElement(jacket).click().build().perform();

        //Select Sort By filter “Product Name”
        driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]/option[2]")).click();

        //Verify the products name display in
        //alphabetical order
        expectedText="Product Name";
        actualText=driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]/option[2]")).getText();
        Assert.assertEquals("Not Matched Text",expectedText,actualText);

    }

    @Test
    public void verifyTheSortByPriceFilter()
    {
//        Mouse Hover on Women Menu
//            * Mouse Hover on Tops
//            * Click on Jackets
        WebElement Women = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
        WebElement jacket = driver.findElement(By.xpath("//a[@id='ui-id-11']"));
        Actions action = new Actions(driver);
        action.moveToElement(Women).build().perform();
        action.moveToElement(tops).build().perform();
        action.moveToElement(jacket).click().build().perform();

        //Select Sort By filter “Price”
        driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]/option[3]")).click();

        //* Verify the products price display in
        //Low to High



    }

    @After
    public void tearDown()
    {
        closeBrowser();
    }
}
