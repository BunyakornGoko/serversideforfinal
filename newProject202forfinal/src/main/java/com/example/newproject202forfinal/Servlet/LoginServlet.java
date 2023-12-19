package com.example.newproject202forfinal.Servlet;

import com.example.newproject202forfinal.entity.Customer;
import com.example.newproject202forfinal.repository.CustomerRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("psw");
        String userName = request.getParameter("uname");
        if (userName == null || userName.trim().length() == 0) {
            response.addHeader("error" , "Invalid user name !!!");
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        CustomerRepository customerRepository = new CustomerRepository();
        Customer customer = customerRepository.findByName(userName);
        if (customer == null) {
            response.addHeader("error" , "User" + userName + "dose not exist !!!");
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        } else {
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d, 16, 16);
            char[] passwordArray = password.toCharArray();
            System.out.println("-------------------------");
            System.out.println(customer.getPassword());
            System.out.println(password);

            boolean isOk = argon2.verify(customer.getPassword(), passwordArray);
            if (!isOk) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                response.addHeader("error" , "Incorrect password !!!");
            } else {
                request.getSession().setAttribute("user", customer);
                request.getSession().setAttribute("username" , userName);
            }
            request.getRequestDispatcher("/office-list").forward(request,response);
        }
    }
}