package padroes_criacionais;

// 1. Interface do Produto
interface Notification {
    void send(String message);
}

// Implementações concretas
class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        // TODO: Implementar envio de Email
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        // TODO: Implementar envio de SMS
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
        // TODO: Obter o produto via Factory Method e disparar o envio
    }
}

// Subclasses Criadoras
class EmailService extends NotificationService {
    @Override
    protected Notification createNotification() {
        // TODO: Retornar nova instância de EmailNotification
        return null;
    }
}

class SMSService extends NotificationService {
    @Override
    protected Notification createNotification() {
        // TODO: Retornar nova instância de SMSNotification
        return null;
    }
}