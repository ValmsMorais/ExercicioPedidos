package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment = new Date();
	private OrderStatus status;
	private Client cliente;
	private List<OrderItem> itens = new ArrayList<>();
	
	public Order() {
		super();
	}

	public Order(OrderStatus status, Client cliente) {
		super();
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}

	public List<OrderItem> getItens() {
		return itens;
	}

	public void setItens(List<OrderItem> itens) {
		this.itens = itens;
	}
	
	public void addItem (OrderItem item) {
		itens.add(item);
	}
	
	public void removeItem(OrderItem item) {
		itens.remove(item);
	}
	
	public void dadosPedido() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String formattedDateMomment = formatter.format(this.moment);
		
		System.out.printf("\n\nORDER SUMMARY: \n");
		System.out.printf("Order moment: %s\n", formattedDateMomment);
		System.out.printf("Order status: %s\n", this.status);
		System.out.println(this.cliente);
		System.out.println("Order items:");
		double totalPrice = 0.0;
		for (OrderItem item : this.itens) {
			System.out.println(item.getProduto().getName() + ", $" + item.getProduto().getPrice() + ", Quantity: " + item.getQuantity() + ", Subtotal: $" + (item.getQuantity() * item.getPrice()));
			totalPrice += (item.getQuantity() * item.getPrice());	
		}
		System.out.println("Total price: $" + totalPrice);
	}

}
