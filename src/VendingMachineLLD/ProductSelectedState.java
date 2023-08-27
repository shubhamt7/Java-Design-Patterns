package VendingMachineLLD;

public class ProductSelectedState implements State{

    public ProductSelectedState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    private VendingMachine vendingMachine;

    @Override
    public void insertMoney(int amount) {

    }

    @Override
    public void ejectMoney() {

    }

    @Override
    public void selectProduct(int productId) {

    }

    @Override
    public void cancelTxn() {

    }

    @Override
    public void dispenseProduct() {

    }

    @Override
    public void deselectProduct() {
        vendingMachine.setState(new IdleState(vendingMachine));
    }

    @Override
    public void displayAllProducts() {

    }

    @Override
    public void continueToPayment(){
        vendingMachine.setState(new WaitingForMoneyState(vendingMachine));
    }
}
