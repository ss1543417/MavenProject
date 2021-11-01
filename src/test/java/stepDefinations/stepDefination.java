package stepDefinations;

//import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
//import cucumber.api.junit.Cucumber;
import resources.MavenBase;

//import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
public class stepDefination extends MavenBase {

    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
        
    	driver=mvninitializedriver(); //Calling mvninitializedriver method in pagesNavigation method returning drive
		
    }

    @When("^User moves mouse over Sign In tab$")
    public void user_moves_mouse_over_sign_in_tab() throws Throwable {
        
    }

    @Then("^System triggers Sign tab pop-up $")
    public void system_triggers_sign_tab_popup() throws Throwable {
        
    }

    @And("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
        
    	driver.get(strArg1);
    }

    @And("^Other features as well$")
    public void other_features_as_well() throws Throwable {
       
    }

}