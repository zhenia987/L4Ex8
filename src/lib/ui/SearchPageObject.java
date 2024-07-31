package lib.ui;
//В этом классе будут использоваться методы для поиска

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//Укажем что этот метод наследуется от MainPageObject
public class SearchPageObject extends MainPageObject{

    //Запишем константы которые используются в поиске
    private static final String
            SEARCH_SKIP = "org.wikipedia:id/fragment_onboarding_skip_button",
            SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",
            SEARCH_INPUT = "//*[contains(@text, 'Search Wikipedia')]",
            SEARCH_BACK_BUTTON = "//*[@content-desc='Navigate up']",
            SEARCH_CLOSE_BUTTON = "org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@text='{SUBSTRING}']",
            SEARCH_TITLE = "//android.view.View[@text='Java (programming language)']";


    //Иницилизируем аппиум драйвер из mainPageObject
    public SearchPageObject(AppiumDriver driver)
    {
        super(driver); //Таким образов мы берем драйвер из MainPageObject
    }



    /*Это так называемый метод templated */
    //Напишем еще метод для SUBSTRING
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /*Это так называемый метод templated */


    //Напишем метод, который будет тапать по Skip
    public void initSkipButton()
    {
        this.waitForElementForClick(By.id(SEARCH_SKIP),"Can not find Skip button", 5);
    }

    //Напишем метод, который будет инициализировать процесс поиска
    public void initSearchInput()
    {
        this.waitForElementForClick(By.xpath(SEARCH_INIT_ELEMENT), "Error find and click search init element", 5);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Error find search input after clicking search init element");
    }

    //Напишем метод, который будет вводить какое то значение в строку
    public void typeSearchLine(String search_line)
    {
        this.waitForElementSendKeys(By.xpath(SEARCH_INPUT), search_line, "Cannot find and type into search line", 5);
    }

    //Метод для поиска результата
    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Can not find result with substring " + substring);
    }

    //Метод для поиска кнопки "Закрыть" (крестик) в поле поиска статей
    public void waitCloseButtonToAppear()
    {
        this.waitForElementPresent(By.id(SEARCH_CLOSE_BUTTON), "Cannnot find Close button id", 15);
    }

    //метод для ожидания отсутсвия кнопки "Закрыть" (крестик) в поле поиска статей
    public void waitCloseButtonToDisappear()
    {
        this.waitForElementNotPresent(By.id(SEARCH_CLOSE_BUTTON), "Close button still present", 15);
    }

    //Метод для клика по кнопке "Закрыть" (крестик) в поле ввода
    public void clickCloseButton()
    {
        this.waitForElementForClick(By.id(SEARCH_CLOSE_BUTTON), "Cannot find and click Close button", 15);
    }



    //Метод для ожидания кнопки Стрелка-назад
    public void waitForBackButtonToAppear()
    {
        this.waitForElementPresent(By.xpath(SEARCH_BACK_BUTTON), "Cannot find  Back button", 5);
    }
    //Тут же пишем метод, который будет ожидание отсутствия этой кнопки "Стрелка-назад" по окончании теста
    public void waitForBackButtonToDisappear()
    {
        this.waitForElementNotPresent(By.xpath(SEARCH_BACK_BUTTON), "Back button is still present", 5);
    }
    //Метод для клика по кнопке Стрелка-назад
    public void clickBackSearch()
    {
        this.waitForElementForClick(By.xpath(SEARCH_BACK_BUTTON), "Cannot find and click Back button", 5);
    }

    //Метод для клика по статье, которую находит в поиске
    public void clickByArticleWithSubstring (String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementForClick(By.xpath(search_result_xpath), "Can not find and click result with substring " + substring, 10);
    }

    public String assertFindElementPresent() {
      return   this.assertElementPresent(
                By.xpath(SEARCH_TITLE),
                "text",
                "Cannot find title article",
                0
        );
    }



}
