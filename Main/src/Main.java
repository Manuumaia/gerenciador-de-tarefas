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
                String titulo, descricao, dia, mes, ano;
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
                                    System.out.println("Informe o ano da data limite:");
                                    ano = input.next();

                                    if (Utilidades.IsInteger(ano) && Integer.parseInt(ano) > 0) {
                                        while (loop) {
                                            System.out.println("Informe o mês da data limite:");
                                            mes = input.next();

                                            if (Utilidades.IsInteger(mes) && Integer.parseInt(mes) > 0) {
                                                while (loop) {
                                                    System.out.println("Informe o dia da data limite:");
                                                    dia = input.next();

                                                    if (Utilidades.IsInteger(dia) && Integer.parseInt(dia) > 0) {
                                                        Classes.Tarefa nova_tarefa = new Classes.Tarefa(titulo, descricao);
                                                        nova_tarefa.setDataLimite(Utilidades.formatarData(dia, mes, ano));
                                                        nova_tarefa.cadastrarTarefa();
                                                        loop = false;
                                                    }
                                                    else {
                                                        System.out.println("Erro! Dia inválido.");
                                                    }
                                                }
                                            }
                                            else {
                                                System.out.println("Erro! Mês inválido.");
                                            }
                                        }
                                    }
                                    else {
                                        System.out.println("Erro! Ano inválido.");
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
