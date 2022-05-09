package com.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookapp.bean.Book;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;

public class BookImpl implements BookInter {


	PreparedStatement preparedStatement;

	ResultSet resultSet = null;

	@Override
	public void addBook(Book book) {
		Connection connection = ModelDAO.openConnection();
		String sql = "INSERT INTO book VALUES(?,?,?,?,?)";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, book.getBookid());
			preparedStatement.setInt(2, book.getPrice());
			preparedStatement.setString(3, book.getAuthor());
			preparedStatement.setString(4, book.getTitle());
			preparedStatement.setString(5, book.getCategory());

			boolean boolFlag = preparedStatement.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ModelDAO.closeConnection();
		}

	}

	@Override
	public boolean updateBook(int bookid, int price) {
		
		Connection connection = ModelDAO.openConnection();
		String sql = "UPDATE book SET price = ? WHERE bookId = ?";
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, price);
			preparedStatement.setInt(2, bookid);
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			ModelDAO.closeConnection();
		}
		if (result != 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean deleteBook(int bookid) throws BookNotFoundException {
		
		Connection connection = ModelDAO.openConnection();
		int result = 0;
		String sql = "DELETE FROM book WHERE bookId = ?";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, bookid);

			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		if (result == 0) {
			throw new BookNotFoundException("Book Not Found");
		}

		return true;
	}

	@Override
	public Book getBookById(int bookid) throws BookNotFoundException {
		Connection connection = ModelDAO.openConnection();

		String sql = "Select * FROM book WHERE bookId=?";
		Book book = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, bookid);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int bookId = resultSet.getInt(1);
				int price = resultSet.getInt(2);
				String title = resultSet.getString(3);
				String author = resultSet.getString(4);
				String category = resultSet.getString(5);
				
				book = (new Book(bookId, price, title,
						author, category));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
		if (book == null) {
			throw new BookNotFoundException("Book Not Found");
		}
		return book;
	}

	@Override
	public List<Book> getAllBooks() {
		Connection connection = ModelDAO.openConnection();

		Book book = null;

		String sql = "SELECT * FROM book";

		List<Book> bookList = new ArrayList<Book>();

		try {
			preparedStatement = connection.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				book = new Book();
				book.setTitle(resultSet.getString(3));
				book.setAuthor(resultSet.getString(4));
				book.setCategory(resultSet.getString(5));
				book.setBookid(resultSet.getInt(1));
				book.setPrice(resultSet.getInt(2));
				bookList.add(book);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ModelDAO.closeConnection();
		}

		return bookList;
	}

//	@Override
//	public List<Book> getBookbyAuthor(String author) throws AuthorNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	

	@Override
	public List<Book> getBookbyAuthor(String author) throws AuthorNotFoundException {
		Connection connection = ModelDAO.openConnection();
		List<Book> book = new ArrayList<Book>();

		String sql = "SELECT * FROM book WHERE author = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, author);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int bookId = resultSet.getInt(1);
				int price = resultSet.getInt(2);
				String title = resultSet.getString(3);
				String authorr = resultSet.getString(4);
				String categoryy = resultSet.getString(5);
				
				book.add(new Book(bookId, price, title,
						authorr, categoryy));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			ModelDAO.closeConnection();
		}
		if (book.isEmpty()) {
			throw new AuthorNotFoundException("No Books Found with Author -" + author);
		}
		return book;

	}

	@Override
	public List<Book> getBookbycategory(String category) throws CategoryNotFoundException {
		Connection connection = ModelDAO.openConnection();
		List<Book> book = new ArrayList<Book>();

		String sql = "SELECT * FROM book WHERE category = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, category);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int bookId = resultSet.getInt(1);
				int price = resultSet.getInt(2);
				String title = resultSet.getString(3);
				String author = resultSet.getString(4);
				String categoryy = resultSet.getString(5);
				
				book.add(new Book(bookId, price, title,
						author, categoryy));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			ModelDAO.closeConnection();
		}
		if (book.isEmpty()) {
			throw new CategoryNotFoundException("No Books Found with category - " + category);
		}
		return book;

	}

}
