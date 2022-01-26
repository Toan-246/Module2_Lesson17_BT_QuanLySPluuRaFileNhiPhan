package com.codegym;

import java.util.ArrayList;
import java.util.List;

public class ProductManagement {
    public List<Product> productList = new ArrayList<>();

    public int size() {
        return productList.size();
    }

    public void showAllProduct() {
        for (int i = 0; i < size(); i++) {
            System.out.println(productList.get(i));
        }
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public int serchProduct(String id) {
        int index = -1;
        for (int i = 0; i < size(); i++) {
            if (productList.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Product getProduct (int index){
        return productList.get(index);
    }
}
