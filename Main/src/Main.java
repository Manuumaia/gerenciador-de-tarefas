import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nome_usuario;
        int opcao;
        boolean loop = true;

        System.out.println("Bem-vindo! Qual é o seu nome?");
        nome_usuario = input.next();

        do {
            opcao = Utilidades.imprimirMenuPrincipal(nome_usuario,input);

            switch (opcao) {
                case 5:
                    System.out.println();
                    System.out.println("Até mais!");
                    loop = false;

            }
        } while (loop);
    }
}
