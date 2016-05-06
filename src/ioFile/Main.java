package ioFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// ask user a path
		String pathText = inputText("Veuillez saisir le chemin d'un point d'entrée d'une arborescence");
		Path path = Paths.get(pathText);
		// if path doesn't exist we create it
		createDirectory(path);

		boolean addTowDirectory = inputTextYesOrNo("Voulez vous créer une arborescence à 2 niveau? yes , no");
		if ( addTowDirectory ){
			//create first directory
			createDirectory(path,"rep1");
			//create second directory
			createDirectory(path,"rep2");
		}
		else
		{
			System.out.println("ok on crée rien!");
		}
	}

	// create directory with sub folder
	public static boolean createDirectory(Path path,String SubDirectory) {
		Path uri = path.resolve(path);
		// if we have a sub directory, we add it to path
		if ( SubDirectory != null)
			uri = uri.resolve(SubDirectory);
		return createDirectory(uri);
	}
	
	// create directory
	public static boolean createDirectory(Path path) {
			
		if (Files.notExists(path)) {
			try {
				Files.createDirectory(path);
				System.out.println(path.toString() + " non trouvé, ce chemin a été créé.");
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		} else {
			System.out.println(path.toString() + " existant et trouvé");
			return false;
		}
	}

	// Ask user to input a text and return it
	public static String inputText(String text) {
		System.out.println(text);
		String str = sc.nextLine();
		return str;
	}

	// ask yes or no to user and return true or false
	public static boolean inputTextYesOrNo(String text ) {
		String returntext ; 
		String[] param = new String[] { "yes", "no"};
		do {returntext = inputText(text); }
		while (! Arrays.asList(param).contains(returntext));
			
		return returntext.equals("yes") ? true : false ;
	}

}
