public class Dama {
    private Boolean viva;
    private Boolean cor;
    private int i;
    private int j;

    //cor true é branca
    //cor false é preta

    Boolean verificar_validade(String jogada)
    {
        return false;
    }

    void setViva(Boolean estado)
    {
        viva = estado;
    }
    Boolean getViva()
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
        int vetorCord[] = new int[2];
        vetorCord[0] = i;
        vetorCord[1] = j; 
        return vetorCord; 
    }
    void setCor(Boolean cor)
    {
        this.cor = cor;
    }
    Boolean getCor()
    {
        return cor;
    }

    Boolean verificarValidade(Dama campoD[][], Peao campoP[][], int FimI, int FimJ)
    {

        return false;
    }
}
