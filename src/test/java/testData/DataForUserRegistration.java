package testData;

import com.github.javafaker.Faker;
import lombok.*;

import java.util.Random;

import lombok.Builder;
import lombok.Builder.Default;

@Value
@Builder(toBuilder = true)
public class DataForUserRegistration {
    static Faker faker = new Faker();
    private static final String[] COUNTRY_TABLE = {"India", "United States", "Canada", "Australia", "Israel", "New Zealand", "Singapore"};
    private static final String[] TITLES = {"Mr.", "Mrs."};
    @Default
    String name = null;
    @Default
    String email = null;
    @Default
    String pass = null;
    @Default
    String dobDay = null;
    @Default
    String dobMonth = null;
    @Default
    String dobYear = null;
    @Default
    String firstName = null;
    @Default
    String lastName = null;
    @Default
    String company = null;
    @Default
    String address1 = null;
    @Default
    String address2 = null;
    @Default
    String state = null;
    @Default
    String city = null;
    @Default
    String zipCode = null;
    @Default
    String mobileNumber = null;
    @Default
    Boolean isMale = null;

    public static String getTitle(boolean isMan) {
        if (isMan == true) {
            return TITLES[0];
        } else return TITLES[1];
    }

    public static String getRandomCountry() {
        Random rand = new Random();
        int randomIndexNumber = rand.nextInt(COUNTRY_TABLE.length);
        return COUNTRY_TABLE[randomIndexNumber];
    }

    public static DataForUserRegistration dataForAllRegistrationFormFields() {
        return DataForUserRegistration.builder()
                .isMale(true)
                .name(faker.name().username())
                .email(faker.internet().emailAddress())
                .pass("Test1234")
                .dobDay(faker.random().nextInt(1, 29).toString())
                .dobMonth(faker.random().nextInt(1, 12).toString())
                .dobYear(faker.random().nextInt(1980, 2000).toString())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .company(faker.company().name())
                .address1(faker.address().streetAddress())
                .address2(faker.address().secondaryAddress())
                .state(faker.address().state())
                .city(faker.address().city())
                .zipCode(faker.address().zipCode())
                .mobileNumber(faker.phoneNumber().cellPhone())
                .build();
    }
}