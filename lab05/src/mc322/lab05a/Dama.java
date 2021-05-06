package mc322.lab05a;

public class Dama extends Peca {
    boolean verificarValidade(int FimI, int FimJ)
    {
        //2 - Andar mais casas além do que é permitido para a peça
        return super.verificarValidade(FimI, FimJ);
    }
}
