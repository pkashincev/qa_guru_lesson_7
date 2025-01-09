package tests;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.time.DateUtils;

import java.util.*;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static utils.RandomUtils.*;

public class TestData {

    private static final Faker faker = new Faker(new Locale("en-GB"));
    private static final Calendar date = DateUtils.toCalendar(faker.date().birthday());

    private static final String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
    private static final String[] genders = {"Male", "Female", "Other"};
    private static final String[] allSubjects = {"Arts", "Biology", "Chemistry", "English", "History", "Maths", "Physics"};
    private static final String[] allHobbies = {"Sports", "Reading", "Music"};
    private static final String[] allStates = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

    public static final String firstName = faker.name().firstName();
    public static final String lastName = faker.name().lastName();
    public static final String email = faker.internet().emailAddress();
    public static final String incorrectEmail = randomAlphanumeric(10);
    public static final String gender = faker.options().option(genders);
    public static final String mobileNumber = faker.number().digits(10);
    public static final String incorrectMobileNumber = randomAlphanumeric(10);
    public static final String dayOfBirth = String.format("%d", date.get(Calendar.DAY_OF_MONTH));
    public static final String monthOfBirth = months[date.get(Calendar.MONTH)];
    public static final String yearOfBirth = String.format("%d", date.get(Calendar.YEAR));
    public static final String[] subjects = getRandomItemsFromArray(allSubjects);
    public static final String[] hobbies = getRandomItemsFromArray(allHobbies);
    public static final String picture = "picture.jpg";
    public static final String address = faker.address().fullAddress();
    public static final String state = faker.options().option(allStates);
    public static final String city = getCityByState(state);

    private static String getCityByState(String state) {
        String city = "";

        switch (state) {

            case "NCR":
                city = faker.options().option("Delhi", "Gurgaon", "Noida");
                break;

            case "Uttar Pradesh":
                city = faker.options().option("Agra", "Lucknow", "Merrut");
                break;

            case "Haryana":
                city = faker.options().option("Karnal", "Panipat");
                break;

            case "Rajasthan":
                city = faker.options().option("Jaipur", "Jaiselmer");
                break;
        }

        return city;
    }
}