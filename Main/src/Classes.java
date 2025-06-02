import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Classes {
    public class Tarefa {
        private static ArrayList<Tarefa> lista_tarefas = new ArrayList<>();

        private String titulo;
        private String descricao;
        private LocalDate data_criacao;
        private LocalDate data_limite;
        private boolean status;

        public Tarefa(String titulo, String descricao) {
            this.titulo = titulo;
            this.descricao = descricao;
            this.data_criacao = LocalDate.now();
            this.status = false;
        }

        public static ArrayList<Tarefa> getListaTarefas() {
            return lista_tarefas;
        }

        public String getTitulo() {
            return this.titulo;
        }

        public String getDescricao() {
            return this.descricao;
        }

        public LocalDate getData_criacao() {
            return this.data_criacao;
        }

        public LocalDate getData_limite() {
            return this.data_limite;
        }

        public void setDataLimite(String data_limite) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            this.data_limite = LocalDate.parse(data_limite, formato);
        }

        public boolean getStatus() {
            return this.status;
        }

        public void cadastrarTarefa() {
            lista_tarefas.add(this);
        }
    }
}
