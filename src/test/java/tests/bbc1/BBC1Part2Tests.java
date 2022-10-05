package tests.bbc1;

import tests.BaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

public class BBC1Part2Tests extends BaseTest {

    private final String QUESTION_TEXT = "QUESTION_TEXT";
    private final String NAME = "NAME";
    private final String EMAIL = "EMAIL@gmail.com";
    private final String PHONE = "PHONE";

    private final String ERROR_MESSAGE_TEXT = "There’s an error to correct before you can continue";

    @Test()
    public void sendQuestionToBBCWithoutTitle(){
        assertEquals(businessLogicLayer.getErrorMessageWhenRequestWithoutTitle(), ERROR_MESSAGE_TEXT);
    }

    @Test()
    public void sendQuestionToBBCWithoutTextBox(){
        assertEquals(businessLogicLayer.getErrorMessageWhenRequestWithoutTextBox(), ERROR_MESSAGE_TEXT);
    }

    @Test()
    public void sendQuestionToBBCWithoutTextAnyText(){
        assertEquals(businessLogicLayer.getErrorMessageWhenRequestWithoutText(), ERROR_MESSAGE_TEXT);
    }

    @Test
    public void sendQuestionFromCoronaVirusPageNoEmail(){
        Map<String, String> data = new HashMap<>();
        data.put("text", QUESTION_TEXT);
        data.put("name", NAME);
        data.put("email", "");
        data.put("number", PHONE);

        assertEquals(businessLogicLayer.fillQuestionFormOnTheCoronavirusPage(data), "Email address can't be blank");
    }

    @Test
    public void sendQuestionFromCoronaVirusPageNoEmailAndName(){
        Map<String, String> data = new HashMap<>();
        data.put("text", QUESTION_TEXT);
        data.put("name", "");
        data.put("email", "");
        data.put("number", PHONE);

        assertEquals(businessLogicLayer.fillQuestionFormOnTheCoronavirusPage(data), "Email address can't be blank");
    }

    @Test
    public void sendQuestionFromCoronaVirusPageNoEmailNameAndQuestionText(){
        Map<String, String> data = new HashMap<>();
        data.put("text", "");
        data.put("name", "");
        data.put("email", "");
        data.put("number", PHONE);

        assertEquals(businessLogicLayer.fillQuestionFormOnTheCoronavirusPage(data), "Email address can't be blank");
    }
}

