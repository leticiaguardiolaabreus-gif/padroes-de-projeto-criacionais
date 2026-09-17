package padroes_criacionais;

public enum DatabaseConnectionPool {

    INSTANCE;
    private int activeConnections = 0;
    private final int MAX_CONNECTIONS = 10;

    public synchronized void connect() {
        if (activeConnections >= MAX_CONNECTIONS){
            System.out.println("ERRO: onexões máximas atingidas");

        }
        activeConnections++;
        System.out.printf("Nova conexão estabelecida! Conexões ativas: %d%n", activeConnections);

    }

    public synchronized void disconnect() {
        if (activeConnections <= 0){
            System.out.println("Aviso: Nenhuma conexão ativa para encerrar");
        }
        activeConnections--;
        System.out.printf("Conexão encerrada! Conexões ativas restantes: %d%n", activeConnections);
    }

    public int getActiveConnections() {
        return activeConnections;
    }
}
class DatabaseConectionPoolApp{
    public static void main(String[] args){
        DatabaseConnectionPool pool1 = DatabaseConnectionPool.INSTANCE;
        DatabaseConnectionPool pool2 = DatabaseConnectionPool.INSTANCE;

        pool1.connect();
        pool1.connect();

        pool2.disconnect();

        System.out.println("Mesma instância? " + (pool1 == pool2));
    }
}