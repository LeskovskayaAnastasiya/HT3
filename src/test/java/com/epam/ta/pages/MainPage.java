package com.epam.ta.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage
{
	private final String BASE_URL = "https://github.com/";


	@FindBy(xpath = "//*[@id=\"user-links\"]/li[2]/details/summary")
	private WebElement buttonCreateNew;

	@FindBy(xpath = "//a[contains(text(), 'New repository')]")
	private WebElement linkNewRepository;

	@FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div[1]/div/div/a[2]")
	private WebElement startProjectButton;

	@FindBy(xpath = "//*[@id=\"dashboard\"]/div[1]/div/div[1]/h3/a")
	private WebElement newRepoButton;

	@FindBy(xpath = "//html/body/div[5]/div[1]/ul[1]/li[2]/a")
	private WebElement termsLink;


	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void clickOnCreateNewRepositoryButton()
	{
		buttonCreateNew.click();
		linkNewRepository.click();
	}

	public void clickOnStartProjectButton()
	{
		startProjectButton.click();
	}

	public void clickOnNewRepoButton()
	{
		newRepoButton.click();
	}

	public void clickTermsLink()
	{
		termsLink.click();
	}


	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
	}
}
