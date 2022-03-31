package frontend;

import core.SuperPage;
import utils.Browser;

public class HomePage extends SuperPage {
    public static void goTo(String webPage){
        Browser.driver.get(webPage);
    }


}
