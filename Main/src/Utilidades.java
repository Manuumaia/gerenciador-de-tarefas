import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilidades {
    private static boolean verificarSeVazia(ArrayList<Tarefa> lista_tarefas) {
        return lista_tarefas.isEmpty();
    }

    public static int imprimirMenuPrincipal(String nome_usuario, Scanner input) {
        System.out.println();
        System.out.println("MENU PRINCIPAL");
        System.out.println("Bem vindo, " + nome_usuario + "!");
        System.out.println("Aqui está a sua lista de tarefas:");

        if (verificarSeVazia(Tarefa.getListaTarefas())) {
            System.out.println("Não há tarefas registradas.");
        }
        else {
            System.out.printf("%-4s %-15s %-15s %-15s %-15s %-10s%n",
                    "Nº", "Título", "Descrição", "Data Criação", "Data Limite", "Status");
            System.out.println("-------------------------------------------------------------------------------");

            int contador = 1;
            for (Tarefa tarefa : Tarefa.getListaTarefas()) {
                String statusStr = tarefa.getStatus() ? "Concluído" : "Pendente";
                System.out.printf("%-4d %-15s %-15s %-15s %-15s %-10s%n",
                        contador++,
                        tarefa.getTitulo(),
                        tarefa.getDescricao(),
                        tarefa.getData_criacao().toString(),
                        tarefa.getData_limite().toString(),
                        statusStr);
            }
        }

        System.out.println("-------------------------------------------------------------------------------\n");
        System.out.println("O que deseja fazer?");
        System.out.println("[1] Criar uma tarefa");
        System.out.println("[2] Modificar uma tarefa");
        System.out.println("[3] Excluir uma tarefa");
        System.out.println("[4] Filtrar lista");
        System.out.println("[5] Sair do programa");
        System.out.println("======================================\n");
        System.out.println("Digite o número da opção escolhida:");

        return input.nextInt();
    }

    public static int imprimirMenuEdicao (Scanner input) {
        System.out.println();
        System.out.println("O que deseja editar?");
        System.out.println("[1] Título");
        System.out.println("[2] Descrição");
        System.out.println("[3] Data limite");
        System.out.println("[4] Status");
        System.out.println("[5] Voltar");

        System.out.println("Digite o número da opção escolhida:");
        return input.nextInt();
    }

    public static boolean isDate(String data) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            LocalDate.parse(data, formato);
            return true;
        }
        catch (DateTimeParseException e) {
            return false;
        }
    }
}
