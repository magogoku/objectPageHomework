package tests;

import data.RegistrationUserData;
import org.junit.jupiter.api.Test;
import static data.RegistrationUserData.*;

public class InputDataCheck extends TestBase {

    @Test
    void InputData() {
        RegistrationUserData registrationUserData = new RegistrationUserData();

        registrationPage.openPage()
                // Заполнение данных
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userPhone)
                .setBirthDate(userDayOfBirth, userMonthOfBirth, userYearOfBirth)
                .setSubjects(userSubjcets)
                .setHobbies(userHobbies)
                .uploadPicture(userFileName)
                .setCurrentAddress(userAddress)
                .setStateAndCity(userState, userCity)
                .pressSubmit()
                // Проверка данных
                .verifyResultsModalAppears()
                .verifyResult("Student Name", userFirstName + " " + userLastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userPhone)
                .verifyResult("Date of Birth", userDayOfBirth + " " + userMonthOfBirth + "," + userYearOfBirth)
                .verifyResult("Subjects", userSubjcets)
                .verifyResult("Hobbies", userHobbies)
                .verifyResult("Picture", userFileName)
                .verifyResult("Address", userAddress)
                .verifyResult("State and City", userState + " " + userCity);
    }
}
