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

    }

}
