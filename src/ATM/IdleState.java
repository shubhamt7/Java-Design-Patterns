package ATM;

public class IdleState implements ATMState{

    private ATMKiosk atmKiosk;

    public IdleState(ATMKiosk atmKiosk){
        this.atmKiosk = atmKiosk;
        System.out.println("Current State: " + this.getClass().getName());
    }

    @Override
    public void enterCard(int cardNo) {
        User user = atmKiosk.findUser(cardNo);
        if(user == null){
            System.out.println("Invalid Card");
            return;
        }
        System.out.println("Valid card, User account number: " + user.getAccNo());
        atmKiosk.setCurrentUser(user);
        atmKiosk.setState(new AuthenticationState(atmKiosk));
    }

    @Override
    public void ejectCard() {

    }

    @Override
    public void authenticateCard(int pin) {

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
