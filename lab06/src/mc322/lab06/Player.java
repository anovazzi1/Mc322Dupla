package mc322.lab06;
import java.util.Scanner;

public class Player extends Component {
    private String name;
    private int score;
    private Scanner keyboard = new Scanner(System.in);

    public void setName()
    {
        System.out.print("Escreva o nome do seu jogador: ");
        name = keyboard.nextLine();
    }
    public String getName() {
        return name;
    }

    public void setScore(int pontos) {
        score += pontos;
    }
    public int getScore() {
        return score;
    }
}
