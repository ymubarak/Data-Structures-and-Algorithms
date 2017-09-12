package infix_postfix;

import java.util.Scanner;
import java.util.Stack;

public class ToPostfix {

	static Stack<Object> s = new Stack<Object>();
	static Scanner input = new Scanner(System.in);
	static String[] precedence = { "+-", "/*" };

	public static void main(String[] args) {

		System.out.print("Enter infix : ");
		System.out.println();
		String infix = input.nextLine();
		String output = "";

		if (!infix.isEmpty())
			output = toInfix(infix);

		System.out.println("PostFix is  : " + output);

	}

	private static String toInfix(String infix) {
		String result = "";
		int len = infix.length();
		int start = 0;
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(infix.charAt(i))) {
				start++;
				if (i + 1 >= len || !Character.isDigit(infix.charAt(i + 1))) {
					result += infix.substring(i + 1 - start, i + 1) + " ";
					start = 0;
				}
			} else {
				if (!s.isEmpty()) {
					if (infix.charAt(i) == '(') {
						s.push(infix.charAt(i));
					} else if (infix.charAt(i) == ')') {
						while ((char) s.peek() != '(')
							result += s.pop();
						s.pop();
					} else if (precedence((char) s.peek()) < precedence(infix.charAt(i))) {
						s.push(infix.charAt(i));
					} else {
						while (!s.isEmpty() && precedence((char) s.peek()) >= precedence(infix.charAt(i)))
							result += s.pop();
						s.push(infix.charAt(i));
					}
				} else {
					if (infix.charAt(i) == ')')
						return "Invalid expression";
					s.push(infix.charAt(i));
				}
			}
		}
		while (!s.isEmpty())
			result += s.pop();
		return result;
	}

	private static int precedence(char c) {

		if (c == '(')
			return -1;
		if (c == '*' || c == '/')
			return 1;

		return 0;
	}
}
