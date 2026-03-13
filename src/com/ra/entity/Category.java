package com.ra.entity;

import com.ra.IShop;

import java.util.List;
import java.util.Scanner;

public class Category implements IShop {
    private int catalogId;
    private String categoryName;
    private String description;
    private boolean catalogStatus;

    public Category() {
    }

    public Category(int catalogId, String categoryName, String description, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.categoryName = categoryName;
        this.description = description;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    @Override
    public void displayData() {
        System.out.println("ID :"+this.getCatalogId());
        System.out.println("Name :"+this.getCategoryName());
        System.out.println("Description :"+this.getDescription());
        System.out.println("Status :"+(this.isCatalogStatus() ? "Hoat Dong":"Khong Hoat Dong"));
    }

    public void inputData(Scanner scanner, List<Category> categories) {
        // xu ly Id tu tang bat dau tu 1
        if(categories.isEmpty()) {
            this.catalogId = 1;
        } else {
            int maxCategoryId = categories.get(0).getCatalogId(); // lau Id cua phan tu dau tien trong list gan max
            for (Category category : categories) {
                if(category.getCatalogId() > maxCategoryId) {
                    maxCategoryId = category.getCatalogId();
                }
            }
            this.catalogId = maxCategoryId + 1;
        }

        // Nhap thong tin
        System.out.println("Moi ban nhap vao ten danh muc : ");
        while (true){
            this.categoryName = scanner.nextLine();
            if(this.categoryName.length() > 50){
                System.err.println("Ten danh muc phai nho hon 50 ky tu");
            } else {
                // kiem tra trung lap ten
                boolean categoryNameIsExist = false;
                for (Category category : categories) {
                    if(category.getCategoryName().equals(this.categoryName)){
                        categoryNameIsExist = true;
                        break;
                    }
                }
                if(!categoryNameIsExist){
                    break;
                } else {
                    System.err.println("Ten "+this.categoryName+" Da ton tai ");
                }
            }
        }
        System.out.println("Nhap vao mo ta danh muc");
        this.description = scanner.nextLine();
        System.out.println("Nhap vao trang thai danh muc");
        this.catalogStatus = Boolean.parseBoolean(scanner.nextLine());

    }

    public void inputUpdateData(Scanner scanner, List<Category> categories){
        // Nhap thong tin
        System.out.println("Moi ban nhap vao ten danh muc moi : ");
        while (true){
            this.categoryName = scanner.nextLine();
            if(this.categoryName.length() > 50){
                System.err.println("Ten danh muc phai nho hon 50 ky tu");
            } else {
                // kiem tra trung lap ten
                boolean categoryNameIsExist = false;
                for (Category category : categories) {
                    if(category.getCategoryName().equals(this.categoryName) && category.getCatalogId() != this.catalogId){
                        categoryNameIsExist = true;
                        break;
                    }
                }
                if(!categoryNameIsExist){
                    break;
                } else {
                    System.err.println("Ten "+this.categoryName+" Da ton tai ");
                }
            }
        }
        System.out.println("Nhap vao mo ta danh muc");
        this.description = scanner.nextLine();
        System.out.println("Nhap vao trang thai danh muc");
        this.catalogStatus = Boolean.parseBoolean(scanner.nextLine());
    }
}
