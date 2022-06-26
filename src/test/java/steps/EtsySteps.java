package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
//import gherkin.ast.DataTable;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.EtsyHomePage;
import utils.Driver;

public class EtsySteps {

    WebDriver driver;
    EtsyHomePage etsyHomePage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        etsyHomePage = new EtsyHomePage();
    }
    @Then("user should see below menu item links")
    public void user_should_see_below_menu_item_links(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        for (int i = 0; i < dataTable.asList().size(); i++) {
            if(i == 0){
                Assert.assertNotNull(etsyHomePage.mainNavigationItems.get(i).getText());
                Assert.assertFalse(etsyHomePage.mainNavigationItems.get(i).getText().isEmpty());
            }
            else{
                Assert.assertEquals(dataTable.asList().get(i), etsyHomePage.mainNavigationItems.get(i).getText());
            }
        }
    }
}
