//package com.epam.ta.pages;
//
//import com.epam.ta.utils.Utils;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class UserRepositoriesPage extends AbstractPage {
//
//    private  String username = null;
//    private  String reponame = null;
//    private  String BASE_URL =  "http://www.github.com/LeskovskayaAnastasiya/test1" ;
//    private final Logger logger = LogManager.getRootLogger();
//
//    @FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]/div[1]/div/h1/span[1]/a")
//    private WebElement linkCurrentRepository;
//
//
//    @FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]/div[1]/nav/span[2]/a")
//    private WebElement test3;
//
//
//    public UserRepositoriesPage(WebDriver driver)
//    {
//        super(driver);
//
//        //System.out.println("driver" + driver.getPageSource());
//        PageFactory.initElements(this.driver, this);
//    }
//    public void test3Click(){
//        System.out.println( driver.getTitle());
//
//        test3.click();
//    }
//
//
//    public String getCurrentRepositoryName()
//    {
//        System.out.println(linkCurrentRepository.getText());
//        return linkCurrentRepository.getText();
//    }
//
//    @Override
//    public void openPage()
//    {
//        driver.navigate().to(BASE_URL);
//    }
//
//
//}
