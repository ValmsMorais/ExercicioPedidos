package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data");
		System.out.printf("Name: ");
		String name = sc.nextLine();
		System.out.printf("Email: ");
		String email = sc.nextLine();
		System.out.printf("Birth date (DD/MM/YYYY): ");
		Date birth_date = dateFormat.parse(sc.nextLine());
		
		Client cliente = new Client(name, email, birth_date);
		System.out.println(cliente);

	}

}
