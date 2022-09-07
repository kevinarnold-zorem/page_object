package dropdown;

import Pages.DropDownPage;
import base.BaseTest;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownTest extends BaseTest {
    @Test
    public void testSelectOption(){
        DropDownPage dropDownPage = this.homePage.clickDropDown();
        String option = "Option 1";
        dropDownPage.selectFromDropDown(option);
        List<String> selectedOptions = dropDownPage.getSelectedOption();
        assertEquals(selectedOptions.size(),1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option no selected");
    }
}
