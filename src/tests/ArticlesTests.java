package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ArticlesTests extends CoreTestCase {

    //Напишем тест L4Ex5
    @Test
    public void testSafeFirstArticleToMyList() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSkipButton();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title1 = ArticlePageObject.getArticleTitle();
        String name_of_folder1 = "Learning programming";
        ArticlePageObject.clickSaveButtonAndAddtoList();
        ArticlePageObject.addArticleToMyList1(name_of_folder1);

        //Кликаем по кнопке Назад (Стрелка)
        SearchPageObject.clickBackSearch();

        //Ждем и кликаем по второй статье
        SearchPageObject.clickByArticleWithSubstring("High-level programming language");
        ArticlePageObject.waitForTitleElement();
        String article_title2 = ArticlePageObject.getArticleTitle();
        String name_of_folder2 = "Topic2";
        ArticlePageObject.clickSaveButtonAndAddtoList();
        ArticlePageObject.clickPlusButton();
        ArticlePageObject.addArticleToMyList2(name_of_folder2);


        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickToViewListButton();

        MyListPageObject MyListPageObject = new MyListPageObject(driver);
        MyListPageObject.openFolderByName(name_of_folder2);

        MyListPageObject.swipeByArticleToDelete(article_title2);

    }
}
