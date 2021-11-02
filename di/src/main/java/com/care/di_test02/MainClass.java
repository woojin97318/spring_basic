package com.care.di_test02;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String path = "classpath:application_test02.xml";
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext(path);
		SaveClass sc = ctx.getBean("sc", SaveClass.class);
		
		System.out.print("num1 : ");
		sc.setNum1(in.nextInt());
		System.out.print("연산자 : ");
		sc.setOp(in.next());
		System.out.print("num2 : ");
		sc.setNum2(in.nextInt());
		
		sc.operationClass();
		sc.printClass();
	}
}
