package controller;

import model.Category;
import model.Product;
import services.CategoryService;
import services.ICategoryService;
import services.IProductService;
import services.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private IProductService iProductService = new ProductService();
    private ICategoryService iCategoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                showFormCreate(request, response);
                break;
            }
            case "edit": {
                editProduct(request, response);
                break;
            }
            case "delete": {
                deleteProduct(request, response);
            }
            case "search": {
                searchProduct(request, response);
            }
            default:
                productList(request, response);
                break;
        }

    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = iCategoryService.selectAllCategory();
        request.setAttribute("listCategory", categories);
       //// List<Product> products = iProductService.selectAllProduct();
       // request.setAttribute("listProduct", products);
        request.getRequestDispatcher("product/create.jsp").forward(request, response);
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Product> products = iProductService.findAllByName(name);
        request.setAttribute("listProduct", products);
        request.getRequestDispatcher("product/list.jsp").forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String choose=request.getParameter("choose");
//        switch (choose){
//            case "yes":{
//                int id = Integer.parseInt(request.getParameter("id"));
//                iProductService.deleteProduct(id);
//                productList(request,response);
//                break;
//
//            }
//            case "no":{
//                productList(request,response);
//                break;

//            }
//        }
        int id = Integer.parseInt(request.getParameter("id"));
        iProductService.deleteProduct(id);
        productList(request, response);
    }
    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = iProductService.selectProduct(id);
        List<Category>categoryList=iCategoryService.selectAllCategory();
        request.setAttribute("product", product);
        request.setAttribute("category",categoryList);
        request.getRequestDispatcher("product/edit.jsp").forward(request, response);
    }
    private void productList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> listProduct = iProductService.selectAllProduct();
        request.setAttribute("listProduct", listProduct);
        List<Category> categoryList=iCategoryService.selectAllCategory();
          request.setAttribute("listCategory",categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                createProduct(request, response);
                break;
            }
            case "edit": {
                  updateProduct(request, response);
                break;
            }
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        int id_category = Integer.parseInt(request.getParameter("id_category"));
        Category category = iCategoryService.selectCategory(id_category);

        Product product = new Product(name, price, quantity, color, category);
        iProductService.updateProduct(product);
        //  request.setAttribute("message","Edit successfully!!");
       productList(request,response);

    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        int id_category = Integer.parseInt(request.getParameter("id_category"));
        //Category category = iCategoryService.selectCategory(id_category);
//        String name_category=request.getParameter("name_category");

        Product product = new Product(name, price, quantity, color, new Category(id_category));
        iProductService.insertProduct(product);
        // RequestDispatcher dispatcher=request.getRequestDispatcher("list.jsp");
        productList(request, response);
    }
}

