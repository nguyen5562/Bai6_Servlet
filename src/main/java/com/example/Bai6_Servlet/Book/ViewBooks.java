package com.example.Bai6_Servlet.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/view-books")
public class ViewBooks extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<a href='create-book'>Add New Book</a>");
        List<Book> list = BookDAO.getAllBook();
        String docType =
                "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
                        "Transitional//EN\">\n";
        out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + "Danh sach book" + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + "Danh sach book" + "</H1>");
        Book item;
        for (int i = 0; i < list.size(); i++) {
            out.println("<HR>");
            item = list.get(i);
            out.println();
            String formURL = "cart";
            // Pass URLs that reference own site through encodeURL.
            formURL = response.encodeURL(formURL);
            out.println
                    ("<FORM ACTION=\"" + formURL + "\">\n" +
                            "<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\" " +
                            "       VALUE=\"" + item.getId() + "\">\n" +
                            "<H2>" + item.getShortDescription() +
                            " ($" + item.getCost() + ")</H2>\n" +
                            item.getLongDescription() + "\n" +
                            "<P>\n<CENTER>\n" +
                            "<INPUT TYPE=\"SUBMIT\" " +
                            "VALUE=\"Add to Shopping Cart\">\n" +
                            "</CENTER>\n<P>\n</FORM>");
        }
        out.println("<HR>\n</BODY></HTML>");
    }
}
