package padroes_criacionais;

public enum DatabaseConnectionPool {

    // TODO: Definir a instância única (ex: INSTANCE)
    ;

    private int activeConnections = 0;
    private final int MAX_CONNECTIONS = 10;

    public synchronized void connect() {
        // TODO: Validar se estourou MAX_CONNECTIONS, senão incrementar
    }

    public synchronized void disconnect() {
        // TODO: Decrementar conexões ativas se for maior que zero
    }

    public int getActiveConnections() {
        return activeConnections;
    }
}