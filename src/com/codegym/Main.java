package com.codegym;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProductManagement productManagement = new ProductManagement();
        productManagement.addProduct(new Product("001","Iphone 10","Apple",13000000,"2018"));
        int choice = -1;
        do {
            menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    showAllProduct(productManagement);
                    break;
                }
                case 2: {
                    Product product = getProduct();
                    productManagement.addProduct(product);
                    break;
                }
                case 3: {
                    serchProductById(productManagement);

                    break;
                }

                default: {
                    break;
                }
            }
        } while (choice != 0);
        List<Product> products = new ArrayList<>();
        writetoFile(products);
        List<Product> newProducts = new ArrayList<>();
        try {
            InputStream is = new FileInputStream("product.txt");
            ObjectInputStream ois = new ObjectInputStream(is);
            newProducts = (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Product product:newProducts) {
            System.out.println(product);
        }

    }
    private static void writetoFile(List<Product> products) {
        try {
            OutputStream os = new FileOutputStream("product.txt");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void serchProductById(ProductManagement productManagement) {
        System.out.println("---Tìm kiếm SP theo ID---");
        System.out.println("Nhập ID cần tìm");
        scanner.nextLine();
        String id = scanner.nextLine();
        int index = productManagement.serchProduct(id);

        if (index!= -1){
            System.out.println("Thông tin SP là: " + productManagement.getProduct(index));
        }
        else {
            System.out.println("Không tìm thấy SP");
        }
    }

    private static void showAllProduct(ProductManagement productManagement) {
        int size = productManagement.size();
        System.out.println("---Hiển thị SP---");
        if (size == 0) {
            System.out.println("Không có SP nào");
        } else {
            productManagement.showAllProduct();
        }
    }

    public static Product getProduct() {
        System.out.println("---Thêm SP---");
        System.out.println("Nhập ID");
        scanner.nextLine();
        String id = scanner.nextLine();
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhà SX");
        String producer = scanner.nextLine();
        System.out.println("Nhập giá");
        double price = scanner.nextDouble();
        System.out.println("Nhập mô tả");
        scanner.nextLine();
        String discription = scanner.nextLine();
        Product product = new Product(id, name, producer, price, discription);
        return product;
    }

    public static void menu() {
        System.out.println("---Menu quản lý SP---");
        System.out.println("1. Hiển thị toàn bộ SP");
        System.out.println("2. Thêm 1 SP");
        System.out.println("3. Tìm kiếm SP theo ID");
        System.out.println("0. Thoát");
        System.out.println("Mời bạn nhập lựa chọn");
    }
}
