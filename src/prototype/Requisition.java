
import java.util.HashMap;
import java.util.Map;

// 1. Produto Complexo
class HttpRequest {
    private final String url;
    private final String method;
    private final Map<String, String> headers;
    private final String body;

    private HttpRequest(HttpRequestBuilder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers;
        this.body = builder.body;
    }

    public void execute() {
        System.out.println("--- Disparando Requisição HTTP ---");
        System.out.println("Método: " + method + " | URL: " + url);
        System.out.println("Headers: " + headers);
        System.out.println("Body: " + (body != null ? body : "[Sem Corpo]"));
    }

    // 2. O Builder
    public static class HttpRequestBuilder {
        private String url;
        private String method = "GET"; // Valor padrão
        private Map<String, String> headers = new HashMap<>();
        private String body;

        public HttpRequestBuilder(String url) {
            this.url = url; // URL é obrigatória!
        }

        public HttpRequestBuilder setMethod(String method) {
            this.method = method;
            return this;
        }

        public HttpRequestBuilder addHeader(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public HttpRequestBuilder setBody(String body) {
            this.body = body;
            return this;
        }

        public HttpRequest build() {
            if (this.url == null || this.url.isBlank()) {
                throw new IllegalArgumentException("A URL da requisição não pode ser vazia.");
            }
            return new HttpRequest(this);
        }
    }
}

class HttpRequestApp {
    public static void main(String[] args) {
        HttpRequest requisicao = new HttpRequest.HttpRequestBuilder("https://api.exemplo.com/v1/usuarios")
                .setMethod("POST")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer token123")
                .setBody("{\"nome\": \"Maria\"}")
                .build();

        requisicao.execute();
    }
}