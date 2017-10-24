import java.util.Scanner;

/**
 * CS 2003 - Lab 9 Code to check for matching delimiters
 *
 * @author David Magar
 * @version 1.0
 * @since 10-24-2017
 */

public class DelimiterChecker {

	public static boolean delimiterCheck(String x) {
		int length = x.length();
		StackX stack = new StackX(length);
		char test;

		for (int i = 0; i < length; i++) {
			test = x.charAt(i);
			//If an opening delimiter push to stack
			if (test == '(' || test == '[' || test == '{') {
				stack.push(test);
			}
			//if closing delimiter test it
			if (test == ')' || test == ']' || test == '}') {
				//If stack is empty, there are too many closing delimiter
				if (stack.isEmpty()) {
					System.out.println("No more items in stack\nMissing left delimiter");
					return false;
				}

				//Check for matching delimiter
				else {
					switch (test) {
					case ')':
						if (stack.peek() == '(') {
							stack.pop();
							continue;
						} else {
							System.out.println("Mismatch error");
							return false;
						}
					case ']':
						if (stack.peek() == '[') {
							stack.pop();
							continue;
						} else
							System.out.println("Mismatch error");
						return false;
					case '}':
						if (stack.peek() == '{') {
							stack.pop();
							continue;
						} else {
							System.out.println("Mismatch error");
							return false;
						}

					}

				}
			}

		}
		//If remaining delimiters in stack there are missing closing delimiters
		if (stack.isEmpty() == false) {
			System.out.println("Missing right delimiter error");
			return false;
		} else
			return true;
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		//get input string to test from user
		System.out.println("Please enter a test string:\n");
		String x = keyboard.next();

		if (delimiterCheck(x)) {
			System.out.println("All delimiter are accounted for");

		} else
			System.out.println("Not all delimiters are accounted for");
		
		keyboard.close();

	}

}
