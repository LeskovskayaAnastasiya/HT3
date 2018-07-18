package com.epam.ta;

import com.epam.ta.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.ta.steps.Steps;

public class GitHubAutomationTest
{
	private Steps steps;
	private final String USERNAME = "LeskovskayaAnastasiya";
	private final String PASSWORD = "130588mc";
	private final String ERROR_MESSAGE = "Incorrect username or password.";


	@BeforeMethod(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}

	//test1
	// Check error message when the user login with incorrect data
	@Test(
			dataProviderClass = DataProviders.class,
			dataProvider = "DataProviderForLogin",
			description = "Login to Github"
	)
	public void loginGithubWithIncorrectData(String username, String password)
	{
		steps.loginGithub(username, password);
		Assert.assertTrue(steps.isErrorDisplayed(ERROR_MESSAGE));
	}

	@Test(description = "Login to Github")
	public void oneCanLoginGithub()
	{
		steps.loginGithub(USERNAME, PASSWORD);
		Assert.assertTrue(steps.isLoggedIn(USERNAME));
	}

	//	test2
	// check repo creation with correct repoName
	@Test ( dataProviderClass = DataProviders.class,
			dataProvider = "DataProviderForCreateRepo")
	public void CanCreateProject(String wayToCreateRepo)
	{
		steps.loginGithub(USERNAME, PASSWORD);
		Assert.assertFalse(steps.createNewRepository(steps.generateFullNameRepo(USERNAME), "auto-generated test repo", wayToCreateRepo));
		//Assert.assertTrue(steps.currentRepositoryIsEmpty());
		// do not use lots of asserts
	}

	//	test3
	//	 check massege error
	@Test ( dataProviderClass = DataProviders.class,
			dataProvider = "DataProviderForCreateRepo")
	public void tryToCreateDublicateProject(String wayToCreateRepo) {
		steps.loginGithub(USERNAME, PASSWORD);
		Assert.assertTrue(steps.createNewRepository("HT1", "auto-generated test repo", wayToCreateRepo));
	}


	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}

}
