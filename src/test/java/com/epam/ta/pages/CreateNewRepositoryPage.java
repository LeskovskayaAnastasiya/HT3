package com.epam.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.ta.utils.Utils;

public class CreateNewRepositoryPage extends AbstractPage
{
	private final String BASE_URL = "http://www.github.com/new";
	private final Logger logger = LogManager.getRootLogger();

	@FindBy(xpath = "//body")
	private WebElement body;

	@FindBy(id = "repository_name")
	private WebElement inputRepositoryName;

	@FindBy(id = "repository_description")
	private WebElement inputRepositoryDescription;

	@FindBy(xpath = "//form[@id='new_repository']//button[@type='submit']")
	private WebElement butttonCreate;

	@FindBy(className = "empty-repo-setup-option")
	private WebElement labelEmptyRepoSetupOption;


	@FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]")
	private WebElement linkCurrentRepository;

	@FindBy(xpath = "//*[@id='new_repository']//button[@type='button']")
	private WebElement ownerRepository;

	@FindBy(xpath = "//dd[@class='error']")
	private WebElement errorMessageRepoExist;


	public CreateNewRepositoryPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public boolean isCurrentRepositoryEmpty()
	{
		return  labelEmptyRepoSetupOption.isDisplayed();
	}

	public  String generateFullNameRepo (String repositoryName){
		return  repositoryName + Utils.getRandomString(6);
	}

	public boolean createNewRepository(String repositoryFullName, String repositoryDescription)
	{
		Boolean isRepoExist = false;
		inputRepositoryName.sendKeys(repositoryFullName);
		inputRepositoryDescription.sendKeys(repositoryDescription);
		if(isErrorMessageRepoExist()){
			isRepoExist = true;
		}else {
			butttonCreate.click();
		}
		return isRepoExist;
	}

	public boolean isErrorMessageRepoExist(){
		Boolean result = false;
		try{
			if  (errorMessageRepoExist.getText().equals("The repository HT1 already exists on this account")){
				result = true;
			}
		}catch (NoSuchElementException ex){
			result = false;
		}
		return result;
	}

//
//	public String getOwnerRepository(){
//		return ownerRepository.getText();
//	}
//
//	public String getCurrentRepositoryName()
//	{
//		return linkCurrentRepository.getText();
//	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
	}

}
