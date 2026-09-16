package padroes_criacionais;

// Produto
interface Document {
    void export(String content);
}

class PDFDocument implements Document {
    @Override
    public void export(String content) {
        // TODO: Implementar lógica de exportação PDF
    }
}

class CSVDocument implements Document {
    @Override
    public void export(String content) {
        // TODO: Implementar lógica de exportação CSV
    }
}

// Criador Abstrato
public abstract class DocumentExporter {

    protected abstract Document createDocument();

    public void processReport(String data) {
        if (data == null) {
            throw new IllegalArgumentException("Dados inválidos");
        }
        // TODO: Criar o documento e exportar os dados
    }
}

class PDFExporter extends DocumentExporter {
    @Override
    protected Document createDocument() {
        // TODO: Retornar o PDFDocument
        return null;
    }
}

class CSVExporter extends DocumentExporter {
    @Override
    protected Document createDocument() {
        // TODO: Retornar o CSVDocument
        return null;
    }
}