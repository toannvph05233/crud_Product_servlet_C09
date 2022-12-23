package com.codegym.crud_product_servlet.servlet;

import com.codegym.crud_product_servlet.model.Product;
import com.codegym.crud_product_servlet.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/create")
public class CreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = "<form action='/create' method='post'>\n" +
                "    <input name='id' placeholder='nhap id'><br>\n" +
                "    <input name='name' placeholder='nhap name'><br>\n" +
                "    <input name='price' placeholder='nhap price'><br>\n" +
                "    <button type='submit'>Create</button>\n" +
                "</form>";
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print(str);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        double price = Double.parseDouble(req.getParameter("price"));
        String name = req.getParameter("name");
        ProductService.products.add(new Product(id,name,price));
        resp.sendRedirect("/products");
    }
}
