package com.ra.presentation;

import com.ra.entity.Category;
import com.ra.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopManagement {
    private static List<Category> categories = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        do {
            System.out.println("******************SHOP MENU*******************\n" +
                    "\n");
            System.out.println("1 . Quản lý danh mục sản phẩm");
            System.out.println("2. Quan ly san pham");
            System.out.println("3. Thoat");
            System.out.println("Moi ban chon 1 - 3");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    boolean isCheck = true;
                    do {
                        System.out.println("********************CATEGORIES MENU***********");
                        System.out.println("1. Nhập thông tin các danh mục\n" +
                                "\n");
                        System.out.println("2. Hiển thị thông tin các danh mục\n" +
                                "\n");
                        System.out.println("3. Cập nhật thông tin danh mục\n" +
                                "\n");
                        System.out.println("4. Xóa danh mục\n" +
                                "\n");
                        System.out.println("5. Cập nhật trạng thái danh mục\n" +
                                "\n");
                        System.out.println("6. Thoat ");
                        System.out.println("Vui long chon 1 - 6");
                        int choiceCase = Integer.parseInt(input.nextLine());
                        switch (choiceCase) {
                            case 1:
                                inputCategories();
                                break;
                            case 2:
                                displayCategories();
                                break;
                            case 3:
                                updateCategory();
                                break;
                            case 6:
                                deleteCategory();
                                isCheck = false;
                                break;
                        }
                    } while (isCheck);
                    break;
                case 2:
                    break;
                case 3:
                    System.exit(0);
            }
        } while (true);
    }
    public static void inputCategories(){
        System.out.println("Ban muon nhap bao nhieu danh muc");
        int n =  Integer.parseInt(input.nextLine());
        for(int i = 0; i < n; i++){
            System.out.println("Nhap danh muc thu "+(i+1));
            Category category = new Category();
            category.inputData(input,categories);
            categories.add(category);
        }
    }
    public static void displayCategories(){
        System.out.println("Danh sach Danh muc");
        for(Category category : categories){
            category.displayData();
        }
    }

    public static void updateCategory(){
        System.out.println("Nhap vao ma danh muc can sua");
        int categoryId =  Integer.parseInt(input.nextLine());

        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getCatalogId() == categoryId) {
                Category category = categories.get(i);
                category.inputUpdateData(input,categories);
                categories.set(i,category);
                return;
            }
        }
        System.err.println("Khong tim thay danh muc nao");
    }

    public static void deleteCategory(){
        System.out.println("Nhap vao ma danh muc xoa");
        int categoryId =  Integer.parseInt(input.nextLine());

        for (Category category : categories) {
            if (category.getCatalogId() == categoryId) {
                categories.remove(category);
                return;
            }
        }
        System.err.println("Khong tim thay danh muc nao");
    }
}
