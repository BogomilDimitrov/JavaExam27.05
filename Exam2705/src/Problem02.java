import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Problem02 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		String[] userInput = new String[n];
		ArrayList<BigDecimal> strToDouble = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			userInput[i] = scan.next();
		}

		for (int i = 0; i < userInput.length; i++) {
			strToDouble.add(new BigDecimal(userInput[i]));
		}
		
		Collections.sort(strToDouble);


		if (n == 1) {
			System.out.printf("%s", strToDouble.get(0).toPlainString());
			System.out.println();
		}else if (n == 2) {
			for (int i = strToDouble.size()-1; i > strToDouble.size()-3; i--) {
				System.out.printf("%s", strToDouble.get(i).toPlainString());
				System.out.println();
			}
		} else {
			for (int i = strToDouble.size()-1; i > strToDouble.size()-4; i--) {
				System.out.printf("%s", strToDouble.get(i).toPlainString());
				System.out.println();
			}
		}
		

	}

}
