package programming;

import java.util.Arrays;
import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {
		
		printAllNumberInListFunctional(Arrays.asList(12,9,13,4,6,2,4,12,15));
		System.out.println("Printing only even numbers: ");
		printAllEvenNumberInListFunctional(Arrays.asList(12,9,13,4,6,2,4,12,15));
	}

	private static void printAllNumberInListFunctional(List<Integer> numbers) {
		numbers.stream().forEach(System.out::println);
	}
	
	private static void printAllEvenNumberInListFunctional(List<Integer> numbers) {
		numbers.stream().filter(n->(n%2==0)).forEach(System.out::println);
	}
}
