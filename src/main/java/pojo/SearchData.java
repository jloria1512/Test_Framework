package pojo;

public class SearchData {

    private String searchCriteria;
    private int expectedResults;

    public SearchData(String searchCriteria, int expectedResults){
        this.searchCriteria = searchCriteria;
        this.expectedResults = expectedResults;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public void setExpectedResults(int expectedResults){
        this.expectedResults = expectedResults;
    }

    public String getSearchCriteria(){
        return searchCriteria;
    };

    public int getExpectedResults(){
        return expectedResults;
    }
}
