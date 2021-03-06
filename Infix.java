package inlämningsuppgift4;

import java.util.*;

public class Infix {
	public static void main(String[] args) {
		System.out.println(convertToPostfix("A*B-(C+D)+E"));
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		LinkedList<String> list = new LinkedList<String>();
		String postfixexpr = convertToPostfix(str);

		// populating linked lsit
		for (int i = 0; i < postfixexpr.length(); i++) {
			String ch = "" + postfixexpr.charAt(i);
			System.out.println(ch); // Debugging purposes
			list.add(ch);
		}

		System.out.println(convertToPostfix(str));

		// Printing linked list
		System.out.println("Linked list:");
		ListIterator<String> it = list.listIterator(0);
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static String convertToPostfix(String infix) {
		Stack<Character> stack = new Stack<Character>();
		StringBuffer postfix = new StringBuffer(infix.length());
		char c;

		for (int i = 0; i < infix.length(); i++) {
			c = infix.charAt(i);

			if (!isOperator(c)) {
				postfix.append(c);
			} else {
				if (c == ')') {
					while (!stack.isEmpty() && stack.peek() != '(')
						postfix.append(stack.pop());

					if (!stack.isEmpty())
						stack.pop();
				} else {
					if (!stack.isEmpty() && !isLowerPrecedence(c, stack.peek()))
						stack.push(c);
					else {
						while (!stack.isEmpty() && isLowerPrecedence(c, stack.peek())) {
							Character pop = stack.pop();
							if (c != '(')
								postfix.append(pop);
							else
								c = pop;
						}
						stack.push(c);
					}
				}
			}
		}

		while (!stack.isEmpty()) {
			postfix.append(stack.pop());
		}

		return postfix.toString();
	}

	private static boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')';
	}

	private static boolean isLowerPrecedence(char op1, char op2) {
		switch (op1) {
		case '+':
		case '-':
			return !(op2 == '+' || op2 == '-');
		case '*':
		case '/':
			return op2 == '^' || op2 == '(';
		case '^':
			return op2 == '(';
		case '(':
			return true;
		default:
			return false;
		}
	}
}