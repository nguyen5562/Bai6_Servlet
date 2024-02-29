package com.example.Bai6_Servlet.Book;

import com.example.Bai6_Servlet.Context.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public static Connection getConn() {
        Connection conn = null;

        try {
            conn = new DBContext().getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public static int createBook(Book book) {
        int status = 0;

        try {
            Connection conn = BookDAO.getConn();
            PreparedStatement ps = conn.prepareStatement("insert into book(id,longDescription,shortDescription,cost) values (?,?,?,?)");
            ps.setString(1, book.getId());
            ps.setString(2, book.getLongDescription());
            ps.setString(3, book.getShortDescription());
            ps.setInt(4, book.getCost());
            status = ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return status;
    }

    public static int updateBook(Book book) {
        int status = 0;

        try {
            Connection conn = BookDAO.getConn();
            PreparedStatement ps = conn.prepareStatement("update book set longDescription=?,shortDescription=?,cost=? where id=?");
            ps.setString(1,book.getLongDescription());
            ps.setString(2,book.getShortDescription());
            ps.setInt(3,book.getCost());
            ps.setString(4,book.getId());
            status = ps.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int deleteBook(String id) {
        int status = 0;

        try {
            Connection conn = BookDAO.getConn();
            PreparedStatement ps = conn.prepareStatement("delete from book where id=?");
            ps.setString(1,id);
            status = ps.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static List<Book> getAllBook() {
        List<Book> books = new ArrayList<Book>();

        try {
            Connection conn = BookDAO.getConn();
            PreparedStatement ps = conn.prepareStatement("select * from book");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book b = new Book();
                b.setId(rs.getString(1));
                b.setLongDescription(rs.getString(2));
                b.setShortDescription(rs.getString(3));
                b.setCost(rs.getInt(4));
                books.add(b);
            }

            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return books;
    }

    public static Book getBookById(String id) {
        Book b = new Book();

        try {
            Connection conn = BookDAO.getConn();
            PreparedStatement ps = conn.prepareStatement("select * from book where id=?");
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                b.setId(rs.getString(1));
                b.setLongDescription(rs.getString(2));
                b.setShortDescription(rs.getString(3));
                b.setCost(rs.getInt(4));
            }

            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return b;
    }
}
