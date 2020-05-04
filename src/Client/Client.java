package Client;

import Controler.ProductManager;
import Model.Product;
import Storage.Store;
import java.io.IOException;
import java.util.Scanner;

public class Client {
    private final ProductManager productManager;
    private final Store<Product> store;
    private final boolean UP = true;
    private final boolean DOWN = false;
    public Client() throws IOException {
        this.store = new Store<>();
        this.productManager = new ProductManager(store);
        productManager.read();
    }

    public void sortByPriceUp(){
        productManager.display(productManager.sortByPrice(UP));
    }
    public void sortByPriceDown(){
        productManager.display(productManager.sortByPrice(DOWN));
    }
    public void creat(int id,String name,double price,boolean status,String description){
        productManager.creat(id,name,price,status,description);
    }
    public void searchByName(String name){
        System.out.println(productManager.findByName(name));
    }
    public void editNameById(int id,String newName){
        productManager.editNameById(id,newName);
    }
    public void editPriceById(int id,double newPrice){
        productManager.editPriceById(id,newPrice);
    }
    public void editStatusById(int id,boolean newStatus){
        productManager.editStatusById(id,newStatus);
    }
    public void editDescriptionById(int id,String newDescription){
        productManager.editDescriptionById(id,newDescription);
    }
    public void remove(int id){
        productManager.remove(id);
    }
    public void display(){
        productManager.display(store);
    }
    public void menu(){
        System.out.println("Menu");
        System.out.print(" 1. Add a product            ");
        System.out.println("2. Edit product             ");
        System.out.print(" 3. Find product by name     ");
        System.out.println("4. Display all of products  ");
        System.out.print(" 5. Sort by price up         ");
        System.out.println("6. Sort by price down       ");
        System.out.println(" 0. Exit");
    }
    public void menuOfEdit(){
        System.out.println("Option");
        System.out.print(" 1. Edit product information   ");
        System.out.println("2. Edit product's name        ");
        System.out.print(" 3. Edit product's price       ");
        System.out.println("4. Edit product's status      ");
        System.out.print(" 5. Edit product's description ");
        System.out.println("0. Back to main menu");
    }
    public boolean checkId(int id){
        for (Product product : store) {
            if (product.getId() == id)
                return false;
        }
        return true;
    }
    public void app() throws IOException {
        Scanner scanner = new Scanner(System.in);
        menu();
        System.out.println("Enter your choose : ");
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose){
            case 1:
                System.out.println("Enter a code ID");
                int id1 = scanner.nextInt();
                scanner.nextLine();
                if(!checkId(id1)){
                    System.out.println("This id is used");
                    app();
                    break;
                }
                System.out.println("Enter a name ");
                String name1 = scanner.nextLine();
                System.out.println("Enter a price");
                double price1 = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Enter status of new product");
                boolean status1 = scanner.nextBoolean();
                scanner.nextLine();
                System.out.println("Enter product description");
                String description1 = scanner.nextLine();
                System.out.println("Product addition is successful");
                creat(id1,name1,price1,status1,description1);
                productManager.save();
                app();
                break;
            case 2:
                System.out.println("Enter ID to edit");
                int id2 = scanner.nextInt();
                scanner.nextLine();
                if(checkId(id2)){
                    System.out.println("ID is wrong");
                    app();
                    break;
                }
                menuOfEdit();
                System.out.println("Enter a choose");
                int choose2 = scanner.nextInt();
                scanner.nextLine();
                switch (choose2){
                    case 1:
                        System.out.println("Enter new name");
                        String name2 = scanner.nextLine();
                        editNameById(id2,name2);
                        System.out.println("Enter new price");
                        double price2 = scanner.nextDouble();
                        scanner.nextLine();
                        editPriceById(id2,price2);
                        System.out.println("Enter new status");
                        boolean status2 = scanner.nextBoolean();
                        scanner.nextLine();
                        editStatusById(id2,status2);
                        System.out.println("Enter new description");
                        String description2 = scanner.nextLine();
                        editDescriptionById(id2,description2);
                        break;
                    case 2:
                        System.out.println("Enter new name");
                        String name23 = scanner.nextLine();
                        editNameById(id2,name23);
                        break;
                    case 3:
                        System.out.println("Enter new price");
                        double price3 = scanner.nextDouble();
                        scanner.nextLine();
                        editPriceById(id2,price3);
                        break;
                    case 4:
                        System.out.println("Enter new status");
                        boolean status4 = scanner.nextBoolean();
                        scanner.nextLine();
                        editStatusById(id2,status4);
                        break;
                    case 5:
                        System.out.println("Enter new description");
                        String description5 = scanner.nextLine();
                        editDescriptionById(id2,description5);
                        break;
                    case 0:
                        app();
                        break;
                    default:
                        System.out.println("Please choose from 0 to 5");

                }
                app();
                break;
            case 3:
                System.out.println("Enter a name of product");
                String name3 = scanner.nextLine();
                searchByName(name3);
                app();
                break;
            case 4:
                display();
                app();
                break;
            case 5:
                sortByPriceUp();
                app();
                break;
            case 6:
                sortByPriceDown();
                app();
                break;
            case 0:
                System.out.println("Good bye");
                productManager.save();
                break;
            default:
                System.out.println("Please choose from 0 to 9");
                app();
        }

    }

}
