package ATM;

public class HundredWithdrawHandler extends WithdrawHandler{

    public HundredWithdrawHandler(WithdrawHandler nextWithdrawHandler) {
        super(nextWithdrawHandler);
    }

    @Override
    public void withdraw(ATMKiosk atmKiosk, User user, int amount) {
        if(checkBalance(atmKiosk, user, amount)){
            int requiredNotes = amount / 100;
            int balance = amount % 100;

            System.out.println("Number of 100 notes: " + Math.min(requiredNotes, atmKiosk.getHundredNotes()));

            if(requiredNotes <= atmKiosk.getHundredNotes()){
                atmKiosk.setAtmBalance(atmKiosk.getAtmBalance() - requiredNotes * 100);
                atmKiosk.setHundredNotes(atmKiosk.getHundredNotes() - requiredNotes);
                user.setBalance(user.getBalance() - requiredNotes * 100);
            }else {
                balance = balance + (requiredNotes - atmKiosk.getHundredNotes()) * 100;
                atmKiosk.setAtmBalance(atmKiosk.getAtmBalance() - atmKiosk.getHundredNotes() * 100);
                user.setBalance(user.getBalance() - atmKiosk.getHundredNotes() * 100);
                atmKiosk.setHundredNotes(0);
            }

            System.out.println("Remaining amount: " + balance);
            System.out.println("Your balance: " + user.getBalance());
            super.withdraw(atmKiosk, user, balance);
        }
    }
}
