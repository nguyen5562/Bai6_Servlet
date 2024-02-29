package com.example.Bai6_Servlet.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/create-book")
public class CreateBook extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create-book.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String longDescription = request.getParameter("longDescription");
        String shortDescription = request.getParameter("shortDescription");
        Integer cost = Integer.parseInt(request.getParameter("cost"));

        Book book = new Book();
        book.setId(id);
        book.setLongDescription(longDescription);
        book.setShortDescription(shortDescription);
        book.setCost(cost);

        int status = BookDAO.createBook(book);
        if (status > 0) {
            response.sendRedirect("view-books");
        } else {
            out.println("Sorry! unable to save record");
        }

        out.close();
    }
}
