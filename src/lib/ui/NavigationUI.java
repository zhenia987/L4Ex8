package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject {

    private static final String
            VIEW_LIST_BUTTON = "org.wikipedia:id/snackbar_action";

    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }


    //Метод для клика по кноке View List. Урок 5-07
    public void clickToViewListButton()
    {
        this.waitForElementForClick(
                By.id(VIEW_LIST_BUTTON),
                "Can not fine and tap to View list ",
                15
        );
    }

}
