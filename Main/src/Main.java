import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Tarefa> lista_tarefas = Tarefa.getListaTarefas();
        boolean filtro = false;

        System.out.println("Bem-vindo! Qual é o seu nome?");
        String nome_usuario = input.nextLine();

        do {
            int opcao = Utilidades.imprimirMenuPrincipal(nome_usuario, lista_tarefas, filtro, input);
            input.nextLine();

            if (opcao == 1) {
                String titulo, descricao, dataStr;
                boolean loop = true;

                while (loop) {
                    System.out.println("Informe o título da tarefa:");
                    titulo = input.nextLine();

                    if (!titulo.isEmpty()) {
                        while (loop) {
                            System.out.println("Faça uma breve descrição da tarefa:");
                            descricao = input.nextLine();

                            if (!descricao.isEmpty()) {
                                while (loop) {
                                    System.out.println("Informe a data limite (dd/MM/yyyy):");
                                    dataStr = input.nextLine();

                                    if (Utilidades.isDate(dataStr)) {
                                        LocalDate data = Utilidades.toDate(dataStr);
                                        Tarefa nova_tarefa = new Tarefa(titulo, descricao, data);

                                        if (nova_tarefa.verificarDataLimite(nova_tarefa.getData_limite())) {
                                            System.out.println("Erro! Data limite não pode ser antes da data de criação.\n");
                                        }
                                        else {
                                            nova_tarefa.cadastrarTarefa();
                                            loop = false;
                                        }
                                    }
                                    else {
                                        System.out.println("Erro! Data inválida");
                                    }
                                }
                            }
                            else {
                                System.out.println("Erro! Descrição não pode ser vazia.");
                            }
                        }
                    }
                    else {
                        System.out.println("Erro! Título não pode ser vazio");
                    }
                }
            }

            else if (opcao == 2) {
                boolean loop = true;

                while (loop) {
                    System.out.println("Digite o título da tarefa que deseja editar:");
                    String titulo = input.nextLine();

                    if (!titulo.isEmpty()) {
                        Tarefa tarefa = Tarefa.encontrarTarefa_titulo(titulo);

                        if (tarefa == null) {
                            System.out.println("Não há registro.");
                        }
                        else {
                            while (loop) {
                                int opcao_edicao;

                                System.out.println();
                                System.out.println("O que deseja editar?");
                                opcao_edicao = Utilidades.imprimirMenuSelecao(input, "modificar");
                                input.nextLine();

                                if (opcao_edicao > 0 && opcao_edicao < 5)  {
                                    tarefa.editarTarefa(opcao_edicao, input);
                                    loop = false;
                                }
                                else if (opcao_edicao == 5) {
                                    loop = false;
                                }
                                else {
                                    System.out.println("Comando inválido");
                                }
                            }
                        }
                    }
                    else {
                        System.out.println("Erro! Título não pode ser vazio");
                    }
                }
            }

            else if (opcao == 3) {
                while (true) {
                    System.out.println("Digite o título da tarefa que deseja remover:");
                    String titulo = input.nextLine();

                    if (!titulo.isEmpty()) {
                        Tarefa tarefa = Tarefa.encontrarTarefa_titulo(titulo);

                        if (tarefa == null) {
                            System.out.println("Não há registro da tarefa");
                            break;
                        }
                        else {
                            tarefa.excluirTarefa();
                            break;
                        }
                    }
                    else {
                        System.out.println("Erro! Título não pode ser vazio");
                    }
                }
            }

            else if (opcao == 4) {
                if (!filtro) {
                    while (true) {
                        int opcao_filtro;

                        System.out.println();
                        System.out.println("Selecione o critério do filtro");
                        opcao_filtro = Utilidades.imprimirMenuSelecao(input, "filtrar");
                        input.nextLine();

                        if (opcao_filtro > 0 && opcao_filtro < 6)  {
                            lista_tarefas = Tarefa.filtrarListaTarefas(opcao_filtro, input);
                            filtro = true;
                            break;
                        }
                        else if (opcao_filtro == 6) {
                            break;
                        }
                        else {
                            System.out.println("Comando inválido");
                        }
                    }
                }
                else {
                    lista_tarefas = Tarefa.getListaTarefas();
                    filtro = false;
                }
            }

            else if (opcao == 5) {
                System.out.println();
                System.out.println("Até mais!");
                input.close();
                break;
            }

            else {
                System.out.println();
                System.out.println("Comando inválido. Tente novamente");
            }
        } while (true);
    }
}
