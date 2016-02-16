package com.sqa.em.craiglist;

import static org.testng.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * You are to create a automation test for Craiglist. You should implement the
 * following scenarios. Try to put them in seperate test cases and combine them
 * within one test class with three test methods. 1. Go to Craiglist, search for
 * a specific set of keywords, show the 10 most current positions available on
 * the console. Validate that their are at least 10 results returned for your
 * specified keywords. 2. Go to Craiglist and post an ad in a category of your
 * choice. If you are limited, explain what limitations you encountered.
 */
public class TestCraiglist {

	private WebDriver driver;

	private String baseUrl;

	private boolean acceptNextAlert = true;

	private StringBuffer verificationErrors = new StringBuffer();

	@Test
	public void postAdTest() {
		this.driver.get(this.baseUrl + "/");
		this.driver.findElement(By.cssSelector("#postlks > li > #post")).click();
		this.driver.findElement(By.xpath("//article[@id='pagecontainer']/section/form/blockquote/label[12]/input"))
				.click();
		this.driver.findElement(By.xpath("//article[@id='pagecontainer']/section/form/blockquote/label[12]/input"))
				.click();
		this.driver.findElement(By.xpath("//article[@id='pagecontainer']/section/form/blockquote/label/input")).click();
		this.driver
				.findElement(By
						.xpath("//article[@id='pagecontainer']/section/form/table/tbody/tr/td/blockquote/label[30]/input"))
				.click();
		this.driver.findElement(By.xpath("//form[@id='postingForm']/div/fieldset/div/span/input")).clear();
		this.driver.findElement(By.xpath("//form[@id='postingForm']/div/fieldset/div/span/input"))
				.sendKeys("Test@selenium.org");
		this.driver.findElement(By.xpath("//form[@id='postingForm']/div/fieldset/div/span/input[2]")).clear();
		this.driver.findElement(By.xpath("//form[@id='postingForm']/div/fieldset/div/span/input[2]"))
				.sendKeys("test@selenium.org");
		this.driver.findElement(By.xpath("//form[@id='postingForm']/div/div/label/input")).clear();
		this.driver.findElement(By.xpath("//form[@id='postingForm']/div/div/label/input"))
				.sendKeys("This is not a real post");
		this.driver.findElement(By.xpath("//form[@id='postingForm']/div/div/label[2]/input")).clear();
		this.driver.findElement(By.xpath("//form[@id='postingForm']/div/div/label[2]/input")).sendKeys("94122");
		this.driver.findElement(By.xpath("//form[@id='postingForm']/div/div[2]/label/textarea")).clear();
		this.driver.findElement(By.xpath("//form[@id='postingForm']/div/div[2]/label/textarea"))
				.sendKeys("Posting somebody test just for fun but this is not a real post.");
		this.driver.findElement(By.xpath("//div[@id='mapinfo']/fieldset/div/label/input")).clear();
		this.driver.findElement(By.xpath("//div[@id='mapinfo']/fieldset/div/label/input")).sendKeys("2201 Lawton St");
		this.driver.findElement(By.xpath("//div[@id='mapinfo']/fieldset/div[2]/label/input")).clear();
		this.driver.findElement(By.xpath("//div[@id='mapinfo']/fieldset/div[2]/label/input")).sendKeys(" 28th Av.");
		this.driver.findElement(By.xpath("//div[@id='mapinfo']/fieldset/div[3]/label/input")).clear();
		this.driver.findElement(By.xpath("//div[@id='mapinfo']/fieldset/div[3]/label/input")).sendKeys("San Francisco");
		this.driver.findElement(By.xpath("//form[@id='postingForm']/button")).click();
		this.driver.findElement(By.xpath("//form[@id='leafletForm']/button")).click();
		this.driver.findElement(By.xpath("//article[@id='pagecontainer']/section/form/button")).click();
	}

	@Test
	public void queryCragilistTest() {
		// QueryCraiglist query = new QueryCraiglist("pets");
		// System.out.println(query.toString());
		this.driver.get(this.baseUrl + "/");
		this.driver.findElement(By.id("query")).clear();
		this.driver.findElement(By.id("query")).sendKeys("dog walking");
		this.driver.findElement(By.id("query")).sendKeys(Keys.ENTER);
		try {
			boolean resultsReturn = this.driver
					.findElement(
							By.xpath(".//*[@id='searchform']/div[2]/div[2]/div[3]/span[2]/span[3]/span[1]/span[2]"))
					.isDisplayed();
			if (resultsReturn) {
				int results =
						Integer.parseInt(this.driver
								.findElement(By
										.xpath(".//*[@id='searchform']/div[2]/div[2]/div[3]/span[2]/span[3]/span[1]/span[2]"))
								.getText());
				if (results >= 10) {
					System.out.println("There are atleast 10 Results.\n\tBelow are the top 10: ");
					this.driver.findElement(By.xpath(".//*[@id='listview']")).click();
					for (int i = 0; i < 10; i++) {
						System.out.println("\t\t" + this.driver
								.findElement(By.xpath(
										".//*[@id='searchform']/div[2]/div[3]/span/p[" + (i + 1) + "]/span/span[2]/a"))
								.getText());
					}
					this.driver.findElement(By.xpath(".//*[@id='searchform']/div[2]/div[3]/span/p[5]")).getText();
				} else {
					System.out.println("There were not atleast10 results" + results);
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		this.driver = new FirefoxDriver();
		this.baseUrl = "https://sfbay.craigslist.org/";
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// Thread.sleep(5000);
		this.driver.quit();
		String verificationErrorString = this.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = this.driver.switchTo().alert();
			String alertText = alert.getText();
			if (this.acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			this.acceptNextAlert = true;
		}
	}

	private boolean isAlertPresent() {
		try {
			this.driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private boolean isElementPresent(By by) {
		try {
			this.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
