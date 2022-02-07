package Lesson_8.steps;

import Lesson_8.Pages.CatalogPage;
import Lesson_8.Pages.SelectCity;
import Lesson_8.Pages.StartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.page;

public class MySteps {
    @Given("SelectCity page is loaded")
    public void selectCityPageIsLoaded() {
        page(SelectCity.class);
    }

    @When("User select city")
    public void userSelectCity() {
        page(SelectCity.class)
                .anotherCity()
                .city();
    }

    @And("select category and subcategory in catalog")
    public void selectCategoryAndSubcategoryInCatalog() {
        page(StartPage.class)
                .clickAllCatalog()
                .selectCategory()
                .selectSubCategory();
    }

    @And("input {string} and {string}")
    public void inputAnd(String arg0, String arg1) {
        page(CatalogPage.class)
                .filters(arg0, arg1)
                .confirmFilters();
    }

    @Then("filter can be checked {string} and {string}")
    public void catalogCanBeFiltered(String arg0, String arg1) {
        page(CatalogPage.class)
                .checkFilters(arg0, arg1);
    }
}
