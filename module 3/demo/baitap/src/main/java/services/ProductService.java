package services;

import model.Category;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private ICategoryService iCategoryService = new CategoryService();
    private String jdbcURL = "jdbc:mysql://localhost:3306/bai_tap";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345";
    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO products" + "  (name, price,quantity,color,id_category) VALUES " +
            " (?, ?, ?,?,?);";
    private static final String SELECT_PRODUCTS_BY_ID = "select * from products join category on category.id_category=product.id_category where id=?";
    private static final String SELECT_ALL_PRODUCTS = "select * from products join category where products.id_category=category.id_category;";
    private static final String DELETE_PRODUCTS_SQL = "delete from products where id = ?;";
    private static final String UPDATE_PRODUCTS_SQL = "update products set name = ?,price = ?,quantity = ?,color = ?,category = ? where id = ?";
    private static final String SELECT_PRODUCTS_BY_NAME = "call find_by_name(?);";

    public ProductService() {
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

    @Override
    public void insertProduct(Product product) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTS_SQL)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setInt(5, product.getCategory().getId_category());
            // System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // printSQLException(e);
        }
    }
    @Override
    public Product selectProduct(int id) {
        Product product = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_BY_ID);) {
            preparedStatement.setInt(1, id);
            // System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                int id_category = rs.getInt("id_category");
                String name_category=rs.getString("name_category");
                product = new Product(id, name, price, quantity, color, new Category(id_category,name_category));
            }
        } catch (SQLException e) {
            // printSQLException(e);
        }
        return product;
    }


    public List<Product> selectAllProduct() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Product> products = new ArrayList<>();

        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                int id_category = rs.getInt("id_category");
                String name_category=rs.getString("name_category");
              //  Category category = iCategoryService.selectCategory(id_category);
                products.add(new Product(id, name, price, quantity, color, new Category(id_category,name_category)));
            }
        } catch (SQLException e) {
            //  printSQLException(e);
        }
        return products;
    }


    @Override
    public boolean deleteProduct(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCTS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateProduct(Product product) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCTS_SQL);) {
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setInt(5,product.getCategory().getId_category());
            statement.setInt(6, product.getId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public List<Product> findAllByName(String name) {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Product> products = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(SELECT_PRODUCTS_BY_NAME)) {

            callableStatement.setString(1, name);
            // Step 3: Execute the query or update query
            ResultSet rs = callableStatement.executeQuery();
            Product product;
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setColor(rs.getString("color"));
                products.add(product);
            }
        } catch (SQLException e) {
            //  printSQLException(e);
        }
        return products;
    }

}

