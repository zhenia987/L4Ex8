package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListPageObject extends MainPageObject {

    //
    public static final String
                //Специальная константа значение которой потом будет подменять на значение нашей переменной name_of_folder
                FOLDER_BY_NAME_TPL = "//*[@text='{FOLDER_NAME}']",
                ARTICLE_BY_TITLE_TPL = "//*[@text='{TITLE}']";

    //Метод который будет заменять значение константы FOLDER_BY_NAME_TPL на значение name_of_folder
    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    //Еще метод который будет будет выдавать xpath для статьи
    private static String getSavesArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }


    public MyListPageObject(AppiumDriver driver) {
        super(driver);
    }

    //Метод ищет папку и тапает по ней
    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        //Тапаем по нашей статье
        this.waitForElementForClick(
                By.xpath(folder_name_xpath),
                "Can not find folder by name" + name_of_folder,
                20
        );
    }
//метод для ожидания статья
    public void waitForArticleToAppearByTitle (String article_title2) {
        String article_xpath = getFolderXpathByName(article_title2);
        this.waitForElementPresent(
                By.xpath(article_xpath),
                "Cannot find saved article by title" + article_title2,
                15
        );
    }

    public void waitForArticleToDisappearByTitle (String article_title2) {
        String article_xpath = getFolderXpathByName(article_title2);
        this.waitForElementNotPresent(
                By.xpath(article_xpath),
                "Save article still present with title" + article_title2,
                15
        );
    }

    //Ждем название статьи и делваем свайп для удаления
    public void swipeByArticleToDelete(String article_title2)
    {
        //Подождем статью используя метод waitForArticleToAppearByTitle
        this.waitForArticleToAppearByTitle(article_title2);

        //делаем свайп
        String article_xpath = getFolderXpathByName(article_title2);
        this.swipeElementToLeft(
                By.xpath(article_xpath),
                "Not delete топик"
        );
        //Теперь используем метод waitForArticleToDisappearByTitle в этом методе
        this.waitForArticleToDisappearByTitle(article_title2);

    }


}
