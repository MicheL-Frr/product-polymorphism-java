package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char option = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			sc.nextLine();

			if (option == 'c') {
				list.add(new Product(name, price));
			} else if (option == 'u') {
				try {
					System.out.print("Manufacture date (DD/MM/YYYY): ");
					String dateStr = sc.nextLine();
					Date manufactureDate = sdf.parse(dateStr);
					list.add(new UsedProduct(name, price, manufactureDate));
				} catch (ParseException e) {
					System.out.println("Error converting data! Invalid format.");
				}
			} else {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				sc.nextLine();
				list.add(new ImportedProduct(name, price, customsFee));
			}
		}
		System.out.println();
		for (Product product : list) {
			System.out.println(product.priceTag());
		}

		sc.close();
	}

}
