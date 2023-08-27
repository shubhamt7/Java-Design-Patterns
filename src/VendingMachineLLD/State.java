package VendingMachineLLD;

public interface State {
    void insertMoney(int amount);
    void ejectMoney();
    void selectProduct(int productId);
    void cancelTxn();
    void dispenseProduct();
    void deselectProduct();
    void displayAllProducts();
    void continueToPayment();
}
