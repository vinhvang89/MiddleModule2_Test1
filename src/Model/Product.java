package Model;

public class Product implements ProductInformation {
    private int id;
    private String name;
    private double price;
    private boolean status;
    private String description;

    public Product(int id, String name, double price, boolean status, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    public String toString(){
        return "ID: "+id+" ,name: "+name+" ,price: "+price+" ,status: "+status+
                ", description: "+description;
    }
}
