package ATM;

import java.util.Scanner;

public class SelectOperationState implements ATMState{

    private ATMKiosk atmKiosk;

    public SelectOperationState(ATMKiosk atmKiosk){
        this.atmKiosk = atmKiosk;
        System.out.println("Current State: " + this.getClass().getName());
    }

    @Override
    public void enterCard(int cardNo) {

    }

    @Override
    public void ejectCard() {
        atmKiosk.setCurrentUser(null);
        atmKiosk.setState(new IdleState(atmKiosk));
    }

    @Override
    public void authenticateCard(int pin) {

    }

    @Override
    public void selectOperation(int operationNumber) {
        if(operationNumber == 1){
            showBalance();
        }else if(operationNumber == 2){
            withdrawMoney();
        }else if(operationNumber == 3){
            exitTxn();
            return;
        }
        atmKiosk.displayAllOperations();
    }

    @Override
    public void showBalance() {
        System.out.println("Your account balance is: " + atmKiosk.getCurrentUser().getBalance());
    }

    @Override
    public void withdrawMoney() {
        System.out.println("Please enter amount: ");
        int amount;
        Scanner sc = new Scanner(System.in);
        amount = sc.nextInt();
        System.out.println("Amount entered: " + amount);
        atmKiosk.withdraw(amount);
    }

    @Override
    public void exitTxn() {
        System.out.println("See you next time!");
        ejectCard();
    }
}
