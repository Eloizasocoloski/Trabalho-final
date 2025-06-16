import java.util.Random;
import java.util.Scanner;

public class Trabalhofinal  {
    char[][] mapa = new char[8][8];
    int pontuacao = 0;
    int tesourosEncontrados = 0;
    int tentativas = 0;
    final int maxTentativas = 25;
    final int maxTesouros = 8;
    Scanner scanner = new Scanner(System.in);
    Random ran = new Random();

    public static void main(String[] args) {
        Trabalhofinal  caca = new Trabalhofinal ();
        caca.executar();
    }

    public void executar() {
        System.out.println("Bem vindo a caçada, jogador!");
        construirMapa();
        construirTesouros();
        construirArmadilhas();

        while (tentativas < maxTentativas && tesourosEncontrados < maxTesouros) {
            System.out.println("Rodada" + (tentativas + 1));
            printarMapa();

            int[] coordenadas = pedirCoordenadas();
            int i = coordenadas[0];
            int j = coordenadas[1];

            if (coordenadasValidas(i, j)) {
                char resultado = mapa[i][j];
                if (resultado == 'T') {
                    System.out.println("Você encontrou um tesouro! +10 pontos");
                    ganharPontos(10);
                    tesourosEncontrados++;
                    mapa[i][j] = 't';

                } else if (resultado == 'A') {
                    System.out.println("Ops, você caiu em uma armadilha. -5 pontos");
                    perderPontos(5);
                    mapa[i][j] = 'a';

                } else if (resultado == 'O') {
                    System.out.println("Você já escavou aqui antes!");
                } else {
                    System.out.println("Nada de tesouros por aqui, somente areia...");
                    mapa[i][j] = 'O';
                }
                mostrarPontuacao();
            } else {
                System.out.println("Coordenadas Inválidas, tente novamente.");
            }
            tentativas++;
        }
        printarMapaCompleto();

        System.out.println("Pontuação final: " + pontuacao);
        if (tesourosEncontrados == maxTesouros) {
            System.out.println("Parabéns, você encontrou todos os tesouros!");
        } else if (tentativas == maxTentativas) {
            System.out.println("Você usou todas as tentativas possíveis. Você foi derrotado!");
        }

        if (pontuacao >= 70) {
            System.out.println("Explorador Lendário!");
        } else if (pontuacao >= 50) {
            System.out.println("Caçador de tesouros experiente!");
        } else if (pontuacao >= 30) {
            System.out.println("Aventureiro iniciante!");
        } else {
            System.out.println("Precisa de mais prática na exploração.");
        }
        scanner.close();
    }

    void construirMapa() {
        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {
                mapa[i][j] = '~';

            }
        }

    }

    void printarMapa() {
        System.out.println("Mapa atual (coordenadas): ");
        System.out.print("  ");
        for (int j = 0; j < 8; j++) {
            System.out.print(j + " ");
        }
        System.out.println();

        for (int i = 0; i < 8; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 8; j++) {
                char celula = mapa[i][j];
                if (celula == 'T' || celula == 'A') {
                    System.out.print("~ ");
               } else {
                    System.out.print(celula + " ");
                }
            }
             System.out.println();

        }
    }

    void printarMapaCompleto() {
        System.out.print("Mapa completo: ");
        System.out.println();
        for (int j = 0; j < 8; j++) {
            System.out.print(j + " ");
        }
        System.out.println();

        for (int i = 0; i < 8; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(mapa[i][j] + " ");
            }
            System.out.println();
        }


    }

    void construirArmadilhas() {
        int contador = 0;
        while (contador < 5) {
            int i = ran.nextInt(5);
            int j = ran.nextInt(5);
            if (mapa[i][j] == '~') {
                mapa[i][j] = 'A';
                contador++;
            }
        }
    }

    void construirTesouros() {
        int contador = 0;
        while (contador < maxTesouros) {
            int i = ran.nextInt(8);
            int j = ran.nextInt(8);
            if (mapa[i][j] == '~') {
                mapa[i][j] = 'T';
                contador++;
            }
        }
    }

    public int[] pedirCoordenadas() {
        System.out.print("Digite as coordenadas para escavação(linha e coluna, separados por espaço): ");
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        return new int[]{i, j};
    }

    public boolean coordenadasValidas(int i, int j) {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }

    public void ganharPontos(int pontos) {
        pontuacao += pontos;
    }

    public void perderPontos(int pontos) {
        pontuacao -= pontos;
    }

    public void mostrarPontuacao() {
        System.out.println("Pontuação atual: " + pontuacao);
    }
}