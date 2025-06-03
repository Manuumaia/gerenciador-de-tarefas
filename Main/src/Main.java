import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Bem-vindo! Qual é o seu nome?");
        String nome_usuario = input.nextLine();

        do {
            int opcao = Utilidades.imprimirMenuPrincipal(nome_usuario, input);
            input.nextLine();

            if (opcao == 1) {
                String titulo, descricao, data;
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
                                    System.out.println("Informe a data limite (dd-MM-yyyy):");
                                    data = input.nextLine();

                                    if (Utilidades.isDate(data)) {
                                        Tarefa nova_tarefa = new Tarefa(titulo, descricao);
                                        nova_tarefa.setDataLimite(data);
                                        nova_tarefa.cadastrarTarefa();
                                        loop = false;
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
                        Tarefa tarefa = Tarefa.encontrarTarefa(titulo);

                        if (tarefa == null) {
                            System.out.println("Não há registro.");
                        }
                        else {
                            while (loop) {
                                int opcao_edicao = Utilidades.imprimirMenuEdicao(input);
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
                        Tarefa tarefa = Tarefa.encontrarTarefa(titulo);

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
