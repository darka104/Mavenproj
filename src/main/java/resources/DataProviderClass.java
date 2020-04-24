package resources;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "dp")
    public Object[][] dp() {
        return new Object[][] {
                { "CATS" },
                { "Evita" },
                { "Phantom of the opera" }
        };
    }
}
