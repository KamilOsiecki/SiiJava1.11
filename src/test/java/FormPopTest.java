import enums.Profession;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.FormPage;

import java.io.File;
import java.util.Properties;

public class FormPopTest extends TestBase {

    FormPage formPage;
    Properties data = FileHandler.loadFile("FormPopTestData.properties");

    @BeforeEach
    public void testSetup() {
        formPage = new FormPage(driver);
        driver.get(data.getProperty("url"));
    }

    @Test
    @DisplayName("FormPOPTest")
    public void shouldFillFormWithSuccess() {

        formPage.setFirstName(data.getProperty("firstName"))
                .setLastName(data.getProperty("lastName"))
                .setEmail(data.getProperty("email"))
                .setAge(Integer.parseInt(data.getProperty("age")))
                .selectRandomGender()
                .selectRandomYearsOfExperienceValue()
                .selectProfession(Profession.AUTOMATION_TESTER)
                .selectContinent(data.getProperty("continent"))
                .selectSeleniumCommand(data.getProperty("seleniumCommand1"))
                .selectSeleniumCommand(data.getProperty("seleniumCommand2"))
                .uploadFile(new File(data.getProperty("fileSource")))
                .sendForm();

        Assertions.assertThat(formPage.getValidationMessage()).isEqualTo(data.getProperty("successMessage"));
    }
}