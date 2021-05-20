package mc322.lab06;
import java.util.Scanner;

public class Player extends Component {
    private String name;
    private int score;
    private Arrow flecha = new Arrow();
    private Gold ouro = new Gold();
    private final Scanner keyboard = new Scanner(System.in);

    public void setName() {
        System.out.print("Escreva o nome do seu jogador: ");
        name = keyboard.nextLine();
    }
    public String getName() {
        return name;
    }

    public void printPlayer(){
        System.out.println("Player: " + getName());
        System.out.println("Score: " + getScore());
    }

    public void setScore(int pontos) {
        score += pontos;
    }
    public int getScore() {
        return score;
    }

    public String mover(String direcao, boolean flechaAtiva) {
        return caverna.mover(coordI, coordJ, direcao, flechaAtiva);
    }

    public boolean coletaOuro(){
         return caverna.coletaOuro(coordI, coordJ);
    }

    public boolean equipaFlecha(){
        if( flecha.equiparFlecha()){
           System.out.println("Flecha Equipada!!");
            return true;
       }

        return false;
    }

    public boolean FlechaAtiva(){
        return flecha.equipada;
    }

    public void matarWumpus(){

    }
}
