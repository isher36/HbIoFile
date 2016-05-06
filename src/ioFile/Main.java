package ioFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// ask user a path
		String path = inputText("Veuillez saisir le chemin d'un point d'entrée d'une arborescence");
		// if path doesn't exist we create it
		createDirectory(path);

		boolean addTowDirectory = inputTextYesOrNo("Voulez vous créer une arborescence à 2 niveau? yes , no",new String[] {"yes","no"});
	}

	public static boolean createDirectory(String path) {
		if (Files.notExists(Paths.get(path))) {
			try {
				Files.createDirectory(Paths.get(path));
				System.out.println(path + " non trouvé, ce chemin a été créé.");
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		} else {
			System.out.println(path + " existant et trouvé");
			return false;
		}
	}

	// Ask user to input a text and return it
	public static String inputText(String text) {
		System.out.println(text);
		String str = sc.nextLine();
		return str;
	}

	public static boolean inputTextYesOrNo(String text ) {
		String returntext ; 
		String[] param = new String[] { "yes", "no"};
		do {returntext = inputText(text); }
		while (! Arrays.asList(param).contains(returntext));
			
		//returntext
		return true;
	}

}
