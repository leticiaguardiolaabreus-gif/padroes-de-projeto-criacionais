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
    public void process(double amount) {
        System.out.println("processamento em Pix");
    }
}

class BrazilTax implements InvoiceTax {
    @Override
    public double calculateTax(double amount) {
       double valor = (amount*0.15);
        return  Math.round(valor);
    }
}

// Concretos EUA
class CreditCardUSAPayment implements PaymentProcessor {
    @Override
    public void process(double amount) { System.out.println("processamento em USA credit card");  }
}

class USATax implements InvoiceTax {
    @Override
    public double calculateTax(double amount) {
        double valor = (amount*0.07);
        return Math.round(valor);
    }
}

// Abstract Factory
interface FinancialFactory {
    PaymentProcessor createPaymentProcessor();
    InvoiceTax createInvoiceTax();
}

class BrazilFinancialFactory implements FinancialFactory {
    @Override
    public PaymentProcessor createPaymentProcessor() {

        return new PixPayment();
    }

    @Override
    public InvoiceTax createInvoiceTax() {

        return new BrazilTax();
    }
}

class USAFinancialFactory implements FinancialFactory {
    @Override
    public PaymentProcessor createPaymentProcessor() {

        return new CreditCardUSAPayment();
    }

    @Override
    public InvoiceTax createInvoiceTax() {

        return new USATax();
    }
}

public class FinancialFactoryApp {

    public static void main(String[] args) {
        // Testando a fábrica do Brasil
        FinancialFactory brazilFactory = new BrazilFinancialFactory();
        PaymentProcessor pix = brazilFactory.createPaymentProcessor();
        InvoiceTax brazilTax = brazilFactory.createInvoiceTax();

        pix.process(100.0);
        System.out.println("Imposto BR: " + brazilTax.calculateTax(100.0));

        // Testando a fábrica dos EUA
        FinancialFactory usaFactory = new USAFinancialFactory();
        PaymentProcessor card = usaFactory.createPaymentProcessor();
        InvoiceTax usaTax = usaFactory.createInvoiceTax();

        card.process(100.0);
        System.out.println("Imposto USA: " + usaTax.calculateTax(100.0));
    }
}