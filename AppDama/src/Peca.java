public class Peca {
    protected Boolean viva;
    protected Boolean cor;
    protected int i;
    protected int j;

    //cor true é branca
    //cor false é preta

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
    Boolean verificarValidade(int FimI, int FimJ)
    {
        // somente os 3 topicos do item verificacoes do roteiro
        return false;
    }
}
