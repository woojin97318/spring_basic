package com.care.di_test02;

public class OperationClass {
	public int operation(int num1, int num2, String op) {
		int result = 0;
		switch(op) {
		case "+" :
			result = num1 + num2;
			break;
		case "-" :
			result = num1 - num2;
			break;
		case "*" :
			result = num1 * num2;
			break;
		case "/" :
			result = num1 / num2;
			break;
		default :
			System.out.println("사칙연산(+, -, *, /)만 허용");
		}
		return result;
	}

}
