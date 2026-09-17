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
    public void render() {
        System.out.println("Botão Dark");
    }
}

class DarkCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Checkbox Dark");
    }
}

// Implementações Light
class LightButton implements Button {
    @Override
    public void render() {
        System.out.println("Botão Light");
    }
}

class LightCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Checkbox Light");
    }
}

// Abstract Factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Fábricas Concretas
class DarkThemeFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new DarkCheckbox();
    }
}

class LightThemeFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new LightCheckbox();
    }
}
 class GUIFactoryapp {
    public static void main(String[] args){
        GUIFactory darktheme = new DarkThemeFactory();
        Button darkbotao = darktheme.createButton();
        Checkbox darkcheckbox = darktheme.createCheckbox();
        darkbotao.render();
        darkcheckbox.render();

        GUIFactory lighttheme = new LightThemeFactory();
        Button lightbotao = lighttheme.createButton();
        Checkbox lightthemeCheckbox= lighttheme.createCheckbox();
        lightbotao.render();
        lightthemeCheckbox.render();






    }
}