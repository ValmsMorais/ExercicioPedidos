package application;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.printf("Name: ");
		String name = sc.nextLine();
		System.out.printf("Email: ");
		String email = sc.nextLine();
		System.out.printf("Birth date (DD/MM/YYYY): ");
		String dataNascimento = sc.nextLine();
		LocalDate nasc = LocalDate.parse(dataNascimento,formatter);
		ZonedDateTime zonedDateTime = nasc.atStartOfDay(ZoneId.systemDefault());
		Instant instant = zonedDateTime.toInstant();
		Date dateBirthClient = Date.from(instant);
		
		System.out.println("Enter order data:");
		System.out.printf("Status: ");
		String status = sc.nextLine();
		
		Order order = new Order(OrderStatus.valueOf(status), new Client(name, email, dateBirthClient));
		
		System.out.printf("How many items to this order? ");
		int quantityItemsOrder = sc.nextInt();
		sc.nextLine();
		
		for(int i = 1; i <= quantityItemsOrder; i++) {
			System.out.printf("Enter #%d item data: \n", i);
			System.out.printf("Product name: ");
			String productName = sc.nextLine();
			System.out.printf("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.printf("Quantity: ");
        	int productQuantity = sc.nextInt();
			sc.nextLine();
			order.addItem(new OrderItem(productQuantity, productPrice, new Product(productName, productPrice)));	
		}
		
		order.dadosPedido();
		
		

	}

}
