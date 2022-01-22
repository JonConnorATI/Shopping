package stepDefinitions;

import java.util.List;
import java.util.Map;

import baseMethods.BaseMethodsMANDM;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageObjects.HomePageMANDM;
import pageObjects.MensClothingPageMANDM;

public class StepsFindCheapestJeansMANDM extends BaseMethodsMANDM {
	
	
	@Given("I open the website I will be in the landing page")
	public void i_open_the_website_i_will_be_in_the_landing_page() {
		navigateToHomePage();
		HomePageMANDM.acceptCookies();
		//HomePageMANDM.signUpClose();
		
	}
	@When("I select Mens I will be in the mens clothing page")
	public void i_select_mens_i_will_be_in_the_mens_clothing_page() {
	    HomePageMANDM.SelectMensLink();
	}
	@When("I select the sizes and products that I want from the REFINE BY side menu")
	public void i_select_the_sizes_and_products_that_i_want_from_the_refine_by_side_menu(DataTable dataTable) {
		List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
		MensClothingPageMANDM.chooseProduct(data.get(0).get("Product"));
		MensClothingPageMANDM.chooseSize(data.get(0).get("Size"));
		MensClothingPageMANDM.chooseProductType(data.get(0).get("Product Type"));
		
	}
	@When("I sort by the lowest price")
	public void i_sort_by_the_lowest_price() {
	   MensClothingPageMANDM.sortBy("Lowest Price");
	}
	@Then("the 1st product in the list has the lowest or equal lowest price")
	public void the_1st_product_in_the_list_has_the_lowest_or_equal_lowest_price() {
		MensClothingPageMANDM.checkFirstItem("Lowest Price");
	}




}
