import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem03 {

	public static void main(String[] args) {
		// Input
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		String input = scan.nextLine();
		// Variables
		int biggestSequence = 0;
		int currentSequence = 0;
		Pattern regex = Pattern.compile("\\d+");
		Matcher match = regex.matcher(input);
		ArrayList<Integer> numbers = new ArrayList<>();

		while (match.find()) {
			numbers.add(Integer.parseInt(match.group()));
		}
		for (int i = 1; i < numbers.size() - 1; i++) {
			if (numbers.get(i) == 0  && numbers.get(i-1)!=0) {
				if (numbers.get(i - 1) % 2 == 1) {
					numbers.set(i, 2);
				} else {
					numbers.set(i, 1);
				}
			}else if (numbers.get(i) == 0 && numbers.get(i-1)==0) {
				numbers.set(i-1, 1);
				numbers.set(i, 2);
			}
		}

		for (int i = 0; i < numbers.size() - 1; i++) {
			int firstNum = numbers.get(i) % 2;
			int secondNum = numbers.get(i + 1) % 2;
			if (firstNum == 1 && secondNum == 0) {
				currentSequence++;
			} else if (firstNum == 0 && secondNum == 1){
				currentSequence++;
			} else {
				currentSequence = 0;
			}
			if (currentSequence > biggestSequence) {
				biggestSequence = currentSequence;

			}
		}
		biggestSequence++;
		System.out.println(biggestSequence);
	}

}
