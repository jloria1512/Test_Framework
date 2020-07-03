package dataproviders;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;
import pojo.ProductData;
import pojo.UserAccount;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ProductProvider {
    @DataProvider(name = "getProductDataFromCode")
    private Object[][] getSearchData(){
        return new Object[][] {
                //    { new UserAccount("hola@hola.com", "hola", true)},
                //     { new UserAccount("holas@hola.com", "fake", false)}
        };
    }

    @DataProvider(name = "getProductDataFromJson")
    private Object[][] getSearchDataFromJson() throws FileNotFoundException {

        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/data/products.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<UserAccount> testData = new Gson().fromJson(dataSet, new TypeToken<List<ProductData>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

}
