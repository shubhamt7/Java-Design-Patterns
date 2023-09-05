package ATM;

public class TwokWithdrawHandler extends WithdrawHandler{

    public TwokWithdrawHandler(WithdrawHandler nextWithdrawHandler) {
        super(nextWithdrawHandler);
    }

    @Override
    public void withdraw(ATMKiosk atmKiosk, User user, int amount) {
        if(checkBalance(atmKiosk, user, amount)){
            int requiredNotes = amount / 2000;
            int balance = amount % 2000;

            System.out.println("Number of 2k notes: " + Math.min(requiredNotes, atmKiosk.getTwoKnotes()));

            if(requiredNotes <= atmKiosk.getTwoKnotes()){
                atmKiosk.setAtmBalance(atmKiosk.getAtmBalance() - requiredNotes * 2000);
                atmKiosk.setTwoKnotes(atmKiosk.getTwoKnotes() - requiredNotes);
                user.setBalance(user.getBalance() - requiredNotes * 2000);
            }else {
                balance = balance + (requiredNotes - atmKiosk.getTwoKnotes()) * 2000;
                atmKiosk.setAtmBalance(atmKiosk.getAtmBalance() - atmKiosk.getTwoKnotes() * 2000);
                user.setBalance(user.getBalance() - atmKiosk.getTwoKnotes() * 2000);
                atmKiosk.setTwoKnotes(0);
            }

            System.out.println("Remaining amount: " + balance);
            System.out.println("Your balance: " + user.getBalance());
            super.withdraw(atmKiosk, user, balance);
        }
    }
}
