package managers;

import pages.*;

public class PageFactoryManager {

    public static HomePage getHomePage(){
        return new HomePage();
    }

    public static NewsPage getNewsPage(){
        return new NewsPage();
    }

    public static SearchPage getSearchPage(){
        return new SearchPage();
    }

    public static ContactTheBBCPage getContactTheBBCPage(){
        return new ContactTheBBCPage();
    }

    public static SportPage getSportPage(){
        return new SportPage();
    }

    public static GameResultPage getGameResultPage(){
        return new GameResultPage();
    }

    public static CoronaVirusPage getCoronaVirusPage(){
        return new CoronaVirusPage();
    }
}
