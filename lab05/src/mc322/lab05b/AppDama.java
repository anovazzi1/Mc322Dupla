package mc322.lab05b;
import java.io.IOException;

public class AppDama {
    static String[] executaJogo(String entrada, String saida) {
        CSVHandling csv = new CSVHandling();
        Tabuleiro jogo = new Tabuleiro();
        Tabuleiro vetor = new Tabuleiro();

        csv.setDataSource(entrada);
        String[] jogadas = csv.requestCommands();
        jogo.imprimirTabuleiro(jogadas);
        jogo.exportarArquivo(saida);
        return vetor.saidaVetor(jogadas);
    }
    public static void main(String[] args)  throws IOException
    {
        String[] jogadas = AppDama.executaJogo(args[0], args[1]);
    }
}
