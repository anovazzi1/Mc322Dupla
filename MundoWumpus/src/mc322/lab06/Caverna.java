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
        for(int i = 0;i<salas.length;i++)
        {
            for(int j=0;j< salas[0].length;j++)
            {
                separador = posicao[k].split(":");
                I = Integer.parseInt(separador[0]);
                J = Integer.parseInt(separador[1]);
                salas[I][J].setComponent(componentes[k]);
                k++;
            }
        }
    }

}
