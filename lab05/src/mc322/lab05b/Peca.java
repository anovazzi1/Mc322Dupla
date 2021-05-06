package mc322.lab05b;

public class Peca {
    protected boolean viva;
    protected boolean cor;
    protected int i;
    protected int j;

    //cor branca é true
    //cor preta é false
    
    void setViva(boolean estado)
    {
        viva = estado;
    }
    boolean getViva()
    {
        return viva;
    }
    void setCord(int i, int j)
    {
        this.i= i;
        this.j= j;
    }
    int[] getCord()
    {
        int[] vetorCord = new int[2];
        vetorCord[0] = i;
        vetorCord[1] = j; 
        return vetorCord; 
    }
    void setCor(boolean cor)
    {
        this.cor = cor;
    }
    boolean getCor()
    {
        return cor;
    }
    boolean verificarValidade(int FimI, int FimJ)
    {
        //1 - Andar com a peça em uma posição inválida (que ultrapassa os limites do tabuleiro).
        if ((FimI > 7 || FimI < 0) && (FimJ > 7 || FimJ < 0)) {
            return false;
        }

        //2 - Andar em linha reta - cada componente do vetor posição r = [j, i] deve possuir o mesmo módulo
        int[] coordenadas = this.getCord();
        int delta_i = Math.abs(FimI - coordenadas[0]);
        int delta_j = Math.abs(FimJ - coordenadas[1]);

        return delta_i == delta_j;
    }
}
