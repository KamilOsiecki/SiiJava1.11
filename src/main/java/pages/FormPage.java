package pages;

import enums.Profession;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;


public class FormPage extends PageBase {
    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#inputFirstName3")
    private WebElement firstNameInput;

    @FindBy(css = "#inputLastName3")
    private WebElement lastNameInput;

    @FindBy(css = "#inputEmail3")
    private WebElement emailInput;

    @FindBy(css = "#inputAge3")
    private WebElement ageInput;

    @FindBy(css = "[name='gridRadiosSex']")
    private List<WebElement> genders;

    @FindBy(css = "[name='gridRadiosExperience']")
    private List<WebElement> yearOfExperience;

    @FindBy(css = ".checkbox-profession")
    private List<WebElement> professions;

    @FindBy(css = "#selectContinents")
    private WebElement selectContinents;

    @FindBy(css = "#selectSeleniumCommands")
    private WebElement selectSeleniumCommands;

    @FindBy(css = "#validator-message")
    private WebElement validationMessageLabel;

    @FindBy(css = ".btn-primary")
    private WebElement sendFormButton;

    @FindBy(css = "#chooseFile")
    private WebElement fileInput;

    public FormPage setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public FormPage setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public FormPage setEmail(String email){
        emailInput.sendKeys(email);
        return this;
    }

    public FormPage setAge(int age){
        ageInput.sendKeys(String.valueOf(age));
        return this;
    }

    public FormPage selectRandomGender(){
        getRandomElement(genders).click();
        return this;
    }

    public FormPage selectRandomYearsOfExperienceValue(){
        getRandomElement(yearOfExperience).click();
        return this;
    }

    public void selectManualTesterProfession (){
        professions.get(0).click();
    }
    public void selectAutomationTesterProfession(){
        professions.get(1).click();
    }

    public void selectOtherProfession(){
        professions.get(2).click();
    }
    public FormPage selectProfession(Profession profession){
        switch (profession) {
            case MANUAL_TESTER -> { selectManualTesterProfession();}
            case AUTOMATION_TESTER -> { selectAutomationTesterProfession();}
            case OTHER -> { selectOtherProfession();}
        }
        return this;
    }

    public FormPage selectContinent(String continentValue){
        new Select(selectContinents).selectByValue(continentValue);
        return this;
    }

    public FormPage selectSeleniumCommand(String seleniumCommandValue){
        new Select(selectSeleniumCommands).selectByValue(seleniumCommandValue);
        return this;
    }

    public String getValidationMessage(){
       return validationMessageLabel.getText();
    }

    public FormPage sendForm(){
        sendFormButton.click();
        return this;
    }

    public FormPage uploadFile(File file){
        fileInput.sendKeys(file.getAbsolutePath());
        return this;
    }
}