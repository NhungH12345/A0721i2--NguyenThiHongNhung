package bai12_Java_Collection_Framwork.bai_tap.Luyen_Tap.ultils;

import bai12_Java_Collection_Framwork.bai_tap.Luyen_Tap.entity.Product;

import java.util.Comparator;

public class SortProductByPriceAsc implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        if (p1.getPrice() == (p2.getPrice())) {
            return p1.getName().compareTo(p2.getName());
        }
        return (int) (p2.getPrice() - p1.getPrice());
    }
}
