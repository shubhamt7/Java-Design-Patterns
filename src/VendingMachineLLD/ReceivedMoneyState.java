package VendingMachineLLD;

public class ReceivedMoneyState implements State{

    private VendingMachine vendingMachine;

    public ReceivedMoneyState(VendingMachine vendingMachine){
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

    }

    @Override
    public void cancelTxn() {

    }

    @Override
    public void dispenseProduct() {
        vendingMachine.dispenseProduct(vendingMachine.getSelectedProduct().getId());
        vendingMachine.setState(new IdleState(vendingMachine));
        vendingMachine.ejectMoney(vendingMachine.getMoneyInserted() - vendingMachine.getSelectedProduct().getPrice());
    }

    @Override
    public void deselectProduct() {

    }

    @Override
    public void displayAllProducts() {

    }

    @Override
    public void continueToPayment(){

    }
}
