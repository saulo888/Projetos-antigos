package br.unip.model;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {
	public static String read(String path) {
		String content = "";
		try {
			FileReader file = new FileReader(path);
			BufferedReader readFile = new BufferedReader(file);
			String line = "";
			try {
				line = readFile.readLine();
				while (line != null) {
					content += line + "\n";
					line = readFile.readLine();
				}
				file.close();
			} catch (IOException ex) {
				return "Não foi possível ler o arquivo!!!";
			}
		} catch (FileNotFoundException ex) {
			return "Arquivo não encontrado!";
		}
		return content;
	}

	public static boolean write(String path, String text) {
		try {
			FileWriter file = new FileWriter(path);
			PrintWriter writeFile = new PrintWriter(file);
			writeFile.println(text);
			writeFile.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
