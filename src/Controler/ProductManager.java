package Controler;
import Model.Product;
import Storage.Store;

public class ProductManager implements Function {
    private final Store<Product> store;

    public ProductManager(Store<Product> store) {
        this.store = store;
    }
    public void creat(int id,String name,double price,boolean status,String description){
        Product product = new Product(id, name, price, status, description);
        store.add(product);
    }
    @Override
    public String findByName(String name) {
        String result ="";
        for (Product value : store) {
            if (value.getName().contains(name)) {
                result += value.toString();
                result += "\n";
            } else
                return "We dont have any product like that";
        }
        return result;
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < store.size() ; i++) {
            if( store.get(i).getId() == id){
                store.remove(i);
                break;
            }
        }
    }

    @Override
    public Store<Product> sortByPrice(boolean up) {
        Store<Product> tempList = store;
        Product temp ;
        for (int i = 0; i < tempList.size() -1 ; i++) {
            for (int j = i +1; j < tempList.size() ; j++) {
                if( up) {
                    if (tempList.get(i).getPrice() > tempList.get(j).getPrice()) {
                        temp = tempList.get(i);
                        tempList.set(i, tempList.get(j));
                        tempList.set(j, temp);
                    }
                } else {
                    if (tempList.get(i).getPrice() < tempList.get(j).getPrice()) {
                        temp = tempList.get(i);
                        tempList.set(i, tempList.get(j));
                        tempList.set(j, temp);
                    }
                }
            }
        }
        return tempList;
    }

    @Override
    public void editNameById(int id, String newName) {
        Product temp;
        for (int i = 0; i < store.size() ; i++) {
            if( store.get(i).getId() == id){
                temp = store.get(i);
                temp.setName(newName);
                store.set(i,temp);
            }

        }
    }

    @Override
    public void editPriceById(int id, double price) {
        Product temp;
        for (int i = 0; i < store.size() ; i++) {
            if( store.get(i).getId() == id){
                temp = store.get(i);
                temp.setPrice(price);
                store.set(i,temp);
            }

        }
    }

    @Override
    public void editStatusById(int id, boolean status) {
        Product temp;
        for (int i = 0; i < store.size() ; i++) {
            if( store.get(i).getId() == id){
                temp = store.get(i);
                temp.setStatus(status);
                store.set(i,temp);
            }

        }
    }

    @Override
    public void editDescriptionById(int id, String newDescription) {
        Product temp;
        for (int i = 0; i < store.size() ; i++) {
            if( store.get(i).getId() == id){
                temp = store.get(i);
                temp.setDescription(newDescription);
                store.set(i,temp);
            }

        }
    }
    public void display(Store<Product> store){
        for (Product value : store) {
            System.out.println(value.toString());
        }
    }
}
