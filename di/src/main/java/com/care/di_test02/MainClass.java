package com.care.di_test02;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:application_test02.xml";
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext(path);
		SaveClass sc = ctx.getBean("sc", SaveClass.class);
		
		Scanner in = new Scanner(System.in);
		int num1, num2;
		String op;
		System.out.print("num1 : ");
		num1 = in.nextInt();
		System.out.print("연산자 : ");
		op = in.next();
		System.out.print("num2 : ");
		num2 = in.nextInt();
		
		sc.operationClass();
		sc.printClass();
	}
}
