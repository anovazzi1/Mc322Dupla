package mc322.lab06;

public class Caverna {
    private Sala[][] salas = new Sala[4][4];
    int I, J, k=0;
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
        criarSalas();
        for(int i = 0;i< posicao.length-1;i++)
        {
            separador = posicao[k].split(":");
            I = Integer.parseInt(separador[0]);
            J = Integer.parseInt(separador[1]);
            salas[I-1][J-1].setComponent(componentes[k]);
            salas[I-1][J-1].alocated();
            k++;
        }
    }

    public void printState()
    {
        for(int i = 0; i< salas.length;i++)
        {
            System.out.print((i+1)+" ");
            for(int j =0;j< salas[0].length;j++)
            {
                Component[] encontrado;
                if(salas[i][j].getVisitada())
                {
                    if(salas[i][j].getempty())
                    {
                        System.out.print("#");
                    }
                    encontrado = salas[i][j].getComponent();
                    for(int k=0;k<encontrado.length-1;k++)
                    {
                        if(encontrado[k]!= null)
                        {
                            switch (encontrado[k].getClass().getSimpleName())
                            {
                                case "Wumpus":
                                    System.out.print("W");
                                    break;
                                case "Gold":
                                    System.out.print("O");
                                    break;
                                case "Hole":
                                    System.out.print("B");
                                    break;
                                case "Player":
                                    System.out.print("P");
                                    break;
                                case "Fedor":
                                    System.out.print("f");
                                    break;
                                case "Brisa":
                                    System.out.print("b");
                                    break;
                            }
                            break;
                        }
                    }
                }
                else
                {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
        System.out.println(" 1 2 3 4 ");
    }

}
