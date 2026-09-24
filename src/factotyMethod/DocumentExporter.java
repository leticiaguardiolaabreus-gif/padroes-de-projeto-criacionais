package padroes_criacionais;

// Produto
interface Document {
    void export(String content);
}

class PDFDocument implements Document {
    @Override
    public void export(String content) {
        System.out.println("expotando via PDF...");
    }
}

class CSVDocument implements Document {
    @Override
    public void export(String content) {
        System.out.println("expotando via CSV...");
    }
}

// Criador Abstrato
public abstract class DocumentExporter {

    protected abstract Document createDocument();

    public void processReport(String data) {
        if (data == null) {
            throw new IllegalArgumentException("Dados inválidos");
        }
        Document documento = createDocument();
        documento.export(data);
    }
}

class PDFExporter extends DocumentExporter {
    @Override
    protected Document createDocument() {
        return new PDFDocument();
    }
}

class CSVExporter extends DocumentExporter {
    @Override
    protected Document createDocument() {
        return new CSVDocument();
    }
}


class DocumentExporterApp {
    public static void main(String[] args){

        DocumentExporter pdf = new PDFExporter();
        pdf.processReport("Relatório de Vendas - Janeiro 2026");
        DocumentExporter csv = new CSVExporter();
        csv.processReport("ID;NOME;VALOR\n1;João;100.0");
    }
}
