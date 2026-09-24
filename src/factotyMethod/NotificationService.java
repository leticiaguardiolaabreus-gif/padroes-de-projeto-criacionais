package padroes_criacionais;

// 1. Interface do Produto
interface Notification {
    void send(String message);
}

// Implementações concretas
class EmailNotification implements Notification {
    @Override
    public void send(String message) {
    System.out.println("Enviando mensagem via EMAIL");
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Enviando mensagem via SMS");

    }
}

// 2. Criador Abstrato
public abstract class NotificationService {

    // Factory Method
    protected abstract Notification createNotification();

    public void notifyUser(String message) {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Mensagem não pode ser vazia");
        }
        createNotification().send(message);
    }

}

// Subclasses Criadoras
class EmailService extends NotificationService {
    @Override
    protected Notification createNotification() {
        return new EmailNotification();
    }
}

class SMSService extends NotificationService {
    @Override
    protected Notification createNotification() {
        // TODO: Retornar nova instância de SMSNotification
        return new SMSNotification();
    }
}

class NotificationServiceApp{
    public static void main(String[] args){

    NotificationService servicoemail = new EmailService();
    servicoemail.notifyUser("Bem-vindo ao sistema!");
    NotificationService servicoSMS = new SMSService();
    servicoSMS.notifyUser("Seu código de acesso é 9988.");

    }
}
