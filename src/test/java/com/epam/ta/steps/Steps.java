package com.epam.ta.steps;

import com.epam.ta.driver.DriverSingleton;
import com.epam.ta.pages.CreateNewRepositoryPage;
import com.epam.ta.pages.GitHubHelpPage;
import com.epam.ta.pages.LoginPage;
import com.epam.ta.pages.MainPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Steps
{
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser()
	{
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver()
	{
		DriverSingleton.closeDriver();
	}

	public void loginGithub(String username, String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}

	public boolean isLoggedIn(String username)
	{
		LoginPage loginPage = new LoginPage(driver);
		String actualUsername = loginPage.getLoggedInUserName().trim();
		logger.info("Actual username: " + actualUsername);
		return actualUsername.equals(username);
	}

	public boolean isErrorDisplayed(String message)
	{
		LoginPage loginPage = new LoginPage(driver);
		String errorMessage = loginPage.gerErrorMessage();
		logger.info("Error message: " + errorMessage);
		return errorMessage.equals(message);
	}

	public String generateFullNameRepo(String repositoryName){
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		return createNewRepositoryPage.generateFullNameRepo(repositoryName);
	}

	public boolean createNewRepository(String repositoryName, String repositoryDescription, String wayToCreateRepo)
	{
		MainPage mainPage = new MainPage(driver);
		if ("checkNewRepositoryLink".equals(wayToCreateRepo)) {
			mainPage.clickOnCreateNewRepositoryButton();

		} else if ("checkNewRepositoryButton".equals(wayToCreateRepo)) {
			mainPage.clickOnStartProjectButton();

		} else if ("checkStartProjectButton".equals(wayToCreateRepo)) {
			mainPage.clickOnNewRepoButton();
		}

		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		return createNewRepositoryPage.createNewRepository(repositoryName,repositoryDescription);
		}


	public boolean currentRepositoryIsEmpty()
	{
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		return createNewRepositoryPage.isCurrentRepositoryEmpty();
	}


	public boolean checkGitHubHelpPage(String searchString)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.clickTermsLink();
		GitHubHelpPage gitHubHelpPage = new GitHubHelpPage(driver);
		return gitHubHelpPage.checkGitHubHelpText(searchString);
	}

}
