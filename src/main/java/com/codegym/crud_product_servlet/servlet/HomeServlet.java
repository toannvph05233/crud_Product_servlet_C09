package com.codegym.crud_product_servlet.servlet;

import com.codegym.crud_product_servlet.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/products")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print("<a href='/create'>create</a>");
        String str = "<table border='1'>\n" +
                "    <tr>\n" +
                "        <th>id</th>\n" +
                "        <th>name</th>\n" +
                "        <th>price</th>\n" +
                "        <th>delete</th>\n" +
                "    </tr>";
        for (int i = 0; i < ProductService.products.size(); i++) {
            str += "    <tr>\n" +
                    "        <th>" + ProductService.products.get(i).getId() + "</th>\n" +
                    "        <th>" + ProductService.products.get(i).getName() + "</th>\n" +
                    "        <th>" + ProductService.products.get(i).getPrice() + "</th>\n" +
                    "        <th><a href='delete?id=" + ProductService.products.get(i).getId() + "'>delete</a></th>\n" +
                    "    </tr>";
        }
        str += "</table>";

        writer.print(str);
    }
}
