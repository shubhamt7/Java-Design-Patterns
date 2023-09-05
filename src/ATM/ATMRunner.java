package ATM;

public class ATMRunner {
    public static void main(String[] args) {
        ATMKiosk atmKiosk = new ATMKiosk();
        atmKiosk.getState().enterCard(13);
        atmKiosk.getState().authenticateCard(1312);
        atmKiosk.getState().enterCard(13);
        atmKiosk.getState().authenticateCard(1564);
        atmKiosk.getState().selectOperation(1);
        atmKiosk.getState().selectOperation(3);
        atmKiosk.getState().enterCard(64);
        atmKiosk.getState().authenticateCard(1764);
        atmKiosk.getState().selectOperation(2);
    }
}
