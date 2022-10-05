package tests.bbc2;

import tests.BaseTest;
import dataprovider.DataProviderClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class BBC2Part2Tests extends BaseTest {

    @Test(dataProvider = "Months and Teams names", dataProviderClass = DataProviderClass.class)
    public void checkTeamsScore(String expectedTeamsScore, String leagueName, String championshipName, String month, String teamName) {
        assertEquals(expectedTeamsScore, businessLogicLayer.getTeamsScoreResult(leagueName, championshipName, month, teamName));
    }
}
