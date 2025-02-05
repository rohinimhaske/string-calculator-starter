package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {

	@Test
	void empty_string_should_return_0() {
		StringCalculator stringCalculator = new StringCalculator();
		try {
			assertEquals(0, stringCalculator.add(""));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void string_with_single_number_should_return_number_as_int() {
		StringCalculator stringCalculator = new StringCalculator();
		try {
			assertEquals(1, stringCalculator.add("1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void string_with_comma_delimiter_should_return_sum() {
		StringCalculator stringCalculator = new StringCalculator();
		try {
			assertEquals(3, stringCalculator.add("1,2"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void string_with_comma_delimiter_with_unknown_numbers_should_return_sum() {
		StringCalculator stringCalculator = new StringCalculator();
		try {
			assertEquals(45, stringCalculator.add("1,2,3,4,5,6,7,8,9"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void string_with_new_lines_should_return_sum() {
		StringCalculator stringCalculator = new StringCalculator();
		try {
			assertEquals(6, stringCalculator.add("1\n2,3"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void string_with_diffrent_delimiters_should_return_sum() {
		StringCalculator stringCalculator = new StringCalculator();
		try {
			assertEquals(3, stringCalculator.add("//;\n1;2"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void string_with_negative_numbers_should_thow_exception() {
		StringCalculator stringCalculator = new StringCalculator();
		try {
			stringCalculator.add("//;\n-1;2");
		} catch (Exception e) {
			assertEquals("negatives not allowed [-1]", e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	void string_with_multiple_negative_numbers_should_thow_exception() {
		StringCalculator stringCalculator = new StringCalculator();
		try {
			stringCalculator.add("//;\n-1;-2");
		} catch (Exception e) {
			assertEquals("negatives not allowed [-1, -2]", e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	void string_with_number_bigger_than_1000_should_be_ignored() {
		StringCalculator stringCalculator = new StringCalculator();
		try {
			assertEquals(2, stringCalculator.add("//;\n1005;2"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void string_with_any_lenght_delimiter_should_return_sum() {
		StringCalculator stringCalculator = new StringCalculator();
		try {
			assertEquals(6, stringCalculator.add("//[***]\n1***2***3"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void string_with_multiple_delimiter_should_return_sum() {
		StringCalculator stringCalculator = new StringCalculator();
		try {
			assertEquals(6, stringCalculator.add("//[*][%]\n1*2%3"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void string_with_multiple_delimiter_with_length_longer_than_one_should_return_sum() {
		StringCalculator stringCalculator = new StringCalculator();
		try {
			assertEquals(6, stringCalculator.add("//[{**][[%%%]]]\n1***2%%%%3"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void string_with_consecutive_numbers_should_return_sum() {
		StringCalculator stringCalculator = new StringCalculator();
		try {
			assertEquals(42, stringCalculator.add("1,2,3,6,6,6,4,5,6"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
