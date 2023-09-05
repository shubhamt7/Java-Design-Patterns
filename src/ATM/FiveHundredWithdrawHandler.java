package ATM;

public class FiveHundredWithdrawHandler extends WithdrawHandler{

    public FiveHundredWithdrawHandler(WithdrawHandler nextWithdrawHandler) {
        super(nextWithdrawHandler);
    }

    @Override
    public void withdraw(ATMKiosk atmKiosk, User user, int amount) {
        if(checkBalance(atmKiosk, user, amount)){
            int requiredNotes = amount / 500;
            int balance = amount % 500;

            System.out.println("Number of 500 notes: " + Math.min(requiredNotes, atmKiosk.getFiveHundredNotes()));

            if(requiredNotes <= atmKiosk.getFiveHundredNotes()){
                atmKiosk.setAtmBalance(atmKiosk.getAtmBalance() - requiredNotes * 500);
                atmKiosk.setFiveHundredNotes(atmKiosk.getFiveHundredNotes() - requiredNotes);
                user.setBalance(user.getBalance() - requiredNotes * 500);
            }else {
                balance = balance + (requiredNotes - atmKiosk.getFiveHundredNotes()) * 500;
                atmKiosk.setAtmBalance(atmKiosk.getAtmBalance() - atmKiosk.getFiveHundredNotes() * 500);
                user.setBalance(user.getBalance() - atmKiosk.getFiveHundredNotes() * 500);
                atmKiosk.setFiveHundredNotes(0);
            }

            System.out.println("Remaining amount: " + balance);
            System.out.println("Your balance: " + user.getBalance());
            super.withdraw(atmKiosk, user, balance);
        }
    }
}
