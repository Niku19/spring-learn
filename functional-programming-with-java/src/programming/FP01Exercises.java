package programming;

import java.util.Arrays;
import java.util.List;

public class FP01Exercises {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(12,9,13,4,6,2,4,12,15);
		printAllNumberInListFunctional(numbers);
		System.out.println("Printing only even numbers: ");
		printAllEvenNumberInListFunctional(numbers);
	}

	private static void printAllNumberInListFunctional(List<Integer> numbers) {
		numbers.stream().forEach(System.out::println);
	}
	
	private static void printAllEvenNumberInListFunctional(List<Integer> numbers) {
		numbers.stream().filter(n->(n%2==0)).forEach(System.out::println);
	}
}
