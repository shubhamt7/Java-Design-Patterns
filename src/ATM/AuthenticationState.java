package ATM;

public class AuthenticationState implements ATMState {

    private ATMKiosk atmKiosk;

    public AuthenticationState(ATMKiosk atmKiosk){
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
        System.out.println("Card ejected");
    }

    @Override
    public void authenticateCard(int pin) {
        if(pin == atmKiosk.getCurrentUser().getPin()){
            System.out.println("Correct PIN");
            atmKiosk.displayAllOperations();
            atmKiosk.setState(new SelectOperationState(atmKiosk));
        }else{
            System.out.println("Invalid PIN");
            ejectCard();
        }
    }

    @Override
    public void selectOperation(int operationNumber) {

    }

    @Override
    public void showBalance() {

    }

    @Override
    public void withdrawMoney() {

    }

    @Override
    public void exitTxn() {

    }
}
