package padroes_criacionais;

// Produtos Abstratos
interface PaymentProcessor {
    void process(double amount);
}

interface InvoiceTax {
    double calculateTax(double amount);
}

// Concretos Brasil
class PixPayment implements PaymentProcessor {
    @Override
    public void process(double amount) { /* TODO */ }
}

class BrazilTax implements InvoiceTax {
    @Override
    public double calculateTax(double amount) {
        // TODO: Retornar imposto de 15%
        return 0.0;
    }
}

// Concretos EUA
class CreditCardUSAPayment implements PaymentProcessor {
    @Override
    public void process(double amount) { /* TODO */ }
}

class USATax implements InvoiceTax {
    @Override
    public double calculateTax(double amount) {
        // TODO: Retornar imposto de 7%
        return 0.0;
    }
}

// Abstract Factory
public interface FinancialFactory {
    PaymentProcessor createPaymentProcessor();
    InvoiceTax createInvoiceTax();
}

class BrazilFinancialFactory implements FinancialFactory {
    @Override
    public PaymentProcessor createPaymentProcessor() {
        // TODO
        return null;
    }

    @Override
    public InvoiceTax createInvoiceTax() {
        // TODO
        return null;
    }
}

class USAFinancialFactory implements FinancialFactory {
    @Override
    public PaymentProcessor createPaymentProcessor() {
        // TODO
        return null;
    }

    @Override
    public InvoiceTax createInvoiceTax() {
        // TODO
        return null;
    }
} 