package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerServlet", urlPatterns ="/customers")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerServlet;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                break;
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int id = (int)(Math.random() * 10000);

        Customer customer = new Customer(id, name, email, address);
        this.customerServlet.save(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        request.setAttribute("message", "New customer was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreatForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                break;
            case "view":
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showCreatForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

