package mc322.lab05b;

public class Peao extends Peca {

    boolean verificarValidade(int FimI, int FimJ)
    {
        //2 - Andar mais casas além do que é permitido para a peça - p/ o peão, no máximo duas casas em caso de captura
        if(super.verificarValidade(FimI, FimJ)){
            int[] coordenadas = this.getCord();
            int delta_i = Math.abs(FimI - coordenadas[0]);
            int delta_j = Math.abs(FimJ - coordenadas[1]);

            if (delta_j > 2 && delta_i > 2) {
                return false;
            }
        }
        return true;
    }

}
