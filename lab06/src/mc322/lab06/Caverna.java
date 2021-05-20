package mc322.lab06;

public class Caverna {
    private final Sala[][] salas = new Sala[4][4];
    String[] separador;

    private void criarSalas(){
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                salas[i][j] = new Sala();
            }
        }
    }

    public void preencherSalas(String[] posicao, Component[] componentes)
    {
        int I, J;
        criarSalas();

        for(int i = 0;i< posicao.length-1;i++)
        {
            separador = posicao[i].split(":");
            I = Integer.parseInt(separador[0]);
            J = Integer.parseInt(separador[1]);
            salas[I-1][J-1].setComponent(componentes[i], I-1, J-1);
            salas[I-1][J-1].alocated();

            if (componentes[i].getClass().getSimpleName().equals("Hole")){
                if (I >= 0 && I < 4) {
                    salas[I][J - 1].setComponent(new Brisa(), I, J - 1);
                    salas[I][J - 1].alocated();
                }
                if (I - 2 >= 0 && I - 2 < 4) {
                    salas[I - 2][J - 1].setComponent(new Brisa(), I - 2, J - 1);
                    salas[I - 2][J - 1].alocated();
                }

                if (J >= 0 && J < 4) {
                    salas[I - 1][J].setComponent(new Brisa(), I - 1, J);
                    salas[I - 1][J].alocated();
                }
                if (J - 2 >= 0 && J - 2 < 4) {
                    salas[I - 1][J - 2].setComponent(new Brisa(), I - 1, J - 2);
                    salas[I - 1][J - 2].alocated();
                }
            }

            if (componentes[i].getClass().getSimpleName().equals("Wumpus")){
                if (I >= 0 && I < 4) {
                    salas[I][J - 1].setComponent(new Fedor(), I, J - 1);
                    salas[I][J - 1].alocated();
                }
                if (I - 2 >= 0 && I - 2 < 4) {
                    salas[I - 2][J - 1].setComponent(new Fedor(), I - 2, J - 1);
                    salas[I - 2][J - 1].alocated();
                }

                if (J >= 0 && J < 4) {
                    salas[I - 1][J].setComponent(new Fedor(), I - 1, J);
                    salas[I - 1][J].alocated();
                }
                if (J - 2 >= 0 && J - 2 < 4) {
                    salas[I - 1][J - 2].setComponent(new Fedor(), I - 1, J - 2);
                    salas[I - 1][J - 2].alocated();
                }
            }
        }
    }

    public void printState() {
        for(int i = 0; i < salas.length; i++) {
            System.out.print((i+1)+" ");

            for(int j =0;j < salas[0].length; j++) {

                if(salas[i][j].getVisitada()) {
                    if(salas[i][j].getEmpty()) {
                        System.out.print("# ");
                    }
                    else {
                        Component encontrado = salas[i][j].getComponent();
                        if (encontrado != null) {
                            switch (encontrado.getClass().getSimpleName()) {
                                case "Wumpus" -> System.out.print("W ");
                                case "Gold" -> System.out.print("O ");
                                case "Hole" -> System.out.print("B ");
                                case "Player" -> System.out.print("P ");
                                case "Fedor" -> System.out.print("f ");
                                case "Brisa" -> System.out.print("b ");
                            }
                        }
                    }
                }
                else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println("  1 2 3 4 ");
    }

    public String mover(int coordI, int coordJ, String direcao, boolean flechaAtiva) {
        switch (direcao) {
            case "w":                   //MOVER P/ CIMA
                if (coordI - 1 >= 0) {
                    Sala salaOrigem = salas[coordI][coordJ];
                    Component player = salaOrigem.existePlayer();

                    salaOrigem.setVisitada();
                    if (!salaOrigem.getComponent().getClass().getSimpleName().equals("Gold")){
                        salaOrigem.setEmpty();
                    }

                    Component proximaSala = salas[coordI - 1][coordJ].getComponent();
                    salas[coordI - 1][coordJ].alocated();
                    salas[coordI - 1][coordJ].setComponent(player, coordI - 1, coordJ);

                    if (proximaSala != null && (proximaSala.getClass().getSimpleName().equals("Wumpus") && flechaAtiva)) return "ganhou";
                    if (proximaSala != null && (proximaSala.getClass().getSimpleName().equals("Wumpus") || proximaSala.getClass().getSimpleName().equals("Hole"))) return "perdeu";
                    return "moveu";
                }
                break;
            case "s":                   //MOVER P/ BAIXO
                if (coordI + 1 < salas.length) {
                    Sala salaOrigem = salas[coordI][coordJ];
                    Component player = salaOrigem.existePlayer();

                    salaOrigem.setVisitada();
                    if (!salaOrigem.getComponent().getClass().getSimpleName().equals("Gold") &&
                            !salaOrigem.getComponent().getClass().getSimpleName().equals("Brisa") &&
                            !salaOrigem.getComponent().getClass().getSimpleName().equals("Fedor")){
                        salaOrigem.setEmpty();
                    }

                    Component proximaSala = salas[coordI + 1][coordJ].getComponent();
                    salas[coordI + 1][coordJ].alocated();
                    salas[coordI + 1][coordJ].setComponent(player, coordI + 1, coordJ);
                    if (proximaSala != null && (proximaSala.getClass().getSimpleName().equals("Wumpus") && flechaAtiva)) return "ganhou";
                    if (proximaSala != null && (proximaSala.getClass().getSimpleName().equals("Wumpus") || proximaSala.getClass().getSimpleName().equals("Hole"))) return "perdeu";
                    return "moveu";
                }
                break;
            case "d":                   //MOVER P/ DIREITA
                if (coordJ + 1 < salas[0].length) {
                    Sala salaOrigem = salas[coordI][coordJ];
                    Component player = salaOrigem.existePlayer();

                    salaOrigem.setVisitada();
                    if (!salaOrigem.getComponent().getClass().getSimpleName().equals("Gold")){
                        salaOrigem.setEmpty();
                    }

                    Component proximaSala = salas[coordI][coordJ + 1].getComponent();
                    salas[coordI][coordJ + 1].alocated();
                    salas[coordI][coordJ + 1].setComponent(player, coordI, coordJ + 1);
                    if (proximaSala != null && (proximaSala.getClass().getSimpleName().equals("Wumpus") && flechaAtiva)) return "ganhou";
                    if (proximaSala != null && (proximaSala.getClass().getSimpleName().equals("Wumpus") || proximaSala.getClass().getSimpleName().equals("Hole"))) return "perdeu";
                    return "moveu";
                }
                break;
            case "a":                   //MOVER P/ ESQUERDA
                if (coordJ - 1 >= 0) {
                    Sala salaOrigem = salas[coordI][coordJ];
                    Component player = salaOrigem.existePlayer();

                    salaOrigem.setVisitada();
                    if (!salaOrigem.getComponent().getClass().getSimpleName().equals("Gold")){
                        salaOrigem.setEmpty();
                    }

                    Component proximaSala = salas[coordI][coordJ - 1].getComponent();
                    salas[coordI][coordJ - 1].alocated();
                    salas[coordI][coordJ - 1].setComponent(player, coordI, coordJ - 1);
                    if (proximaSala != null && (proximaSala.getClass().getSimpleName().equals("Wumpus") && flechaAtiva)) return "ganhou";
                    if (proximaSala != null && (proximaSala.getClass().getSimpleName().equals("Wumpus") || proximaSala.getClass().getSimpleName().equals("Hole"))) return "perdeu";
                    return "moveu";
                }
                break;
        }
        System.out.printf("%nMovimento Inválido%n");
        return "movimento inválido";
    }

    public boolean coletaOuro(int coordI, int coordJ) {
        Sala sala = salas[coordI][coordJ];
        Component componentNulo = null;

        if(sala.getComponent() != null){
            System.out.println("Ouro Capturado!!");
            sala.setComponent(componentNulo, coordI, coordJ);
            return true;
        }
        return false;
    }
}
