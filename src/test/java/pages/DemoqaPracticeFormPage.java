package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultsWindowComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaPracticeFormPage {

    private final SelenideElement firstName = $("#firstName");
    private final SelenideElement lastName = $("#lastName");
    private final SelenideElement email = $("#userEmail");
    private final SelenideElement gender = $("#genterWrapper");
    private final SelenideElement mobileNumber = $("#userNumber");
    private final SelenideElement dateOfBirthCalendar = $("#dateOfBirthInput");
    private final SelenideElement subjects = $("#subjectsInput");
    private final SelenideElement hobbies = $("#hobbiesWrapper");
    private final SelenideElement picture = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement state = $("#state");
    private final SelenideElement city = $("#city");
    private final SelenideElement submitButton = $("#submit");

    private final CalendarComponent calendar = new CalendarComponent();
    private final ResultsWindowComponent resultsWindow = new ResultsWindowComponent();

    public DemoqaPracticeFormPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public DemoqaPracticeFormPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public DemoqaPracticeFormPage setFirstName(String value) {
        firstName.setValue(value);

        return this;
    }

    public DemoqaPracticeFormPage setLastName(String value) {
        lastName.setValue(value);

        return this;
    }

    public DemoqaPracticeFormPage setEmail(String value) {
        email.setValue(value);

        return this;
    }

    public DemoqaPracticeFormPage setGender(String value) {
        gender.$(byText(value)).click();

        return this;
    }

    public DemoqaPracticeFormPage setMobileNumber(String value) {
        mobileNumber.setValue(value);

        return this;
    }

    public DemoqaPracticeFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthCalendar.click();
        calendar.setDate(day, month, year);

        return this;
    }

    public DemoqaPracticeFormPage setSubjects(String... values) {
        for (String s : values) {
            subjects.setValue(s).pressEnter();
        }

        return this;
    }

    public DemoqaPracticeFormPage setHobbies(String... values) {
        for (String s : values) {
            hobbies.$(byText(s)).click();
        }

        return this;
    }

    public DemoqaPracticeFormPage uploadFileFromClasspath(String fileName) {
        picture.uploadFromClasspath(fileName);

        return this;
    }

    public DemoqaPracticeFormPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public DemoqaPracticeFormPage setState(String value) {
        state.click();
        state.$(byText(value)).click();

        return this;
    }

    public DemoqaPracticeFormPage setCity(String value) {
        city.click();
        city.$(byText(value)).click();

        return this;
    }

    public DemoqaPracticeFormPage submitForm() {
        submitButton.click();

        return this;
    }

    public DemoqaPracticeFormPage checkSuccessfulSubmit() {
        resultsWindow.isVisible();

        return this;
    }

    public DemoqaPracticeFormPage checkUnsuccessfulSubmit() {
        resultsWindow.isHidden();

        return this;
    }

    public DemoqaPracticeFormPage checkHeaderOfResultsWindow(String header) {
        resultsWindow.checkWindowHeader(header);

        return this;
    }

    public DemoqaPracticeFormPage checkHeaderOfResultsTable(String key, String value) {
        resultsWindow.checkTableHeader(key, value);

        return this;
    }

    public DemoqaPracticeFormPage checkContentOfResultsTable(String key, String value) {
        resultsWindow.checkTableContent(key, value);

        return this;
    }
}