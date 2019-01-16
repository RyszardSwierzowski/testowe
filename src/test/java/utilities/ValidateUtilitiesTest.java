package utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/*

 */
class ValidateUtilitiesTest {

    @Test
    void shouldReturnTrueWhenNewLoginIsOk() {
        assertAll("login",
                ()-> assertEquals(true,ValidateUtilities.validateNewLogin("AZazEWQEEQRfasfas2")),
                ()-> assertEquals(true,ValidateUtilities.validateNewLogin("eqwewq3"))

                );

    }@Test
    void shouldReturnFalseWhenNewLoginIsntOk() {
        assertAll("login",

                ()-> assertEquals(false,ValidateUtilities.validateNewLogin("$@#$@#$@#$@da1")),
                ()-> assertEquals(false,ValidateUtilities.validateNewLogin("ewqe"))

                );

    }

    @Test
    void shouldReturnTrueWhenNewPasswordIsOk() {
        assertAll("pass",
                ()-> assertEquals(true,ValidateUtilities.validateNewPassword("Q1a!dasdad"))


        );
    }@Test
    void shouldReturnFalseWhenNewPasswordIsntOk() {
        assertAll("pass",
                ()-> assertEquals(false,ValidateUtilities.validateNewPassword("dA1!")),
                ()-> assertEquals(false,ValidateUtilities.validateNewPassword("dsada1!")),
                ()-> assertEquals(false,ValidateUtilities.validateNewPassword("SDaddasdas"))

        );
    }

    @Test
    void shouldReturnTrueWhenisText() {
        assertAll("text",
                ()-> assertEquals(true,ValidateUtilities.isText("AZazdagsdgdsg"))
        );
    } @Test
    void shouldReturnFalseWhenIsntText() {
        assertAll("text",
                ()-> assertEquals(false,ValidateUtilities.isText("dA1!")),
                ()-> assertEquals(false,ValidateUtilities.isText("dsada1!@"))
        );
    }

    @Test
    void shouldReturnTrueWhenIsNumber() {
        assertAll("number",
                ()-> assertEquals(true,ValidateUtilities.isNumber("123467890"))
        );
    }
    @Test
    void shouldReturnFasleWhenIsntNumber() {
        assertAll("number",
                ()-> assertEquals(false,ValidateUtilities.isNumber("dA1!")),
                ()-> assertEquals(false,ValidateUtilities.isNumber("dsada1!@"))
        );
    }



    @Test
    void shouldReturnFasleWnehIsntMobilePhoneNumber() {
        assertAll("phone number",
                ()-> assertEquals(false,ValidateUtilities.isMobilePhoneNumber("123467890!")),
                ()-> assertEquals(false,ValidateUtilities.isMobilePhoneNumber("1234567892"))
        );
    }@Test
    void shouldReturnTrueWnehIsMobilePhoneNumber() {
        assertAll("phone number",
                ()-> assertEquals(true,ValidateUtilities.isMobilePhoneNumber("123456789"))
        );
    }











}