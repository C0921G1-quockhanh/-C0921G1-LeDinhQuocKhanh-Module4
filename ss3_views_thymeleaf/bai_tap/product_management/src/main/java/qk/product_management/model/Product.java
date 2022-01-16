package qk.product_management.model;

public class Product {
    protected int id;
    protected String name;
    protected String typeOfProduct;
    protected Integer price;

    public Product() {
    }

    public Product(int id, String name, String typeOfProduct, Integer price) {
        this.id = id;
        this.name = name;
        this.typeOfProduct = typeOfProduct;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(String typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}