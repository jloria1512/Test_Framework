package pojo;

public class ProductData {
    private String productName;
    private String cost;

    public ProductData(String _productName, String _cost){
        this.setProductName(_productName);
        this.setCost(_cost);
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCost(String cost){
        this.cost = cost;
    }

    public String getProductName(){
        return productName;
    };

    public String getCost(){
        return cost;
    }
}
