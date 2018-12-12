package controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogowanieTest {



    @Test
    public void shouldReturnTrueIfLoginIsCorrect(){
        //given
        Logowanie l = new Logowanie();
        l.loginFromField="dsadas";
        //
        boolean result = Logowanie.validateLogin(l.loginFromField="dsadas");
        //


        assertEquals(true,result);

    }
}