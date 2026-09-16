package padroes_criacionais;

// Produtos Abstratos
interface Button {
    void render();
}

interface Checkbox {
    void render();
}

// Implementações Dark
class DarkButton implements Button {
    @Override
    public void render() { /* TODO */ }
}

class DarkCheckbox implements Checkbox {
    @Override
    public void render() { /* TODO */ }
}

// Implementações Light
class LightButton implements Button {
    @Override
    public void render() { /* TODO */ }
}

class LightCheckbox implements Checkbox {
    @Override
    public void render() { /* TODO */ }
}

// Abstract Factory
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Fábricas Concretas
class DarkThemeFactory implements GUIFactory {
    @Override
    public Button createButton() {
        // TODO
        return null;
    }

    @Override
    public Checkbox createCheckbox() {
        // TODO
        return null;
    }
}

class LightThemeFactory implements GUIFactory {
    @Override
    public Button createButton() {
        // TODO
        return null;
    }

    @Override
    public Checkbox createCheckbox() {
        // TODO
        return null;
    }
}