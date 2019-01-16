package utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/*

 */
class ValidateUtilitiesTest {

    @Test
    void validateNewLogin() {
        assertAll("login",
                ()-> assertEquals(true,ValidateUtilities.validateNewLogin("AZazEWQEEQRfasfas2")),
                ()-> assertEquals(true,ValidateUtilities.validateNewLogin("eqwewq3")),
                ()-> assertEquals(false,ValidateUtilities.validateNewLogin("$@#$@#$@#$@da1")),
                ()-> assertEquals(false,ValidateUtilities.validateNewLogin("ewqe"))

                );

    }

    @Test
    void validateNewPassword() {
        assertAll("pass",
                ()-> assertEquals(true,ValidateUtilities.validateNewPassword("Q1a!dasdad")),
                ()-> assertEquals(false,ValidateUtilities.validateNewPassword("dA1!")),
                ()-> assertEquals(false,ValidateUtilities.validateNewPassword("dsada1!")),
                ()-> assertEquals(false,ValidateUtilities.validateNewPassword("SDaddasdas"))

        );
    }

    @Test
    void isText() {
        assertAll("text",
                ()-> assertEquals(true,ValidateUtilities.isText("AZazdagsdgdsg")),
                ()-> assertEquals(false,ValidateUtilities.isText("dA1!")),
                ()-> assertEquals(false,ValidateUtilities.isText("dsada1!@"))
        );
    }

    @Test
    void isNumber() {
        assertAll("number",
                ()-> assertEquals(true,ValidateUtilities.isNumber("123467890")),
                ()-> assertEquals(false,ValidateUtilities.isNumber("dA1!")),
                ()-> assertEquals(false,ValidateUtilities.isNumber("dsada1!@"))
        );
    }



    @Test
    void isMobilePhoneNumber() {
        assertAll("phone number",
                ()-> assertEquals(true,ValidateUtilities.isMobilePhoneNumber("123456789")),
                ()-> assertEquals(false,ValidateUtilities.isMobilePhoneNumber("123467890!")),
                ()-> assertEquals(false,ValidateUtilities.isMobilePhoneNumber("1234567892"))
        );
    }











}