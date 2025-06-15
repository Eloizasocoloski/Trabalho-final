import java.util.Scanner;
public class interacao{
    public static void main(String[] args) {
        //início da interação com o usuário e jogador.
        Caca caca = new Caca();
        caca.executar();
    }
}
    class Caca{
     Scanner scanner =  new Scanner(System.in);


    public void executar() {
     int linha, coluna;
     int tamanhoMapa = 8;
     int pontuacao = 0;
    

     System.out.println("Bem vindo a caçada!");
     //solicitando coordenadas.

     linha = pedirCoordenada("linha", tamanhoMapa);
     coluna = pedirCoordenada("coluna", tamanhoMapa);
     //validando coordenadas.

        if(coordenadasValidas(linha, coluna, tamanhoMapa)) {
            System.out.println("Coordenadas válidas: " + linha + ", " + coluna);
     
        } else {
            System.out.println("Coordenadas inválidas. Tente novamente.");
        }
        //simulação de rodadas
        for(int rodada = 1; rodada <= 25; rodada++) {
            System.out.println("Rodada" + rodada);
            linha = pedirCoordenada("linha",tamanhoMapa);
            coluna = pedirCoordenada("coluna", tamanhoMapa);

            if(coordenadasValidas(linha, coluna, tamanhoMapa)){
                System.out.println("Coordenadas válidas : " + linha + coluna);
                int resultado = simularResultado();
                
                if(resultado ==1){
                    System.out.println("Você encontrou um tesouro!");
                    ganharPontos(10);
                }else if(resultado ==2){
                    System.out.println("Você caiu em uma armadilha!");
                    perderPontos(5);
                }else{
                    System.out.println("Nada encontrado por aqui.");
                }
                mostrarPontuacao(pontuacao);
            }

        }
        System.out.println("Pontuação final : " + pontuacao);

    }
    // metodo para pedir coordenada
    public int pedirCoordenada( String tipoCoordenada, int tamanhoMapa){
            System.out.print("Digite a " + tipoCoordenada+ " (0 a " + (tamanhoMapa - 1) + "): ");
            return scanner.nextInt();
    }
    public boolean coordenadasValidas(int linha, int coluna, int tamanhoMapa){
        return linha >=0 && linha < tamanhoMapa && coluna >=0 && coluna < tamanhoMapa;
    }
    //método sistema de pontuiação
    public void ganharPontos(int pontos){
        pontuacao += pontos;
    }
    public void perderPontos(int pontos){
        pontuacao -= pontos;
    }
    public void mostrarPontuacao(){
        System.out.println("Pontuação atual: " + pontuacao);
    }
    public int simularResultado() {
        return(int) (Math.random() * 25);
    }
}