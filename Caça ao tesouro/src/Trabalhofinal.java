import java.util.Random;
import java.util.Scanner;

public class Trabalhofinal {

    public static void main(String[] args) {
    Scanner teclado =  new Scanner(System.in);

    int[][] mapa =  new int[8][8];
    Random ran =  new Random();

    System.out.println("Digite as coordenadas para a escavação (linha e coluna, separadas por espaço)");
    for(int i=0; i< mapa.length; i++){
        for(int j=0; j< mapa[i].length; i++)
        System.out.println((i+1)+"~");
    }
    for(int i = 0; i<5; i++){
        int armadilha = (ran.nextInt(5));
    }


    }
}
