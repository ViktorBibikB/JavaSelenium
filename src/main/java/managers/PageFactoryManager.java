package managers;

import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryManager {

    public static final HomePage HOME_PAGE = new HomePage();

    public static final NewsPage NEWS_PAGE = new NewsPage();

    public static final SearchPage SEARCH_PAGE = new SearchPage();

    public static final ContactTheBBCPage CONTACT_THE_BBC_PAGE = new ContactTheBBCPage();

    public static final SportPage SPORT_PAGE = new SportPage();

    public static final GameResultPage GAME_RESULT_PAGE = new GameResultPage();
}
