package com.epam.ta;

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
	private final String INCORRECT_PASSWORD = "130588";
	private final String ERROR_MESSAGE = "Incorrect username or password.";
	@BeforeMethod(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}

	@Test
	public void oneCanCreateProject()
	{
		steps.loginGithub(USERNAME, PASSWORD);
		Assert.assertTrue(steps.createNewRepository("testRepo", "auto-generated test repo"));
		Assert.assertTrue(steps.currentRepositoryIsEmpty());
		// do not use lots of asserts
	}

	@Test(description = "Login to Github")
	public void oneCanLoginGithub()
	{
		steps.loginGithub(USERNAME, PASSWORD);
		Assert.assertTrue(steps.isLoggedIn(USERNAME));
	}


// Проверка входа в аккаунт с неверным паролем
	@Test(description = "Login to Github")
	public void oneCantLoginGithub()
	{
		steps.loginGithub(USERNAME, INCORRECT_PASSWORD);
		Assert.assertTrue(steps.isErrorDisplayed(ERROR_MESSAGE));
	}


	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}

}
