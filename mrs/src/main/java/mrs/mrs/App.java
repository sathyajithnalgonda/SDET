package mrs.mrs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App 
{
    
    public static void main(String[] args) throws InterruptedException {
		String[] browsers = { "chrome", "edge", "firefox" };
		for (String browser : browsers) {
			WebDriver driver = null;
			try {
				if (browser.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				} else if (browser.equalsIgnoreCase("edge")) {
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
				} else if (browser.equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				} else {
					System.out.println("Unsupported browser: " + browser);
					continue;
				}
				driver.get("https:amazon.in");
				WebElement searchInput = driver.findElement(By.id("search-input"));
				searchInput.sendKeys("Cross-browser testing");
				searchInput.sendKeys(Keys.RETURN);
				Thread.sleep(5000);
				int searchResultsCount = driver.findElements(By.className("search-result")).size();
				System.out.println("Browser: " + browser + " - Search results count: " + searchResultsCount);
			} catch (Exception e) {
				System.out.println("Error occurred in browser " + browser + ": " + e.getMessage());
			} finally {
				if (driver != null) {
					driver.manage().window().maximize();
					driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).click();
					driver.findElement(By.xpath("//a[@id='createAccountSubmit']")).click();
					driver.findElement(By.id("ap_customer_name")).click();
					driver.findElement(By.id("ap_customer_name")).sendKeys("Rudresh Vikram Singh");
					driver.findElement(By.id("ap_phone_number")).click();
					driver.findElement(By.id("ap_phone_number")).sendKeys("9087654321");
					driver.findElement(By.id("ap_email")).click();
					driver.findElement(By.id("ap_email")).sendKeys("rudreshvikramsingh@gmail.com");
					driver.findElement(By.id("ap_password")).click();
					driver.findElement(By.id("ap_password")).sendKeys("Rudesh@7");
					driver.findElement(By.xpath("//input[@id='continue']")).click();
					driver.quit();
				}
			}
		}
    }
}
