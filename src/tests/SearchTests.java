package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase {

    // Тест Ex3
    @Test
    public void test_l3_ex3() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        //Пропустим онбординг кликнув Skip
        SearchPageObject.initSkipButton();

        //Тапнем в поле поиска
        SearchPageObject.initSearchInput();

        //Тап в поле ввода и ввод текста
        SearchPageObject.typeSearchLine("Java");

        //Проверяем что есть первая статья
        SearchPageObject.waitForSearchResult("Island in Indonesia");

        //Проверяем что есть вторая статья
        SearchPageObject.waitForSearchResult("Object-oriented programming language");

        //Проверяем что есть третья статья
        SearchPageObject.waitForSearchResult("High-level programming language");

        //Ждем кнопку "Стрелка-назад"
        SearchPageObject.waitCloseButtonToAppear();

        //Тапаем по кнопке Стрелка-назад
        SearchPageObject.clickCloseButton();

        // Проверяем что больше нет кнопки "Закрыть"
        SearchPageObject.waitCloseButtonToDisappear();

    }

    //Тест по уроку Ex6
    public void test_l3_Ex6() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSkipButton();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        //Ищем стать и кликаем по ней
        String title_for_equals = "Java (programming language)";

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String title_find = SearchPageObject.assertFindElementPresent();

        assertEquals(
                "Article title not found",
                title_for_equals,
                title_find
        );
    }

}
