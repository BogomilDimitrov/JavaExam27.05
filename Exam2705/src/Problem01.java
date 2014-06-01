import java.util.ArrayList;
import java.util.Scanner;


public class Problem01 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		
		ArrayList<Integer> count = new ArrayList<>();
		ArrayList<String> measure = new ArrayList<>();
		do{
			String input = scan.next();
			if (input.equals("End")) {
				break;
			}else {
				try {
					count.add(Integer.parseInt(input));
				} catch (Exception e) {
					measure.add(input);
				}
			}
			
		}while(true);
		
		
		int totalBeers = 0;
		for (int i = 0; i < measure.size(); i++) {
			if (measure.get(i).contains("stacks")) {
				totalBeers += count.get(i)*20;
			}else {
				totalBeers += count.get(i);
			}
		}
		
		int stacks = totalBeers/20;
		int leftOverBeers = totalBeers%20;
		
		System.out.printf("%d stacks + %d beers", stacks, leftOverBeers);
	}

}
