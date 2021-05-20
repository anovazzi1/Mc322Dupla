package mc322.lab06;

public class Montador {
    private final Caverna cave = new Caverna();
    private final Component[] componentes = new Component[6];
    private final String[] vetorCoord = new String[6];
    static public int buracos=0, wumpus =0, ouro=0, hero=0;
    static private String[][] coord;
    private Player heroi;

    //  Funcao responsável por mapear as coordenadas do mapa do CSV e verificar a validade do mapa do jogo  //
    static public Boolean VerificarCsv(String caminho)
    {
        String[][] cordenadas;
        CSVHandling local = new CSVHandling();
        local.setDataSource(caminho);
        cordenadas = local.requestCommands();
        coord = cordenadas;
        return VerificarCsv();
    }

    // Funcao verifica a validade do mapa do jogo //
    static private Boolean VerificarCsv()
    {
        if(!coord[0][1].equals("P"))    //Wumpus não está na posição inicial
        {
            return false;
        }

        for (String[] strings : coord) {
            switch (strings[1]) {
                case "P" -> hero++;
                case "W" -> wumpus++;
                case "O" -> ouro++;
                case "B" -> buracos++;
            }
        }
        return hero == 1 && wumpus == 1 && ouro == 1 && buracos >= 2 && buracos <= 3;   //Verifica as condições básicas do jogo
    }

     public Caverna MontarCaverna()
    {
        int j=0;
        for (String[] strings : coord) {
            if (strings[1].equals("P") || strings[1].equals("O") || strings[1].equals("B") || strings[1].equals("W")) {
                switch (strings[1]) {
                    case "P" -> {
                        heroi = new Player();
                        componentes[j] = heroi;
                        vetorCoord[j] = strings[0];
                        j++;
                    }
                    case "W" -> {
                        componentes[j] = new Wumpus();
                        vetorCoord[j] = strings[0];
                        j++;
                    }
                    case "O" -> {
                        componentes[j] = new Gold();
                        vetorCoord[j] = strings[0];
                        j++;
                    }
                    case "B" -> {
                        componentes[j] = new Hole();
                        vetorCoord[j] = strings[0];
                        j++;
                    }
                }
            }
        }
        Component.setCave(cave);
        cave.preencherSalas(vetorCoord, componentes);
        return cave;
    }

    public Player getPlayer() {
        return heroi;
    }
}
