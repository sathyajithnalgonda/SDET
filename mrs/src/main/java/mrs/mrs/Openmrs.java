package mrs.mrs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Openmrs {
	public static void main(String[] args) throws InterruptedException {
		String[] browsers = { "chrome", "edge", "firefox" };
		for (String browser : browsers) {
			WebDriver driver = null;
			try {
				if (browser.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				} else 
					if (browser.equalsIgnoreCase("edge")) {
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
				} else
					if (browser.equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				} else {
					System.out.println("Unsupported browser: " + browser);
					continue;
				}
				driver.get("https://demo.openmrs.org/openmrs/login.htm");
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
					driver.findElement(By.id("username")).sendKeys("Admin");
					driver.findElement(By.id("password")).sendKeys("Admin123");
					driver.findElement(By.id("Inpatient Ward")).click();
					driver.findElement(By.id("loginButton")).click();
					driver.findElement(By.id(
							"referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension"))
							.click();
					driver.findElement(By.name("givenName")).sendKeys("Rudresh");
					driver.findElement(By.name("middleName")).sendKeys("Vikram");
					driver.findElement(By.name("familyName")).sendKeys("Singh");
					driver.findElement(By.id("next-button")).click();
					driver.findElement(By.xpath("//*[@id=\"gender-field\"]/option[1]")).click();
					driver.findElement(By.id("next-button")).click();
					driver.findElement(By.id("birthdateDay-field")).sendKeys("01");
					driver.findElement(By.id("birthdateYear-field")).sendKeys("1985");
					driver.findElement(By.id("birthdateYears-field")).sendKeys("38");
					driver.findElement(By.id("birthdateMonths-field")).sendKeys("08");
					driver.findElement(By.id("next-button")).click();
					driver.findElement(By.id("address1")).sendKeys("h.no.123");
					driver.findElement(By.id("address2")).sendKeys("Hyderabad");
					driver.findElement(By.id("cityVillage")).sendKeys("Hyderabad");
					driver.findElement(By.id("stateProvince")).sendKeys("T.S");
					driver.findElement(By.id("country")).sendKeys("India");
					driver.findElement(By.id("postalCode")).sendKeys("5000001");
					driver.findElement(By.id("next-button")).click();
					driver.findElement(By.name("phoneNumber")).sendKeys("987878675");
					driver.findElement(By.id("next-button")).click();
					String optionValue = "8d91a01c-c2cc-11de-8d13-0010c6dffd0f-A";
					String xpath = "//select[@id='relationship_type']/option[@value='" + optionValue + "']";
					driver.findElement(By.xpath(xpath)).click();
					By elementLocator = By.xpath("//*[@id=\"relationship\"]/p[2]/input[1]");
					WebElement personTypeahead = driver.findElement(elementLocator);
					personTypeahead.sendKeys("Sravan");
					driver.findElement(By.id("next-button")).click();
					driver.findElement(By.id("submit")).click();
					Thread.sleep(6000);
					driver.findElement(By.xpath("//*[@class='icon-home small']")).click();
					driver.findElement(
							By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension"))
							.click();
					driver.findElement(By.id("patient-search")).sendKeys("Rudresh Vikram Singh");
					Thread.sleep(7000);
					driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr[1]/td[2]")).click();
					Thread.sleep(7000);
					driver.findElement(
							By.xpath("//*[@id=\"appointmentschedulingui.requestAppointmentDashboardLink\"]/div/div[2]"))
							.click();
					Thread.sleep(6000);
					WebElement appointmentTypeInput = driver.findElement(By.xpath("//input[@id='appointment-type']"));
					appointmentTypeInput.click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@id='appointment-type']\r\n")).click();
					driver.findElement(By.xpath("//*[@id='appointment-type']\r\n")).sendKeys("General Medicine");
					Thread.sleep(3000);
					appointmentTypeInput.sendKeys("General Medicine");
					appointmentTypeInput.sendKeys(Keys.RETURN);
					driver.findElement(By.xpath("//*[@id=\"provider\"]\r\n")).click();
					WebElement providerInput = driver.findElement(By.xpath("//input[@id='provider']"));
					providerInput.click();
					providerInput.sendKeys("John Smith");
					Thread.sleep(3000);
					providerInput.sendKeys(Keys.RETURN);
					driver.findElement(By.id("min-time-frame-value")).click();
					driver.findElement(By.id("min-time-frame-value")).sendKeys("4");
					driver.findElement(By.xpath("//select[@id='min-time-frame-units']")).click();
					driver.findElement(By.xpath("//select[@id='min-time-frame-units']/option[2]")).click();
					driver.findElement(By.id("max-time-frame-value")).click();
					driver.findElement(By.id("max-time-frame-value")).sendKeys("10");
					driver.findElement(By.xpath("//select[@id='max-time-frame-units']")).click();
					driver.findElement(By.xpath("//select[@id='max-time-frame-units']/option[3]")).click();
					driver.findElement(By.id("notes")).click();
					driver.findElement(By.id("notes")).sendKeys("TESTING");
					driver.findElement(By.xpath("//input[@id='save-button']")).click();
					Thread.sleep(8000);
					driver.findElement(By.xpath("//*[@class='icon-home small']")).click();
					driver.findElement(
							By.id("appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension"))
							.click();
					driver.findElement(By.xpath("//*[@id='appointmentschedulingui-appointmentRequests-app']")).click();
					driver.findElement(By.xpath("//*[@class='icon-home small']")).click();
					driver.findElement(
							By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension"))
							.click();
					driver.findElement(By.id("patient-search")).sendKeys("Rudresh Vikram Singh");
					Thread.sleep(8000);
					driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr[1]/td[2]")).click();
					Thread.sleep(8000);
					driver.findElement(By.xpath("//div[contains(text(),'Delete Patient')]")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//input[@id='delete-reason']")).click();
					driver.findElement(By.xpath("//input[@id='delete-reason']")).sendKeys("Testing");
					driver.findElement(By.xpath(
							"//div[@id='delete-patient-creation-dialog']//button[@class='confirm right'][normalize-space()='Confirm']"))
							.click();
					driver.findElement(By.xpath("//*[@class='icon-home small']")).click();
					driver.findElement(By.xpath("//*[@class='icon-signout small']")).click();
					Thread.sleep(6000);
					driver.quit();
				}
			}
		}
	}
}