package app.util;

import java.util.Scanner;

import org.springframework.stereotype.Component;
@Component
public class MessageUtil {
	private static Scanner input = new Scanner(System.in);
	public static void displayMessage(String message){
		System.out.println(message);
	}
	

	
	public static Integer getIntegerUserInput(String message){
		System.out.println(message);
		Integer userInput = input.nextInt();
		return userInput;
	}
	
	public static String getUserInput(String message){
		System.out.println(message);
		String userInput = input.nextLine();
		return userInput;
	}
}
