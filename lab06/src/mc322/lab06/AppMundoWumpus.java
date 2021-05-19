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
            Controle  jogador = new Controle();
            Caverna cave = maker.MontarCaverna();
            Component.setCave(cave);
            jogador.setPlayer(maker.getPlayer());
            jogador.setName();
            cave.printState();
            System.out.println("Player" + jogador.getName());
        }
    }
}
