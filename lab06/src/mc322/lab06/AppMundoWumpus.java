package mc322.lab06;

public class AppMundoWumpus {
    public static void main(String[] args)
    {

        if(!Montador.VerificarCsv(args[0]))
        {
            System.out.println("ERROR: .csv file has wrong data, review it please");
        }
        else
        {
            Montador maker = new Montador();
            Caverna cave = maker.MontarCaverna();
            Controle  jogo = new Controle(maker.getPlayer());

            while (jogo.getStatusJogo()) {
                cave.printState();
                jogo.printPlayer();
                jogo.getAction();
            }
        }
    }
}
