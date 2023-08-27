package VendingMachineLLD;

import java.util.Locale;
import java.util.Scanner;

public class VendingMachineMain {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        Scanner sc = new Scanner(System.in);
        String choice;
        while (true) {
            System.out.println("Welcome to SuperVend machine");
            System.out.println("Please enter Y/N: ");
            choice = sc.nextLine().toUpperCase(Locale.ROOT);
            if(choice.equals("N")){
                System.out.println("Thanks for using SuperVend!\n\n");
                break;
            }
            machine.getState().displayAllProducts();
            System.out.println("Please select a product ID: >> ");
            int productId = sc.nextInt();
            machine.getState().selectProduct(productId);
            machine.getState().continueToPayment();
            machine.getState().insertMoney(machine.getSelectedProduct().getPrice());
            machine.getState().dispenseProduct();
            System.out.println("\n\n");
        }
    }
}
