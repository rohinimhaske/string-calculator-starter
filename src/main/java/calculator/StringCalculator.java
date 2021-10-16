package calculator;

class StringCalculator {
    private static final String regex = "[\n,;*]";

    public int add(String input) throws Exception {
		if (input.isEmpty()) {
			return 0;
		}

		String[] numbers = input.split(regex);
		int sum = 0;
		List<Integer> negativeNumbers = new ArrayList<>();
		for (String num : numbers) {
			try {
				int number = Integer.parseInt(num);
				if (number >= 0 && number <= 1000) {
					sum = sum + number;
				} else if (number < 0) {
					negativeNumbers.add(number);
				}
			} catch (NumberFormatException nfe) {
				nfe.getMessage();
			}
		}

		if (!negativeNumbers.isEmpty()) {
			throw new Exception("negatives not allowed " + negativeNumbers);
		}
		return sum;
	}

}
