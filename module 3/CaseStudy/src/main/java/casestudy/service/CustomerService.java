package casestudy.service;

import casestudy.model.Customer.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345";
    private static final String INSERT_CUSTOMERS_SQL = ="INSERT INTO customers"+"  (name, birthday, gender, identify_number, phone_number, email, address, customerType_id) VALUES "+
            " (?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_CUSTOMER_BY_ID = "select id,name,birthday,gender,identify_number,phone_number,email,address,customerType_id from customers where id =?";
    private static final String SELECT_ALL_CUSTOMERS = "select * from customers";
    private static final String DELETE_CUSTOMERS_SQL = "delete from customers where id = ?;";
    private static final String UPDATE_CUSTOMERS_SQL = "update customers set name = ?, birthday= ?, gender =?, identify_number =?, phone_number =?, email =?, address =?, customerType_id =?  where id = ?;";
    private Object Customer;

    public CustomerService() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public void insertCustomer(Customer customer) throws SQLException {
        System.out.println(INSERT_CUSTOMERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMERS_SQL)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getBirthday());
            preparedStatement.setString(3, customer.getGender());
            preparedStatement.setString(4, customer.getIdentify_number());
            preparedStatement.setString(5, customer.getPhone_number());
            preparedStatement.setString(5, customer.getEmail());
            preparedStatement.setString(6, customer.getAddress());
            preparedStatement.setInt(7, customer.getCustomerType_id());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Customer selectCustomer(int id) {
        Customer customer = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String birthday = rs.getString("birthday");
                String gender = rs.getString("gender");
                String identify_number = rs.getString("identify_number");
                String phone_number = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int customerType_id = rs.getInt("customerType_id");
                Customer = new Customer(name, birthday, gender, identify_number, phone_number, email, address, customerType_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
    }

    public List<Customer> selectAllCustomers() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Customer> customers = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String birthday = rs.getString("birthday");
                String gender = rs.getString("gender");
                String identify_number = rs.getString("identify_number");
                String phone_number = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int customerType_id = rs.getInt("customerType_id");
                customers.add(new Customer(name, birthday, gender, identify_number, phone_number, email, address, customerType_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customers;
    }

    public boolean deleteCustomer(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMERS_SQL);) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getBirthday());
            statement.setString(3, customer.getGender());
            statement.setString(4, customer.getIdentify_number());
            statement.setString(5, customer.getPhone_number());
            statement.setString(6, customer.getEmail());
            statement.setString(7, customer.getAddress());
            statement.setInt(8, customer.getCustomerType_id());


            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }

        }
    }
    
}
