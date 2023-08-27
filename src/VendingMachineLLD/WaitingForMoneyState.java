package VendingMachineLLD;

import java.util.Scanner;

public class WaitingForMoneyState implements State{

    private VendingMachine vendingMachine;

    public WaitingForMoneyState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("Please insert amount: " + amount + " >> ");
        Scanner sc = new Scanner(System.in);
        int enteredAmount = sc.nextInt();
        vendingMachine.setMoneyInserted(enteredAmount + vendingMachine.getMoneyInserted());
        if(vendingMachine.getMoneyInserted() >= vendingMachine.getSelectedProduct().getPrice()){
            vendingMachine.setState(new ReceivedMoneyState(vendingMachine));
        }else{
            System.out.println("Insufficient amount");
        }
    }

    @Override
    public void ejectMoney() {

    }

    @Override
    public void selectProduct(int productId) {

    }

    @Override
    public void cancelTxn() {
        vendingMachine.setSelectedProduct(null);
        vendingMachine.ejectMoney(vendingMachine.getMoneyInserted());
        vendingMachine.setState(new IdleState(vendingMachine));
    }

    @Override
    public void dispenseProduct() {

    }

    @Override
    public void deselectProduct() {

    }

    @Override
    public void displayAllProducts() {

    }

    @Override
    public void continueToPayment() {

    }
}
