package Client;

import Controler.ProductManager;
import Model.Product;
import Storage.Store;

import java.util.Scanner;

public class Client {
    private final ProductManager productManager;
    private final Store<Product> store;
    private final boolean UP = true;
    private final boolean DOWN = false;
    public Client() {
        this.store = new Store<>();
        this.productManager = new ProductManager(store);
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
        System.out.println(" 1. Add a product            ");
        System.out.print(" 2. Change name by ID        ");
        System.out.println("3. Change price by ID       ");
        System.out.print(" 4. Change status by ID      ");
        System.out.println("5. Change description by ID ");
        System.out.print(" 6. Find product by name     ");
        System.out.println("7. Display all of products  ");
        System.out.print(" 8. Sort by price up         ");
        System.out.println("9. Sort by price down       ");
        System.out.println(" 0. Exit");
    }
    public boolean checkId(int id){
        for (Product product : store) {
            if (product.getId() == id)
                return false;
        }
        return true;
    }
    public void app(){
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
                app();
                break;
            case 2:
                System.out.println("Enter ID to edit");
                int id2 = scanner.nextInt();
                scanner.nextLine();
                if(!checkId(id2)){
                    System.out.println("ID is wrong");
                    app();
                    break;
                }
                System.out.println("Enter a new name");
                String name2 = scanner.nextLine();
                editNameById(id2,name2);
                app();
                break;
            case 3:
                System.out.println("Enter ID to edit");
                int id3 = scanner.nextInt();
                scanner.nextLine();
                if(!checkId(id3)){
                    System.out.println("ID is wrong");
                    app();
                    break;
                }
                System.out.println("Enter a new price");
                double price3 = scanner.nextDouble();
                scanner.nextLine();
                editPriceById(id3,price3);
                app();
                break;
            case 4:
                System.out.println("Enter ID to edit");
                int id4 = scanner.nextInt();
                scanner.nextLine();
                if(!checkId(id4)){
                    System.out.println("ID is wrong");
                    app();
                    break;
                }
                System.out.println("Enter a new status");
                boolean status4 = scanner.nextBoolean();
                scanner.nextLine();
                editStatusById(id4,status4);
                app();
                break;
            case 5:
                System.out.println("Enter ID to edit");
                int id5 = scanner.nextInt();
                scanner.nextLine();
                if(!checkId(id5)){
                    System.out.println("ID is wrong");
                    app();
                    break;
                }
                System.out.println("Enter a new description");
                String description5 = scanner.nextLine();
                editDescriptionById(id5,description5);
                app();
                break;
            case 6:
                System.out.println("Enter a name of product");
                String name6 = scanner.nextLine();
                searchByName(name6);
                app();
                break;
            case 7:
                display();
                app();
                break;
            case 8:
                sortByPriceUp();
                app();
                break;
            case 9:
                sortByPriceDown();
                app();
                break;
            case 0:
                System.out.println("Good bye");
                break;
            default:
                System.out.println("Please choose from 0 to 9");
                app();
        }

    }

}
