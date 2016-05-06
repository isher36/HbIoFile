package ioFile;

import java.util.Scanner;

public class Main {
	

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	// Ask user to input a text
	public String inputText(String text) {
		// open scanner
		System.out.println(text);
		String str = sc.nextLine();
		return str;
	}

}
