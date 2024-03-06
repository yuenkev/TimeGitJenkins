package time;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {
	
	// Testing GetTotalSeconds() ------------------------------------------------

	@Test
	void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("05:05:05");
		assertTrue("The seconds were not calculated properly", seconds==18305);
	}
	
	@Test
	void testGetTotalSecondsBad() {
	    assertThrows(NumberFormatException.class, () -> { Time.getSeconds("12:34:AB"); });
	}

	@Test
	void testGetTotalSecondsZeroTime() {
	    assertEquals(0, Time.getTotalSeconds("00:00:00"));
	}
	
	@Test
	void testGetTotalSecondsMaxTime() {
	    assertEquals(86399, Time.getTotalSeconds("23:59:59"));
	}
	
	// Testing GetSeconds() ------------------------------------------------
    @Test
    void testGetSecondsGood() {
        assertEquals(30, Time.getSeconds("12:34:30"));
        // Adjust the expected value based on the input time string
    }
    
	@Test
	void testGetSecondsBad() {
	    assertThrows(NumberFormatException.class, () -> { Time.getSeconds("12:34:AB"); });
	}

	
	@Test
	void testGetSecondsMinValue() {
	    assertEquals(0, Time.getSeconds("12:34:00"));
	}
	
	@Test
	void testGetSecondsMaxValue() {
	    assertEquals(59, Time.getSeconds("12:34:59"));
	}


	
	// Testing GetTotalMinutes() ------------------------------------------------
	
	@Test
	void testGetTotalMinutes() {
	    assertEquals(30, Time.getTotalMinutes("02:30:45"));
	}
	
	@Test
	void testGetTotalMinuteBad() {
	    assertThrows(NumberFormatException.class, () -> { Time.getTotalMinutes("12:345:30"); });
	}
	
	@Test
	void testGetTotalMinutesMinValue() {
	    assertEquals(0, Time.getTotalMinutes("12:00:45"));
	}
	
	@Test
	void testGetTotalMinutesMaxValue() {
	    assertEquals(59, Time.getTotalMinutes("12:59:45"));
	}

	
	// Testing GetTotalHours() ------------------------------------------------
	
	@Test
	void testGetTotalHours() {
	    assertEquals(12, Time.getTotalHours("12:45:30"));
	}

	
    @Test
    void testGetTotalHoursBad() {
        assertThrows(NumberFormatException.class, () -> {
            Time.getTotalHours("AB:30:45");
        });
        // Testing an invalid input that should throw a NumberFormatException
    }

	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:15:15", "05:59:59" })
	void testGetTotalHoursBoundary(String candidate) 
	{
		int hours = Time.getTotalHours(candidate);
		assertTrue("The hours were not calculated properly", hours ==5);
	}
	
	// Testing getMilliseconds() ------------------------------------------------
    @Test
    void testGetMillisecondsGood() {
        assertEquals(5, Time.getMilliseconds("12:05:05:05"));
    }
    
	@Test
	void testGetMillisecondsBad() {
	    assertThrows(StringIndexOutOfBoundsException.class, () -> {
	        Time.getMilliseconds("12:05:05:0");
	    });
	}
	
	@Test
	void testGetMillisecondsBoundary() {
	    assertEquals(0, Time.getMilliseconds("12:00:45:00"));
	}


}
