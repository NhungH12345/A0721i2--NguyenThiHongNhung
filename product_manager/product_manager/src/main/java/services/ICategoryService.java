package services;

import model.Category;
import model.Product;

import java.util.List;

public interface ICategoryService {
    List<Category> selectAllCategory();
    Category selectCategory(int id_category);
}
