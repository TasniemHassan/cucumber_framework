package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.WikipediaPage;

public class WikipediaSteps {

    WikipediaPage wikipediaPage;

    @Before
    public void setup() {
        wikipediaPage = new WikipediaPage();
    }

    @When("user searches for {string} on Wikipedia")
    public void userSearchesForOnWikipedia(String key) {
        wikipediaPage.searchInputBox.sendKeys(key + Keys.ENTER);
    }


    @And("user should see {string} in the first heading")
    public void userShouldSeeInTheFirstHeading(String key) {
        Assert.assertTrue(wikipediaPage.firstHeading.isDisplayed());
        Assert.assertTrue(wikipediaPage.firstHeading.getText().contains(key));
    }

    @Then("user should see below languages around the logo")
    public void userShouldSeeBelowLanguagesAroundTheLogo(DataTable languages) {
        for (int i = 0; i < languages.asList().size(); i++) {
            Assert.assertEquals(languages.asList().get(i), wikipediaPage.mainLanguages.get(i).getText());
        }
    }
}

