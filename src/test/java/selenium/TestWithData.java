package selenium;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestWithData {

    @DataProvider(name = "numeroProvider")
    public Object[][] methodNumeroProvider(){
        return new Object[][]{
                {5},{3}
        };
    }

    @Test(dataProvider = "numeroProvider")
    public void Numero(int num){
        Assert.assertTrue(num == 3);
        System.out.println("Numero" + num);
    }
}