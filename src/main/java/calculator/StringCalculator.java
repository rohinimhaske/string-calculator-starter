package calculator;

class StringCalculator {
    private static final String regex = "[\n,;]";

   public static int add(String input) {
		if (input.isEmpty()) {
			return 0;
		}

		String[] numbers = input.split(regex);
		int sum = 0;
		for (String num : numbers) {
			try {
				sum = sum + Integer.parseInt(num);
			} catch (NumberFormatException nfe) {
				nfe.getMessage();
			}
		}
		return sum;
	}

}
