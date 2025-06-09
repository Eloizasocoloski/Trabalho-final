import java.util.Random;
import java.util.Scanner;

public class Trabalhofinal {

    public static void main(String[] args) {
    Scanner teclado =  new Scanner(System.in);

    int[][] mapa =  new int[8][8];
    Random ran =  new Random();

    System.out.println("Digite as coordenadas para a escavação (linha e coluna, separadas por espaço)");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                mapa[i][j] = '~';
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(mapa[i][j] + " ");
            }
            System.out.println();
        }

            }
        }
    

