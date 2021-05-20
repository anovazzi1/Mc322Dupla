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
        jogador.printPlayer();
    }

    public void getAction(){
        System.out.printf("%nAção:%n");
        String action = keyboard.nextLine();

        switch (action){
            case "w":
            case "s":
            case "d":
            case "a":
                boolean flechaAtiva = false;
                if (jogador.FlechaAtiva()){
                     flechaAtiva = true;
                }
                String jogada = jogador.mover(action, flechaAtiva);

                if (!jogada.equals("movimento inválido")){
                    setScore(-15);

                    if(jogada.equals("perdeu")){
                        setScore(-1000);
                        setStatusJogo("Voce perdeu =( ...");
                    }

                    else if(jogada.equals("ganhou")){
                        setScore(500);
                        setStatusJogo("Voce ganhou =D !!!");
                    }
                }
                break;
            case "k":
                if (jogador.equipaFlecha()){
                    setScore(-100);
                }
                break;
            case "c":
                if(jogador.coletaOuro()) {
                    setScore(1000);
                }
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
