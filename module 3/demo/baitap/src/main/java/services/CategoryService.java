package services;

import model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategoryService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/bai_tap";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345";
    //    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO products" + "  (name, price,quantity,color,category) VALUES " +
//            " (?, ?, ?,?,?);";
    private static final String SELECT_CATEGORY_BY_ID = "select * from category where id_category =?";
    private static final String SELECT_ALL_CATEGORY = "select * from category";
//    private static final String DELETE_PRODUCTS_SQL = "delete from products where id = ?;";
//    private static final String UPDATE_PRODUCTS_SQL = "update products set name = ?,price = ?,quantity = ?,color = ?,category = ? where id = ?";


    public CategoryService() {
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
    public List<Category> selectAllCategory() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Category> categories = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id_category = rs.getInt("id_category");
                String name_category = rs.getString("name_category");
                categories.add(new Category(id_category, name_category));
            }
        } catch (SQLException e) {
            //  printSQLException(e);
        }
        return categories;
    }

    @Override
    public Category selectCategory(int id_category) {
        Category category = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID);) {
            preparedStatement.setInt(1, id_category);
            // System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name_category = rs.getString("name_category");
                category = new Category(id_category, name_category);
            }
        } catch (SQLException e) {
            // printSQLException(e);
        }
        return category;
    }
}



