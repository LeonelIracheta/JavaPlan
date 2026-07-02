package Day2.strategy;

public class BankTransferProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing bank transfer: " + amount);
    }
}
