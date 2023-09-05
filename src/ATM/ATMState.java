package ATM;

public interface ATMState {
    void enterCard(int cardNo);
    void ejectCard();
    void authenticateCard(int pin);
    void selectOperation(int operationNumber);
    void showBalance();
    void withdrawMoney();
    void exitTxn();
}
