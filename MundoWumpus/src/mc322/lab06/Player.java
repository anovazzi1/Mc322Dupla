package mc322.lab06;
import java.util.Scanner;

public class Player extends Component {
    private String name;
    private Scanner keyboard = new Scanner(System.in);
    public void setName()
    {
        name = keyboard.nextLine();
    }
    public String getName() {return name;}

}
