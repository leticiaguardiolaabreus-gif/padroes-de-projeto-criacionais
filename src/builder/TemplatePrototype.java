
import java.util.ArrayList;
import java.util.List;

// 1. Interface Protótipo
interface DocumentPrototype {
    DocumentPrototype clone();
}

// 2. Objeto Concreto
class DynamicDocument implements DocumentPrototype {
    private String title;
    private String header;
    private List<String> sections;

    public DynamicDocument(String title, String header) {
        this.title = title;
        this.header = header;
        this.sections = new ArrayList<>();
    }

    public DynamicDocument(DynamicDocument target) {
        if (target != null) {
            this.title = target.title;
            this.header = target.header;
            this.sections = new ArrayList<>(target.sections);
        }
    }

    @Override
    public DocumentPrototype clone() {
        return new DynamicDocument(this);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addSection(String sectionContent) {
        this.sections.add(sectionContent);
    }

    public void printDocument() {
        System.out.println("=== " + title + " ===");
        System.out.println("Cabeçalho: " + header);
        System.out.println("Seções: " + sections);
        System.out.println("ID de Memória: " + System.identityHashCode(this));
        System.out.println("----------------------------------------");
    }
}
class PrototypeDocumentApp {
    public static void main(String[] args) {
        DynamicDocument templateContrato = new DynamicDocument("Contrato Padrão", "Empresa XYZ Ltda - CNPJ 00.000.000/0001-00");
        templateContrato.addSection("Cláusula 1: Dos Serviços");
        templateContrato.addSection("Cláusula 2: Do Pagamento");

        System.out.println("--- Template Original ---");
        templateContrato.printDocument();

        System.out.println("\n--- Gerando Contratos Clonados ---");
        DynamicDocument contratoClienteA = (DynamicDocument) templateContrato.clone();
        contratoClienteA.setTitle("Contrato - Cliente João");
        contratoClienteA.addSection("Cláusula 3: Multa por Rescisão");

        DynamicDocument contratoClienteB = (DynamicDocument) templateContrato.clone();
        contratoClienteB.setTitle("Contrato - Cliente Maria");

        contratoClienteA.printDocument();
        contratoClienteB.printDocument();
    }
}