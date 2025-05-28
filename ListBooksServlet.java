package com.library;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
@WebServlet("/listBooks")
public class ListBooksServlet extends HttpServlet {
    private BookService service = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = service.getAllBooks();
        req.setAttribute("bookList", books);
        req.getRequestDispatcher("book-list.jsp").forward(req, resp);
    }
}
