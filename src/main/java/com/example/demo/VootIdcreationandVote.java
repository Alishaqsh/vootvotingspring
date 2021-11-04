package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VootIdcreationandVote {
	
	public static void main(String[] args) throws  FileNotFoundException 

    {
		
		Scanner sc = new Scanner(new File("C:\\Users\\Alisha\\Documents\\twitterbot\\driver2\\emailId2.csv"));  
		sc.useDelimiter("\n");   //sets the delimiter pattern  
		while (sc.hasNext())  //returns a boolean value  
		{  
		System.out.print(sc.next());  //find and returns the next complete token from this scanner  
		  
		
        String exePath = "C:\\Users\\Alisha\\Documents\\twitterbot\\driver2\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);

        WebDriver driver = new ChromeDriver();
        try {
        driver.get("https://voting.voot.com/vote/b7849150-1f61-11ec-8349-d597e6e77fa7?&platform=web");
        System.out.println("Successfully opened the website");
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys(sc.next());
        driver.findElement(By.className("jss393")).click();
        Thread.sleep(2000);
        System.out.println("Successfully logged in");
        driver.findElement(By.id("password")).sendKeys("123qwe,./");
        driver.findElement(By.className("jss528")).click();
        
        Thread.sleep(2000);
        
        driver.findElement(By.id("name")).sendKeys(getName());
        driver.findElement(By.id("dob")).sendKeys("09/04/1993");
        
        driver.findElement(By.xpath("//span[contains(text(), 'Female')]")).click();
        //driver.findElement(By.className("jss798")).click();
        driver.findElement(By.xpath("//label[contains(text(), 'Select your preference')]")).click();
        Thread.sleep(2000);
        
        
        driver.findElement(By.xpath("//button[text()='Save']")).click();
        //driver.findElement(By.className("jss854")).click();
        Thread.sleep(2000); 
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
    	Thread.sleep(5000); 
        driver.findElement(By.xpath("//img[@alt='Nishant Bhat ']")).click();
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        Thread.sleep(2000);
        driver.close();
        
        }catch(InterruptedException|NoSuchElementException|WebDriverException e) {
        	try {
				Thread.sleep(5000);
			
            driver.findElement(By.xpath("//img[@alt='Nishant Bhat ']")).click();
            driver.findElement(By.className("jss190")).click();
            Thread.sleep(2000);
            driver.close();
            continue;
        	} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
        }

		}   
		sc.close();
    }
	
	public static String getName() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

}
