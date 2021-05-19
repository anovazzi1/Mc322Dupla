package mc322.lab06;

import jdk.dynalink.beans.StaticClass;

public class Montador {
    private Caverna cave = new Caverna();
    private Component[] componentes = new Component[6];
    private String[] vetorCoord = new String[6];
    static public int buracos=0, wupus=0, ouro=0, hero=0;
    static private String caminho;
    static private String[][] coord;
    private Player heroi;

    static public Boolean VerificarCsv(String caminho)
    {
        String[][] cordenadas;
        CSVHandling local = new CSVHandling();
        local.setDataSource(caminho);
        cordenadas = local.requestCommands();
        coord = cordenadas;
        if(VerificarCsv())
        {
            return true;
        }
        else
        {
            return false;
        }

    }


     public Caverna MontarCaverna()
    {
        int j=0;
        for(int i = 0;i< coord.length;i++)
        {
            if(coord[i][1].equals("P") || coord[i][1].equals("O")||coord[i][1].equals("B")||coord[i][1].equals("W"))
            {
                switch (coord[i][1])
                {
                    case "P":
                        heroi = new Player();
                        componentes[j] = heroi;
                        vetorCoord[j] = coord[i][0];
                        j++;
                        break;
                    case "W":
                        componentes[j] = new Wumpus();
                        System.out.println(Wumpus.getCave());
                        vetorCoord[j] = coord[i][0];
                        j++;
                        break;
                    case "O":
                        componentes[j] = new Gold();
                        System.out.println(Gold.getCave());
                        vetorCoord[j] = coord[i][0];
                        j++;
                        break;
                    case "B":
                        componentes[j] = new Hole();
                        vetorCoord[j] = coord[i][0];
                        j++;
                        break;
                }
            }
        }
        cave.preencherSalas(vetorCoord, componentes);
        return cave;
    }

    static private Boolean VerificarCsv()
    {
        if(coord[0][1].equals("P")) //verificacao ta falhando não sei pq
        {
            return false;
        }
        for(int i =0;i< coord.length;i++)
        {
            switch (coord[i][1])
            {
                case "P":
                    hero++;
                    break;
                case "W":
                    wupus++;
                    break;
                case "O":
                    ouro++;
                    break;
                case "B":
                    buracos++;
                    break;
            }
        }
        if(hero !=1|| wupus!= 1 || ouro !=1|| buracos<2 || buracos >3)
        {
            return false;
        }
        return true;
    }

    public Player getPlayer() {return heroi;}
}
