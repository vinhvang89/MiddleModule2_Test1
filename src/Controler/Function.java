package Controler;

import Model.Product;
import Storage.Store;

public interface Function {
    String findByName(String name);
    Store<Product> sortByPrice(boolean up);
    void remove(int id);
    void editNameById(int id , String newName);
    void editPriceById(int id, double price);
    void editStatusById(int id,boolean status);
    void editDescriptionById(int id , String newDescription);
}
