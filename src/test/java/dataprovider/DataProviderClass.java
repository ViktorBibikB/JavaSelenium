package dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    private static final String LEAGUE = "Scottish";
    private static final String CHAMPIONSHIP_NAME = "Scottish Championship";

    @DataProvider(name = "Months and Teams names")
    public static Object[][] dataProviderMethod() {
        return new Object[][] {
                { "Dunfermline" + "\n" + "0" + "\n" + "Arbroath" + "\n" + "3",
                        LEAGUE, CHAMPIONSHIP_NAME, "DEC", "Dunfermline" },
                { "Queen of the South" + "\n" + "1" + "\n" + "Inverness Caledonian Thistle" + "\n" + "2",
                        LEAGUE, CHAMPIONSHIP_NAME, "NOV", "Queen of the South" },
                { "Greenock Morton" + "\n" + "0" + "\n" + "Partick Thistle" + "\n" + "0",
                        LEAGUE, CHAMPIONSHIP_NAME, "OCT", "Greenock Morton" },
                { "Arbroath" + "\n" + "0" + "\n" + "Inverness Caledonian Thistle" + "\n" + "0",
                        LEAGUE, CHAMPIONSHIP_NAME, "JAN", "Inverness Caledonian Thistle" },
        };
    }
}
