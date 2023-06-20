import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       final double votosValidos;
       final double votosBrancos;
       final double votosNulos;

        Scanner ler = new Scanner(System.in);

        System.out.printf("Informe o total de votos validos:\n");
        votosValidos = ler.nextDouble();

        System.out.printf("Informe o total de votos brancos:\n");
        votosBrancos = ler.nextDouble();

        System.out.printf("Informe o total de votos nulos:\n");
        votosNulos = ler.nextDouble();

        Eleicao eleicao = new Eleicao(votosValidos, votosBrancos, votosNulos);

        System.out.println("==== Resultado das eleições ======\n");

        System.out.println("Votos Válidos: " + eleicao.getPercentualVotosValidos() + "%");
        System.out.println("Votos Brancos: " + eleicao.getPercentualVotosBrancos() + "%");
        System.out.println("Votos Nulos: " + eleicao.getPercentualVotosNulos() + "%");
    }
}
