package ioFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// ask user a path
		String path = inputText("Veuillez saisir le chemin d'un point d'entrée d'une arborescence");
		// if path doesn't exist we create it
		if (Files.notExists(Paths.get(path))) {
			try {
				Files.createDirectory(Paths.get(path));
				System.out.println(path +" non trouvé, ce chemin a été créé.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println(path +" existant et trouvé");
		}
	}

	// Ask user to input a text and return it
	public static String inputText(String text) {
		// open scanner
		System.out.println(text);
		String str = sc.nextLine();
		return str;
	}

}
