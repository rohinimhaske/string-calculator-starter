package calculator;

class StringCalculator {
    private static final String regex = "[,]";

   public static int add(String input) {
		if (input.isEmpty()) {
			return 0;
		}

		String[] numbers = input.split(",");
		int sum = 0;
		for (String num : numbers) {
			sum = sum + Integer.parseInt(num);
		}
		return sum;
	}

}
