package mc322.lab06;

public class Controle {
    Player jogador;

    public void setPlayer(Player hero) { jogador = hero;}

    public void setName()
    {
        jogador.setName();
    }
    public String getName()
    {
        return  jogador.getName();
    }

}
