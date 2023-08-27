package VendingMachineLLD;

public class IdleState implements State{

    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney(int amount) {

    }

    @Override
    public void ejectMoney() {

    }

    @Override
    public void selectProduct(int productId) {
        Product p = vendingMachine.getProduct(productId);
        if(p != null && p.getNumber() != 0){
            vendingMachine.setSelectedProduct(p);
            vendingMachine.setState(new ProductSelectedState(vendingMachine));
        }
    }

    @Override
    public void cancelTxn() {

    }

    @Override
    public void dispenseProduct() {

    }

    @Override
    public void deselectProduct() {

    }

    @Override
    public void displayAllProducts() {
        vendingMachine.displayAllProducts();
    }

    @Override
    public void continueToPayment() {

    }
}
