import java.util.ArrayList;
import java.util.List;

// 1. Produto Complexo
class SqlQuery {
    private final String query;

    private SqlQuery(SqlQueryBuilder builder) {
        StringBuilder sb = new StringBuilder();

        // Monta a cláusula SELECT
        sb.append("SELECT ").append(String.join(", ", builder.columns));

        // Monta a cláusula FROM
        sb.append(" FROM ").append(builder.table);

        // Monta a cláusula WHERE (se existir)
        if (!builder.conditions.isEmpty()) {
            sb.append(" WHERE ").append(String.join(" AND ", builder.conditions));
        }

        // Monta a cláusula LIMIT (se definida)
        if (builder.limit > 0) {
            sb.append(" LIMIT ").append(builder.limit);
        }

        this.query = sb.toString() + ";";
    }

    public void executeQuery() {
        System.out.println("Executando SQL no Banco de Dados:");
        System.out.println(this.query);
    }

    // 2. O Builder
    public static class SqlQueryBuilder {
        private String table;
        private List<String> columns = new ArrayList<>();
        private List<String> conditions = new ArrayList<>();
        private int limit = 0;

        public SqlQueryBuilder from(String table) {
            this.table = table;
            return this;
        }

        public SqlQueryBuilder select(String column) {
            this.columns.add(column);
            return this;
        }

        public SqlQueryBuilder where(String condition) {
            this.conditions.add(condition);
            return this;
        }

        public SqlQueryBuilder limit(int limit) {
            this.limit = limit;
            return this;
        }

        public SqlQuery build() {
            if (this.table == null || this.table.isBlank()) {
                throw new IllegalStateException("Impossível construir consulta SQL sem definir a tabela (FROM).");
            }
            if (this.columns.isEmpty()) {
                // Se nenhuma coluna foi informada, seleciona tudo por padrão (*)
                this.columns.add("*");
            }
            return new SqlQuery(this);

        }
    }
}
class SqlQueryApp {
    public static void main(String[] args) {
        SqlQuery query = new SqlQuery.SqlQueryBuilder()
                .from("pedidos")
                .select("id")
                .select("valor_total")
                .select("status")
                .where("status = 'PAGO'")
                .where("valor_total > 100")
                .limit(10)
                .build();
        query.executeQuery();
    }
}