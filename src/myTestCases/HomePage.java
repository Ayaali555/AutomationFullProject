package myTestCases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePage extends TestData {
	
	
	Connection con ;
	Statement stmt ;
	ResultSet rs ;
	

	@BeforeTest

	public void MySetup() throws InterruptedException {

		SetupMyTest();

	}

	@Test (priority = 1,enabled = true)

	public void Signup() throws InterruptedException {

		WebElement LoginAndRegisterButton = driver.findElement(By.linkText("Login or register"));
		LoginAndRegisterButton.click();

		// to press on Continue Button

		WebElement ContinueButtonBeforeSignupPage = driver.findElement(By.xpath("//button[@title='Continue']"));
		ContinueButtonBeforeSignupPage.click();

//...............you are inside the sign up page..........

		// Elements

		WebElement FirstNameInptuField = driver.findElement(By.id("AccountFrm_firstname"));
		WebElement LastNameInptuField = driver.findElement(By.id("AccountFrm_lastname"));
		WebElement EmailInputField = driver.findElement(By.id("AccountFrm_email"));
		WebElement Address1 = driver.findElement(By.id("AccountFrm_address_1"));
		WebElement CountryDropDown = driver.findElement(By.id("AccountFrm_country_id"));
		WebElement StateDropDown = driver.findElement(By.id("AccountFrm_zone_id"));
		WebElement CityInput = driver.findElement(By.id("AccountFrm_city"));
		WebElement PostalInput = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement LoginNameInput = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement PasswordInput = driver.findElement(By.id("AccountFrm_password"));
		WebElement ConrirmPasswordInput = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement ConditionAndCheckbox = driver.findElement(By.id("AccountFrm_agree"));
		WebElement ContinueButton = driver.findElement(By.cssSelector(".btn.btn-orange.pull-right.lock-on-click"));

		// Actions

		FirstNameInptuField.sendKeys(randomFirstName);
		LastNameInptuField.sendKeys(randomLastName);
		EmailInputField.sendKeys(TheEmail);
		Address1.sendKeys("Amman");
		Select CountrySelect = new Select(CountryDropDown);
		CountrySelect.selectByVisibleText("Jordan");
		Thread.sleep(5000);
		int randomstate = rand.nextInt(StateDropDown.findElements(By.tagName("option")).size());
		Select SelectforStateDropDown = new Select(StateDropDown);
		SelectforStateDropDown.selectByIndex(randomstate);
		CityInput.sendKeys("RandomCity");
		PostalInput.sendKeys("RandomPostal");
		LoginNameInput.sendKeys(NameForLoginAndSignUp);
		PasswordInput.sendKeys(PasswordAndConfirmPassword);
		ConrirmPasswordInput.sendKeys(PasswordAndConfirmPassword);
		ConditionAndCheckbox.click();
		ContinueButton.click();

		// Assertion

		Assert.assertEquals(driver.getCurrentUrl().contains("succes"), true);

		Assert.assertEquals(driver.getPageSource().contains("Congratulations"), true);

		WebElement WelcomeMessageArea = driver.findElement(By.id("customernav"));

		Assert.assertEquals(WelcomeMessageArea.getText().contains(randomFirstName), true);

	}
	
	

	@Test (priority = 1,enabled = false)

	public void SignupWithDataBase() throws InterruptedException {

		WebElement LoginAndRegisterButton = driver.findElement(By.linkText("Login or register"));
		LoginAndRegisterButton.click();

		// to press on Continue Button

		WebElement ContinueButtonBeforeSignupPage = driver.findElement(By.xpath("//button[@title='Continue']"));
		ContinueButtonBeforeSignupPage.click();

//...............you are inside the sign up page..........

		// Elements

	WebElement FirstNameInptuField = driver.findElement(By.id("AccountFrm_firstname"));
		WebElement LastNameInptuField = driver.findElement(By.id("AccountFrm_lastname"));
		WebElement EmailInputField = driver.findElement(By.id("AccountFrm_email"));
		WebElement Address1 = driver.findElement(By.id("AccountFrm_address_1"));
		WebElement CountryDropDown = driver.findElement(By.id("AccountFrm_country_id"));
		WebElement StateDropDown = driver.findElement(By.id("AccountFrm_zone_id"));
		WebElement CityInput = driver.findElement(By.id("AccountFrm_city"));
		WebElement PostalInput = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement LoginNameInput = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement PasswordInput = driver.findElement(By.id("AccountFrm_password"));
		WebElement ConrirmPasswordInput = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement ConditionAndCheckbox = driver.findElement(By.id("AccountFrm_agree"));
		WebElement ContinueButton = driver.findElement(By.cssSelector(".btn.btn-orange.pull-right.lock-on-click"));

		// Actions

		FirstNameInptuField.sendKeys(randomFirstName);
		LastNameInptuField.sendKeys(randomLastName);
		EmailInputField.sendKeys(TheEmail);
		Address1.sendKeys("Amman");
		Select CountrySelect = new Select(CountryDropDown);
		CountrySelect.selectByVisibleText("Jordan");
		Thread.sleep(5000);
	int randomstate = rand.nextInt(StateDropDown.findElements(By.tagName("option")).size());
		Select SelectforStateDropDown = new Select(StateDropDown);
		SelectforStateDropDown.selectByIndex(randomstate);
		CityInput.sendKeys("RandomCity");
		PostalInput.sendKeys("RandomPostal");
		LoginNameInput.sendKeys(NameForLoginAndSignUp);
		PasswordInput.sendKeys(PasswordAndConfirmPassword);
		ConrirmPasswordInput.sendKeys(PasswordAndConfirmPassword);
		ConditionAndCheckbox.click();
		ContinueButton.click();

		// Assertion

		//Assert.assertEquals(driver.getCurrentUrl().contains("succes"), true);

		//Assert.assertEquals(driver.getPageSource().contains("Congratulations"), true);

		//WebElement WelcomeMessageArea = driver.findElement(By.id("customernav"));

		//Assert.assertEquals(WelcomeMessageArea.getText().contains(randomFirstName), true);

	}
	
	
	
	
	@Test (priority = 2 , enabled = true)
	public void logout () {
		
		driver.navigate().to(LogoutLink);
		
		WebElement ContentPanelLogoutMessage = driver.findElement(By.xpath("//div[@class='contentpanel']"));
		boolean ActualLogoutValue =ContentPanelLogoutMessage.getText().contains(ExpectedLogoutMessage);
		
		//Assertion
		
	Assert.assertEquals(ActualLogoutValue, ExpectedLogoutValue);	
		
		
	}

	@Test (priority = 3 , enabled = true)
	public void Login () {
		

		WebElement LoginAndRegisterButton = driver.findElement(By.linkText("Login or register"));
		LoginAndRegisterButton.click();
		
		//Elements inside the login or register page
		
		WebElement LoginName = driver.findElement(By.id("loginFrm_loginname"));
		WebElement Password = driver.findElement(By.id("loginFrm_password"));
		WebElement Loginbutton = driver.findElement(By.xpath("//button[@title='Login']"));
		
		
		
		//Actions
		
		LoginName.sendKeys(NameForLoginAndSignUp);
		Password.sendKeys(PasswordAndConfirmPassword);
		Loginbutton.click();
		
		//Assertion
		WebElement WelcomeMessageArea = driver.findElement(By.id("customernav"));

		Assert.assertEquals(WelcomeMessageArea.getText().contains(randomFirstName), true);
		
	}
	
	
	@Test (priority = 4 , enabled = true)
	
	public void AddRandomItem () {
		
		driver.navigate().to("https://automationteststore.com/");
		
		int totalItems = driver.findElements(By.className("prdocutname")).size();
		int randomItem = rand.nextInt(totalItems);
		
		driver.findElements(By.className("prdocutname")).get(randomItem).click();
		
		if(driver.getCurrentUrl().contains("product_id=116")) {
			
			driver.findElement(By.id("option344747")).click();
			
			
		}
		driver.findElement(By.className("productpagecart"));
		
		
		
		
		
		
		driver.findElement(By.className("productpagecart")).click(); 
		
		
			
			
		
		
		
		
	}
	
	@Test (priority = 5 , enabled = true)
	public void CheckoutProcess () throws InterruptedException {
		
		WebElement CheckoutButton = driver.findElement(By.id("cart_checkout1"));
		CheckoutButton.click();
		
		
		WebElement ConfirmOrderButton = driver.findElement(By.id("checkout_btn"));
		
		ConfirmOrderButton.click();
		
		Thread.sleep(3000);
		
		String ActualValue = driver.findElement(By.className("heading1")).getText();
		String ExpectedValue ="YOUR ORDER HAS BEEN PROCESSED!";
		
		Assert.assertEquals(ActualValue, ExpectedValue);
		
		//hello how are you
		
		
	}
	
}
