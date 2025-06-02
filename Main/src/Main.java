import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nome_usuario;

        System.out.println("Bem-vindo! Qual é o seu nome?");
        nome_usuario = input.next();

        do {
            int opcao = Utilidades.imprimirMenuPrincipal(nome_usuario,input);

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
                                        Classes.Tarefa nova_tarefa = new Classes.Tarefa(titulo, descricao);
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

            else if (opcao == 5) {
                System.out.println();
                System.out.println("Até mais!");
                break;
            }

            else {
                System.out.println();
                System.out.println("Comando inválido. Tente novamente");
            }
        } while (true);
    }
}
