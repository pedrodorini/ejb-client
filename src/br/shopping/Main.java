package br.shopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.naming.InitialContext;

import br.cart.ICartBean;
import br.inventory.Product;

public class Main {
	
	public static void main(String[] args) {
		Main main = new Main();
		main.EJB();
	}
	
	private void EJB() {
		ICartBean cart;
		try {
			InitialContext context = new InitialContext(JNDIConfig.getConfigs());
			cart = (ICartBean) context.lookup("ejb:/ejb-cart/CartBean!br.cart.ICartBean?stateful");
			Scanner scanner = new Scanner(System.in);
			boolean continuing = true;
			do {
				System.out.println("Pressione 1 para ver os itens e adicionar no carirnho");
				System.out.println("Pressione 2 para ver os itens no carrinho");
				System.out.println("Pressione 3 para ver o valor total");
				System.out.println("Pressione 4 para remover itens do carrinho");
				int input = scanner.nextInt();
				if (input == 1) {
					cart.products();
					System.out.println("Digite o numero do produto que quer adicionar no carrinho: ");
					input = scanner.nextInt();
					List<Product> products = cart.getInventory();
					cart.addItem(products.get(input - 1));
				} else if (input == 2) {
					cart.showProductsInCart();
				} else if (input == 3) {
					System.out.println(cart.totalValue());
				} else if (input == 4) {
					cart.showProductsInCart();
					System.out.println("Digite o numero do produto que quer remover do carrinho: ");
					input = scanner.nextInt();
					cart.removeItem(input-1);
				} else {
					continuing = false;
					System.out.println("Saindo...");
				}
			} while (continuing);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 }
