package casestudy.controller;

import casestudy.model.Customer.Customer;
import casestudy.service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

    @WebServlet(name = "CustomerController",urlPatterns = "/customers")
    public class CustomerController extends HttpServlet{
        private static final long serialVersionUID = 1L;
        private CustomerService customerService;
        private Customer book;

        public void init() {
            customerService = new CustomerService();
        }
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            try {
                switch (action) {
                    case "create":
                        insertCustomer(request, response);
                        break;
                    case "edit":
                        customerService.updateCustomer(book);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }

            try {
                switch (action) {
                    case "create":
                        showNewForm(request, response);
                        break;
                    case "edit":
                        showEditForm(request, response);
                        break;
                    case "delete":
                        deleteCustomer(request, response);
                        break;
                    default:
                        listCustomer(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }

        private void listCustomer(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException, ServletException {
            List<Customer> listCustomer = customerService.selectAllCustomers();
            request.setAttribute("listCustomer", listCustomer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
            ((RequestDispatcher) dispatcher).forward(request, response);
        }

        private void showNewForm(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
            dispatcher.forward(request, response);
        }

        private void showEditForm(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            Customer existingCustomer = customerService.selectCustomer(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
            request.setAttribute("customer", existingCustomer);
            dispatcher.forward(request, response);

        }

        private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException, ServletException {
            String name = request.getParameter("name");
            String birthday = request.getParameter("birthday");
            String gender = request.getParameter("gender");
            String identify_number = request.getParameter("identify_number");
            String phone_number = request.getParameter("phone_number");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            int customerType_id =Integer.parseInt("customerType_id");
            Customer newCustomer = new Customer( name, birthday, gender, identify_number, phone_number, email, address, customerType_id);
            customerService.insertCustomer(newCustomer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
            dispatcher.forward(request, response);
        }

        private void updateUser(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException, ServletException {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String birthday = request.getParameter("birthday");
            String gender = request.getParameter("gender");
            String identify_number = request.getParameter("identify_number");
            String phone_number = request.getParameter("phone_number");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            int customerType_id = Integer.parseInt("customerType_id");
            Customer newCustomer = new Customer(name, birthday, gender, identify_number, phone_number, email, address, customerType_id);
            customerService.insertCustomer(newCustomer);

            Customer book = new Customer(name, birthday, gender, identify_number, phone_number, email, address, customerType_id);
            CustomerService.updateCusstomer(book);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
            dispatcher.forward(request, response);
        }

        private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException, ServletException {
            int id = Integer.parseInt(request.getParameter("id"));
            customerService.deleteCustomer(id);

            List<Customer> listCustomer = customerService.selectAllCustomers();
            request.setAttribute("listCustomer", listCustomer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
            dispatcher.forward(request, response);
        }
    }

