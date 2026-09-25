

// 1. Interface Protótipo
interface Prototype {
    Prototype clone();
}

// 2. Objeto Concreto Clonável
class Enemy implements Prototype {
    private String type;
    private int health;
    private String weapon;

    public Enemy(String type, int health, String weapon) {
        this.type = type;
        this.health = health;
        this.weapon = weapon;
    }

    // Construtor de cópia
    public Enemy(Enemy target) {
        if (target != null) {
            this.type = target.type;
            this.health = target.health;
            this.weapon = target.weapon;
        }
    }

    @Override
    public Prototype clone() {
        return new Enemy(this);
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void displayStatus() {
        System.out.println("Inimigo: " + type + " | Vida: " + health + " | Arma: " + weapon + " | Memory ID: " + System.identityHashCode(this));
    }
}

class PrototypeEnemyApp {
    public static void main(String[] args) {
        Enemy goblinBase = new Enemy("Goblin Recruta", 100, "Adaga de Madeira");
        System.out.println("--- Protótipo Original ---");
        goblinBase.displayStatus();

        System.out.println("\n--- Clonando Inimigos ---");
        Enemy goblin1 = (Enemy) goblinBase.clone();
        goblin1.setHealth(80);
        Enemy goblin2 = (Enemy) goblinBase.clone();
        goblin2.setHealth(50);

        goblin1.displayStatus();
        goblin2.displayStatus();
    }
}