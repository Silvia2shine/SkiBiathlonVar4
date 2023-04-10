package org.example;

import static org.junit.jupiter.api.Assertions.*;

class TimeResultTest {
    @org.junit.jupiter.api.Test
    void calculatorValidInput() {
        TimeResult obj = new TimeResult();
        Integer calculate = null;
        try {
            calculate = obj.calculator("xoxoo");
        } catch (ValidationException e) {
            throw new RuntimeException(e);
        }
        assertEquals(30, calculate);
    }
    @org.junit.jupiter.api.Test
    void calculatorForNullThrowException() {
        TimeResult obj = new TimeResult();

        assertThrows(ValidationException.class, () -> {
            obj.calculator(null);
        });
    }

    @org.junit.jupiter.api.Test
    void skiTimeResultSecValidOutput()  {
        TimeResult obj = new TimeResult();
        Integer calculate = null;
        try {
            calculate = obj.skiTimeResultSec("30:45");
        } catch (ValidationException e) {
        }
        assertEquals(1845, calculate);
    }
    @org.junit.jupiter.api.Test  // this test is failed, the result is the exception
    void skiTimeResultSecIsNull() {
        TimeResult obj = new TimeResult();
        assertThrows(ValidationException.class, () -> {
            obj.skiTimeResultSec("");
        });
    }
    }

