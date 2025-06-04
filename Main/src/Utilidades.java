import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilidades {
    public static int imprimirMenuPrincipal(String nome_usuario, ArrayList<Tarefa> lista, boolean filtro, Scanner input) {
        System.out.println();

        //Inicia Menu Princial
        System.out.println("MENU PRINCIPAL");
        System.out.println("Bem vindo, " + nome_usuario + "!");
        System.out.println("Aqui está a sua lista de tarefas:\n");

        // Caso a lista esteja vazia
        if (lista.isEmpty()) {
            if (!filtro) {
                System.out.println("Não há tarefas registradas.");
            }
        }

        // Caso tenha tarefas, exibe cabeçalho
        else {
            System.out.printf("%-4s %-15s %-15s %-15s %-15s %-10s%n",
                    "Nº", "Título", "Descrição", "Data Criação", "Data Limite", "Status");
            System.out.println("-------------------------------------------------------------------------------");

            int contador = 1;
            for (Tarefa tarefa : lista) {
                //Determina o status da Tarefa
                String statusStr = tarefa.getStatus() ? "Concluído" : "Pendente";

                // Imprime os dados formatados de cada tarefa
                System.out.printf("%-4d %-15s %-15s %-15s %-15s %-10s%n",
                        contador++,
                        tarefa.getTitulo(),
                        tarefa.getDescricao(),
                        tarefa.getData_criacao().toString(),
                        tarefa.getData_limite().toString(),
                        statusStr);
            }
        }

        //Exibe Menu Principal
        System.out.println("-------------------------------------------------------------------------------\n");
        System.out.println("O que deseja fazer?");
        System.out.println("[1] Criar uma tarefa");
        System.out.println("[2] Modificar uma tarefa");
        System.out.println("[3] Excluir uma tarefa");

        //Altera a opção 4 de acordo com a filtragem
        if (!filtro) {
            System.out.println("[4] Filtrar lista");
        }
        else {
            System.out.println("[4] Limpar filtros");
        }

        System.out.println("[5] Sair do programa");
        System.out.println("======================================\n");
        System.out.println("Digite o número da opção escolhida:");

        return input.nextInt();
    }

    // Exibe o menu de seleção para edição ou filtragem de tarefa
    public static int imprimirMenuSelecao (Scanner input, String tipo) {
        System.out.println("[1] Título");
        System.out.println("[2] Descrição");

        if (tipo.equalsIgnoreCase("modificar")) {
            System.out.println("[3] Data limite");
            System.out.println("[4] Status");
            System.out.println("[5] Voltar");
        }
        else if (tipo.equalsIgnoreCase("filtrar")) {
            System.out.println("[3] Data de criação");
            System.out.println("[4] Data limite");
            System.out.println("[5] Status");
            System.out.println("[6] Voltar");
        }

        System.out.println("Digite o número da opção escolhida:");
        return input.nextInt();
    }

    // Verifica se uma string está em um formato de data válido (dd/MM/yyyy)
    public static boolean isDate(String data) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate.parse(data, formato);
            return true;
        }
        catch (DateTimeParseException e) {
            return false;
        }
    }

    public static String imprimirMenuSelecao_data(Scanner input) {
        System.out.println("[1] Dia");
        System.out.println("[2] Mês");
        System.out.println("[3] Ano");
        System.out.println("[4] Voltar");

        System.out.println("Digite o número da opção escolhida:");
        return input.nextLine();
    }

    // Menu auxiliar para seleção de status da tarefa
    public static String imprimirMenuSelecao_status(Scanner input) {
        System.out.println("[1] Concluído");
        System.out.println("[2] Pendente");
        System.out.println("[3] Voltar");

        System.out.println("Digite o número da opção escolhida:");
        return input.nextLine();
    }

    // Verifica se a string recebida é um número inteiro válido
    public static boolean isInt(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Converte uma string no formato dd/MM/yyyy para um objeto LocalDate
    public static LocalDate toDate(String data) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, formato);
    }
}
