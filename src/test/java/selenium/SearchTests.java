package selenium;

import dataproviders.SearchProvider;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojo.SearchData;

public class SearchTests extends BaseClass {

    @Test(dataProvider = "getSearchDataFromJson", dataProviderClass = SearchProvider.class)
    @Parameters({"searchCriteria","expectedResults"})
    public void SearchTest(SearchData testSearchData){

        headerPage().search(testSearchData.getSearchCriteria());

        if (testSearchData.getExpectedResults() > 0) {

            int results = searchResultsPage().getThumbsCount();
            Assert.assertEquals(results, testSearchData.getExpectedResults(),
                    String.format("Was expecting %s, but got %s.", testSearchData.getExpectedResults(), results));
        }
        else
            Assert.assertTrue(searchResultsPage().isNoResultsVisible(), "Error message was not displayed");
    }
}