import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selintro {
	public static void main(String args[])
	{
		
		
		System.getProperty("webdriver.chrome.driver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
	}
}
