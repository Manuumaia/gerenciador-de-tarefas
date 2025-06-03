import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

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

    public static Tarefa encontrarTarefa_titulo(String titulo) {
        for (Tarefa tarefa : lista_tarefas) {
            if (tarefa.titulo.equalsIgnoreCase(titulo)) {
                return tarefa;
            }
        }

        return null;
    }

    public static Tarefa encontrarTarefa_descricao(String descricao) {
        for (Tarefa tarefa : lista_tarefas) {
            if (tarefa.descricao.equalsIgnoreCase(descricao)) {
                return tarefa;
            }
        }

        return null;
    }

    public static ArrayList<Tarefa> filtrarListaTarefas(int atributo, Scanner input) {
        ArrayList<Tarefa> lista_filtrada = new ArrayList<>();

        if (atributo == 1) {
            while (true) {
                System.out.println("Digite o título da tarefa:");
                String titulo = input.nextLine();

                if (!titulo.isEmpty()) {
                    Tarefa tarefa = encontrarTarefa_titulo(titulo);

                    if (tarefa != null) {
                        lista_filtrada.add(tarefa);
                    };

                    break;
                }
                else {
                    System.out.println("Erro! Título não pode ser vazio");
                }
            }
        }

        else if (atributo == 2) {
            while (true) {
                System.out.println("Digite a descrição da tarefa:");
                String descricao = input.nextLine();

                if (!descricao.isEmpty()) {
                    Tarefa tarefa = encontrarTarefa_descricao(descricao);

                    if (tarefa != null) {
                        lista_filtrada.add(tarefa);
                    }

                    break;
                }
                else {
                    System.out.println("Erro! Descrição não pode ser vazia");
                }
            }
        }

        if (lista_filtrada.isEmpty()) {
            System.out.println("Não há tarefas que correspondam ao filtro.\n");
            return null;
        }

        return lista_filtrada;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String novo_titulo) {
        this.titulo = novo_titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String nova_descricao) {
        this.descricao = nova_descricao;
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

    public void setStatus(boolean novo_status) {
        this.status = novo_status;
    }

    public void cadastrarTarefa() {
        if (encontrarTarefa_titulo(this.titulo) == null) {
            lista_tarefas.add(this);
        }
        else {
            System.out.println();
            System.out.println("Tarefa já cadastrada.");
        }
    }

    public void excluirTarefa() {
        lista_tarefas.remove(this);
    }

    public void editarTarefa(int atributo, Scanner input) {
        if (atributo == 1) {
            System.out.println("Digite o novo título:");
            String novo_titulo = input.nextLine();

            if (!novo_titulo.isEmpty()) {
                while (true) {
                    System.out.println("Tem certeza que deseja alterar o título desta tarefa? (s/n)");
                    String confirmacao = input.next().toLowerCase();

                    if (confirmacao.equals("s")) {
                        setTitulo(novo_titulo);
                        break;
                    }
                    else if (confirmacao.equals("n")) {
                        break;
                    }
                    else {
                        System.out.println("Comando inválido");
                        break;
                    }
                }
            }
            else {
                System.out.println("Erro! Título não pode ser vazio");
            }
        }

        else if (atributo == 2) {
            System.out.println("Digite a nova descrição:");
            String nova_descricao = input.nextLine();

            if (!nova_descricao.isEmpty()) {
                while (true) {
                    System.out.println("Tem certeza que deseja alterar a descrição desta tarefa? (s/n)");
                    String confirmacao = input.next().toLowerCase();

                    if (confirmacao.equals("s")) {
                        setDescricao(nova_descricao);
                        break;
                    }
                    else if (confirmacao.equals("n")) {
                        break;
                    }
                    else {
                        System.out.println("Comando inválido");
                        break;
                    }
                }
            }
            else {
                System.out.println("Erro! Descrição não pode ser vazia.");
            }
        }

        else if (atributo == 3) {
            System.out.println("Digite a nova data limite (dd-MM-yyyy):");
            String nova_data = input.nextLine();

            if (Utilidades.isDate(nova_data)) {
                while (true) {
                    System.out.println("Tem certeza que deseja alterar a data limite desta tarefa? (s/n)");
                    String confirmacao = input.next().toLowerCase();

                    if (confirmacao.equals("s")) {
                        setDataLimite(nova_data);
                        break;
                    }
                    else if (confirmacao.equals("n")) {
                        break;
                    }
                    else {
                        System.out.println("Comando inválido");
                        break;
                    }
                }
            }
            else {
                System.out.println("Erro! Data inválida");
            }
        }

        else if (atributo == 4) {
            while (true) {
                System.out.println("Tem certeza que deseja alterar o status desta tarefa? (s/n)");
                String confirmacao = input.next().toLowerCase();

                if (confirmacao.equals("s")) {
                    if (this.status == false) {
                        setStatus(true);
                        break;
                    }
                    else {
                        setStatus(false);
                        break;
                    }
                }
                else if (confirmacao.equals("n")) {
                    break;
                }
                else {
                    System.out.println("Comando inválido");
                    break;
                }
            }
        }
    }
}
