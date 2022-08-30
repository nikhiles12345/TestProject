// Pagination Single....N
package mypack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test21 
{

	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter data to search");
		String data=sc.nextLine();
		sc.close();
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		Thread.sleep(3000);
		driver.findElement(By.name("q")).sendKeys(data,Keys.ENTER);
		Thread.sleep(5000);
		List<WebElement> allresults=new ArrayList<WebElement>();
		//Pagination (Move from one page to next page until last page)
		while(true)
		{
			try
			{
			List<WebElement> pageresults=driver.findElements(By.xpath("//h1[text()='Search Results']/following-sibling::div/div"));
			System.out.println(pageresults.size());
			allresults.addAll(pageresults);
			driver.findElement(By.xpath("//span[text()='Next']")).click();			
			Thread.sleep(3000);			
			}
			catch(Exception x)
			{
				      
				break;			
			}
		}
		driver.quit();
		System.out.println(allresults.size()); 
	}		
}
	