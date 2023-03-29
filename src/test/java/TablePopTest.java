import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.RowPage;
import pages.TablePage;

import java.util.Properties;

public class TablePopTest extends TestBase {

    TablePage tablePage;
    Properties data = FileHandler.loadFile("TablePopTestData.properties");

    @BeforeEach
    public void testSetup() {
        tablePage = new TablePage(driver);
        driver.get(data.getProperty("url"));
    }

    @Test
    public void shouldDisplaySwitzerlandMountains() {
        tablePage.getMountains().stream()
                .filter(m -> m.getStateValue().contains(data.getProperty("country")))
                .filter(m -> m.getHeightValue() > Integer.parseInt(data.getProperty("height")))
                .forEach(RowPage::printInfo);
    }
}