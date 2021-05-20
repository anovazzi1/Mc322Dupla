package mc322.lab06;

import java.util.Scanner;

public class Controle {
    private Player jogador;
    private String statusJogo;
    private final Scanner keyboard = new Scanner(System.in);


    public Controle(Player player){
        setPlayer(player);
        setStatusJogo("Em andamento");
        System.out.printf("Bem-vindo %s ao mundo de Wumpus!!%n", this.jogador.getName());   //TODO: *Opcional* Escrever a apresentação do jogo e das regras para o jogador
    }

    public void setStatusJogo(String status) {
       switch (status){
           case "Jogador Saiu do Jogo":
               System.out.println("Volte Sempre!");
               break;
           case "Voce perdeu =( ...":
               System.out.println(status);
               break;
           case "Voce ganhou =D !!!":
               System.out.println(status);
               break;
           default:
       }

       statusJogo = status;
    }

    public boolean getStatusJogo() {
        return statusJogo.equals("Em andamento");
    }

    public void setPlayer(Player hero) {
        jogador = hero;
        jogador.setScore(0);
        jogador.setName();
    }

    public void setScore(int pontos){
        jogador.setScore(pontos);
    }

    public void printPlayer(){
        System.out.println("Player: " + jogador.getName());
        System.out.println("Score: " + jogador.getScore());
        System.out.printf("%nAção:%n");
    }

    public void getAction(){
        String action = keyboard.nextLine();

        switch (action){
            case "w":
//               jogador.moverCima();
                setScore(-15);
                break;
            case "s":
//                jogador.moverBaixo();
                setScore(-15);
                break;
            case "d":
//                jogador.moverDireita();
                setScore(-15);
                break;
            case "a":
//                jogador.moverEsquerda();
                setScore(-15);
                break;
            case "k":
//                jogador.equipaFlecha();
                setScore(-100);
                break;
            case "c":
//                jogador.coletaOuro();
                break;
            case "q":
                setStatusJogo("Jogador Saiu do Jogo");
                break;
            default:
                System.out.println("Ação inválida!! Tente novamente.");
                getAction();
        }
    }
}
