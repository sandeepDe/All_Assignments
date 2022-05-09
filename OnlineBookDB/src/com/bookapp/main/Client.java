package com.bookapp.main;

import java.util.Scanner;

import com.bookapp.bean.Book;
import com.bookapp.dao.BookImpl;
import com.bookapp.dao.BookInter;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;

public class Client {
	private int bookId;
	private int price;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		BookInter bookInter = new BookImpl();

		for (;;) {

			System.out.println("For Admin : Enter admin");
			System.out.println("For Customr : Enter cust");
			System.out.println("ENter E for Exit");

			String inputType = scanner.next();

			if (inputType.equals("admin")) {
				System.out.println("Enter 1 to Add Book");
				System.out.println("Enter 2 to Update Book");
				System.out.println("Enter 3 to Get Book data by BookId");
				System.out.println("Enter 4 to Delete Book");

				int operation = scanner.nextInt();

				switch (operation) {
				case 1:

					System.out.println("Enter the bookId");

					int bookId = scanner.nextInt();

					System.out.println("Enter the price");

					int price = scanner.nextInt();

					System.out.println("Enter the Author");

					scanner.nextLine();
					String author = scanner.nextLine();

					System.out.println("Enter the Title");

					String title = scanner.next();

					System.out.println("Enter the Category");

					String category = scanner.next();

					bookInter.addBook(new Book(bookId, price, title, author, category));

					break;
				case 2:
					System.out.println("Enter the bookId and price to be updated");
					System.out.println("Enter bookId");

					bookId = scanner.nextInt();
					System.out.println("Enter price");
					price = scanner.nextInt();

					boolean res = bookInter.updateBook(bookId, price);

					if (res) {
						System.out.println("Price Updated Successfully");
					} else {
						System.err.println("Not Updated");
					}
					break;

				case 3:
					System.out.println("Get Book on bookId");

					int bookID = scanner.nextInt();

					try {
						System.out.println(bookInter.getBookById(bookID));
					} catch (BookNotFoundException e) {
						System.out.println(e.getMessage());
					}

					break;

				case 4:
					System.out.println("Enter the deleteId");

					int deleteBookId = scanner.nextInt();

					try {
						boolean flag = bookInter.deleteBook(deleteBookId);
						System.out.println(flag);
					} catch (BookNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				default:
					System.out.println("Invalid Input");
					break;
				}
			} else if (inputType.equals("cust")) {
				System.out.println("Enter 1 : -> Get All Books");
				System.out.println("Enter 2 : -> Get All Books based on Author");
				System.out.println("Enter 3 : Get All Books based on Category");

				int custOption = scanner.nextInt();

				switch (custOption) {
				case 1:
					System.out.println("Get all books");

					for (Book book : bookInter.getAllBooks()) {
						System.out.println(book);
					}

					break;

				case 2:
					System.out.println("Enter the Author name");
					String author = scanner.next();
					try {
						for (Book book : bookInter.getBookbyAuthor(author)) {
							System.out.println(book);
						}
					} catch (AuthorNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
					
				case 3:
					System.out.println("Enter the all boooks by category");
					String category = scanner.next();
					try {
						for (Book book : bookInter.getBookbycategory(category)) {
							System.out.println(book);
						}
					} catch (CategoryNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					break;
				}

			} else if (inputType.equalsIgnoreCase("E")) {
				System.exit(0);
			}

//		 
//		 
//		 
//		 System.out.println("get book by author");

		}

	}
}
