package ATM;

import java.sql.SQLOutput;

public abstract class WithdrawHandler {
    WithdrawHandler nextWithdrawHandler;
    ATMKiosk atmKiosk;

    public WithdrawHandler(WithdrawHandler nextWithdrawHandler){
        this.nextWithdrawHandler = nextWithdrawHandler;
    }
    public boolean checkBalance(ATMKiosk atmKiosk, User user, int amount){
        if(amount <= 0){
            System.out.println("Invalid amount");
            return false; // returning false here, so that we don't have to process it.
        }
        if(amount > atmKiosk.getAtmBalance()){
            System.out.println("Insufficient balance in ATM");
            return false;
        }else if(amount > user.getBalance()){
            System.out.println("Insufficient balance in your account");
            return false;
        }else{
            return true;
        }
    }

    public void withdraw(ATMKiosk atmKiosk, User user, int amount){
        if(amount == 0){
            atmKiosk.setState(new SelectOperationState(atmKiosk));
        }
        if(nextWithdrawHandler != null){
            nextWithdrawHandler.withdraw(atmKiosk, user, amount);
        }
    }
}
