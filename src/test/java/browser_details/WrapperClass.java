package browser_details;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WrapperClass {

	protected WebDriver driver;
	
	public void lanchBrowser(String browser,String url) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}
	
	public void screenshot(String path) throws IOException {
		TakesScreenshot ts=((TakesScreenshot) driver);
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,new File(path)); 
	}
	
	public void quit() {
		driver.close();
	}
	
}
