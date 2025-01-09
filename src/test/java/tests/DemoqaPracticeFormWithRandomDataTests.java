package tests;

import org.junit.jupiter.api.Test;
import pages.DemoqaPracticeFormPage;

import static tests.TestData.*;
import static utils.ConvertUtils.*;

public class DemoqaPracticeFormWithRandomDataTests extends DemoqaFormBase {

    private final DemoqaPracticeFormPage page = new DemoqaPracticeFormPage();

    @Test
    void fullCompletionFormTest() {
        page.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobileNumber(mobileNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .uploadFileFromClasspath(picture)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm();

        page.checkSuccessfulSubmit()
                .checkHeaderOfResultsWindow("Thanks for submitting the form")
                .checkHeaderOfResultsTable("Label", "Values")
                .checkContentOfResultsTable("Student Name", String.format("%s %s", firstName, lastName))
                .checkContentOfResultsTable("Student Email", email)
                .checkContentOfResultsTable("Gender", gender)
                .checkContentOfResultsTable("Mobile", mobileNumber)
                .checkContentOfResultsTable("Date of Birth", String.format("%s %s,%s", dayOfBirth, monthOfBirth, yearOfBirth))
                .checkContentOfResultsTable("Subjects", arrayToStringWithCommaSeparators(subjects))
                .checkContentOfResultsTable("Hobbies", arrayToStringWithCommaSeparators(hobbies))
                .checkContentOfResultsTable("Picture", picture)
                .checkContentOfResultsTable("Address", address)
                .checkContentOfResultsTable("State and City", String.format("%s %s", state, city));
    }

    @Test
    void minimumCompletionFormTest() {
        page.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setMobileNumber(mobileNumber)
                .submitForm();

        page.checkSuccessfulSubmit()
                .checkHeaderOfResultsWindow("Thanks for submitting the form")
                .checkHeaderOfResultsTable("Label", "Values")
                .checkContentOfResultsTable("Student Name", String.format("%s %s", firstName, lastName))
                .checkContentOfResultsTable("Gender", gender)
                .checkContentOfResultsTable("Mobile", mobileNumber);
    }

    @Test
    void invalidEmailTest() {
        page.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(incorrectEmail)
                .setGender(gender)
                .setMobileNumber(mobileNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .uploadFileFromClasspath(picture)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm();

        page.checkUnsuccessfulSubmit();
    }

    @Test
    void invalidMobileNumberTest() {
        page.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobileNumber(incorrectMobileNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .uploadFileFromClasspath(picture)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm();

        page.checkUnsuccessfulSubmit();
    }
}