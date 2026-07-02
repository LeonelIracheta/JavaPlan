package Day2.factory;

import Day2.model.PaymentType;
import Day2.strategy.BankTransferProcessor;
import Day2.strategy.CreditCardProcessor;
import Day2.strategy.PaymentProcessor;
import Day2.strategy.PaypalProcessor;

public class PaymentFactory {

    public static PaymentProcessor create(PaymentType type) {

        switch(type) {

            case CREDIT_CARD:
                return new CreditCardProcessor();

            case PAYPAL:
                return new PaypalProcessor();

            case BANK_TRANSFER:
                return new BankTransferProcessor();

            default:
                throw new IllegalArgumentException("Unsupported payment type");
        }
    }
}
