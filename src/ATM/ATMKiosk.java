package ATM;

import ATM.utils.CommonUtils;

import java.util.List;

public class ATMKiosk {

    private ATMState state;

    private User currentUser;

    private List<User> bankUsers;

    int atmBalance;

    int twoKnotes;

    int fiveHundredNotes;

    int hundredNotes;

    WithdrawHandler withdrawHandler;


    public ATMKiosk(){
        state = new IdleState(this);
        bankUsers = CommonUtils.getAllUsers();
        setTwoKnotes(10);
        setFiveHundredNotes(10);
        setHundredNotes(200);
        setAtmBalance(getTwoKnotes() * 2000 + getFiveHundredNotes() * 500 + getHundredNotes() * 100);
        withdrawHandler = new TwokWithdrawHandler(new FiveHundredWithdrawHandler(new HundredWithdrawHandler(null)));
    }

    public ATMState getState() {
        return state;
    }

    public void setState(ATMState state) {
        this.state = state;
    }

    public User getCurrentUser(){
        return currentUser;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public User findUser(int cardNo){
        return bankUsers.stream().filter(user -> user.getCardNo() == cardNo).findFirst().orElse(null);
    }

    public void displayAllOperations(){
        System.out.println("Please select option: ");
        System.out.println("1. Check balance");
        System.out.println("2. Withdraw money");
        System.out.println("3. Exit system");
    }

    public void withdraw(int amount){
        withdrawHandler.withdraw(this, currentUser, amount);
    }

    public int getTwoKnotes() {
        return twoKnotes;
    }

    public void setTwoKnotes(int twoKnotes) {
        this.twoKnotes = twoKnotes;
    }

    public int getFiveHundredNotes() {
        return fiveHundredNotes;
    }

    public void setFiveHundredNotes(int fiveKNotes) {
        this.fiveHundredNotes = fiveKNotes;
    }

    public int getHundredNotes() {
        return hundredNotes;
    }

    public void setHundredNotes(int hundredNotes) {
        this.hundredNotes = hundredNotes;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance) {
        this.atmBalance = atmBalance;
    }
}
