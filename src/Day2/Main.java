package Day2;

import Day2.factory.PaymentFactory;
import Day2.model.PaymentType;
import Day2.strategy.PaymentProcessor;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = PaymentFactory.create(PaymentType.PAYPAL);
        processor.processPayment(100.00);
    }
}
