package com.epam.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GitHubHelpPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://help.github.com/articles/github-terms-of-service/";

    @FindBy(xpath = "//*[@id=\"header\"]/div/h1/a")
    private WebElement gitHubHelpText;

    public GitHubHelpPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public boolean checkGitHubHelpText(String searchText)
    {
        return gitHubHelpText.getText().equals(searchText);
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
    }

}


