package VendingMachineLLD;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private List<Product> allProducts;
    private State state;
    private Product selectedProduct;

    public int getMoneyInserted() {
        return moneyInserted;
    }

    public void setMoneyInserted(int moneyInserted) {
        this.moneyInserted = moneyInserted;
    }

    private int moneyInserted;

    public VendingMachine(){
        state = new IdleState(this);
        selectedProduct = null;
        allProducts = new ArrayList<>();
        allProducts.add(new Product(1, "Coke", 10, 35));
        allProducts.add(new Product(2, "Sprite", 1, 45));
        allProducts.add(new Product(3, "Lays", 2, 20));
        moneyInserted = 0;
    }

    public void setState(State state){
        this.state = state;
        System.out.println("Current state: " + state.getClass().getName());
    }

    public State getState(){
        return state;
    }

    public void setSelectedProduct(Product selectedProduct){
        this.selectedProduct = selectedProduct;
        System.out.println("You selected " + selectedProduct.getName());
    }

    public Product getSelectedProduct(){
        return selectedProduct;
    }

    public Product getProduct(int productId){
        return allProducts.stream().filter(product -> product.getId() == productId).findFirst().orElse(null);
    }

    public void displayAllProducts(){
        for(Product p : allProducts){
            if(p.getNumber() > 0)
                System.out.println(p.toString());
        }
    }

    public void dispenseProduct(int productId) {
        Product p = allProducts.stream().filter(product -> product.getId() == productId).findFirst().orElse(null);
        if (p == null || p.getNumber() == 0) {
            System.out.println("Product doesn't exist");
        } else {
            p.setNumber(p.getNumber() - 1);
            System.out.println("Here's your " + p.getName());
        }
    }

    public void ejectMoney(int amount){
        if(amount > 0)
            System.out.println("Please collect your money: " + amount);
        setMoneyInserted(0);
    }
}
