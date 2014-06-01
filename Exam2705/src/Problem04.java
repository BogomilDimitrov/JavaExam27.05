import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Problem04 {
 
        public static void main(String[] args) {
        	
        		//Input
                @SuppressWarnings("resource")
                Scanner scan = new Scanner(System.in);
 
                int n = scan.nextInt();
                scan.nextLine();
                String[] input = new String[n];
 
                for (int i = 0; i < n; i++) {
                        input[i] = scan.nextLine();
                }
 
                ArrayList<String> inputAsList = new ArrayList<>();
 
                for (int i = 0; i < input.length; i++) {
 
                        Pattern regex = Pattern.compile("\\w+");
                        Matcher match = regex.matcher(input[i]);
                        while (match.find()) {
                                inputAsList.add(match.group());
                        }
                }
                       
                //Logic
                LinkedHashMap<String, TreeMap<String, Integer>> products = new LinkedHashMap<>();
 
                for (int i = 0; i < inputAsList.size(); i += 3) {
                        int tempValue = 0;
                       
                        if (products.get(inputAsList.get(i+2))== null) {
                                products.put(inputAsList.get(i+2), new TreeMap<>());
                                products.get(inputAsList.get(i+2)).put(inputAsList.get(i), Integer.parseInt(inputAsList.get(i+1)));
                        }else{
                                if (products.get(inputAsList.get(i+2)).get(inputAsList.get(i)) == null) {
                                        products.get(inputAsList.get(i+2)).put(inputAsList.get(i), Integer.parseInt(inputAsList.get(i+1)));
                                }else{
                                       
                                        tempValue = products.get(inputAsList.get(i+2)).get(inputAsList.get(i)) + Integer.parseInt(inputAsList.get(i+1));
                                        products.get(inputAsList.get(i+2)).put(inputAsList.get(i), tempValue);
                                }
                        }
                }
               
                //Output
                for (String product : products.keySet()) {
                        System.out.printf("%s: ", product.replace('{', ' ').replace('}', ' ').trim());
                        String output = ("" + products.get(product)).replace('{', ' ').replace('}', ' ').replace('=', ' ').trim();
                        System.out.println(output);
                }
        }
}