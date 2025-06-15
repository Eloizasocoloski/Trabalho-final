public class condicaoParada {
    public static void main(String[] args) {
        
            while(true){
                if(tesourosEncontrados == 8){
                    System.out.println("Você encontrou todos os tesouros!");
                    break;
                }
                if(tentativas == 25){
                    System.out.println("Você usou todas as tentativas possíveis!");
                    break;
                }
            }

            if(pontos>=70){
                System.out.println("Explorador Lendário!");
            } else if(pontos>=50){
                System.out.println("Caçador de Tesouros Experiente!");
            } else if(pontos >=30){
                System.out.println("Aventureiro Iniciante!");
            } else{
                System.out.println("Precisa de mais prática na exploração");
            }
        
        }
    }
}