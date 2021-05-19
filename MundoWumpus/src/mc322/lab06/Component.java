package mc322.lab06;

public class Component {
   static Caverna jogo;

    static public void setCave(Caverna escolhida)
    {
        jogo = escolhida;
    }
    static  public  Caverna getCave(){return jogo;}

}
