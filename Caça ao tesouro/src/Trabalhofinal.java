import java.util.Random;
import java.util.Scanner;

public class Trabalhofinal {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        // logica pontuacao:
        // int pontuacaoJogador = 0;
        // int bonusTesouro = 10;
        // int descontoArmadilha = -5;

        // if (achou tesouro) {
        //     pontuacaoJogador +=  bonusTesouro
        // }
        // if (achou armadilha) {
        //     pontuacaoJogador += descontoArmadilha
        // }
        char[][] mapa = new char[8][8];
        Random ran = new Random();

        System.out.println("Digite as coordenadas para a escavação (linha e coluna, separadas por espaço)");
        mapa = construirMapa(mapa);

        // for (int i = 0; i < 8; i++) {
        //     for (int j = 0; j < 8; j++) {
        //         System.out.print(mapa[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        construirTesouros(mapa);

        printarMapa(mapa);
    }

    static char[][] construirMapa(char[][] mapa) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                mapa[i][j] = '~';
            }
        }
        return mapa;
    }

    static void construirTesouros(char[][] mapa) {
        Random ran = new Random();
        int[] sortearTesouroy = new int[5];
        int[] sortearTesouroX = new int[5];
        for (int i = 0; i < 5; i++) {
            sortearTesouroX[i] = ran.nextInt(8);
            sortearTesouroy[i] = ran.nextInt(8);
            System.out.println(sortearTesouroX[i] + " - " + sortearTesouroy[i]);
        }

        int contador = 0;
        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {
                if (contador < 5) {
                    int posicaox = sortearTesouroX[i];
                    int posicaoy = sortearTesouroy[j];
                    // System.out.println(posicaox);
                    // System.out.println(posicaoy);
                    if (mapa[posicaox][posicaoy] != 't' || mapa[posicaox][posicaoy] != 'a') {
                        mapa[posicaox][posicaoy] = 't';
                    }
                }
                contador = +1;
            }
        }
    }

    static void printarMapa(char[][] mapa) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (mapa[i][j] != 't' && mapa[i][j] != 'a') {
                    // System.out.println("Tem t:" + mapa[i][j] + " ");
                    System.out.print(mapa[i][j] + " ");
                } else {
                    System.out.print("~" + " ");
                }
            }
            System.out.println();
        }
    }
}
