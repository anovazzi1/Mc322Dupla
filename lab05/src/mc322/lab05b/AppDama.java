package mc322.lab05b;
import java.io.IOException;

public class AppDama {
    static String[] executaJogo(String caminho) {
        CSVHandling csv = new CSVHandling();
        Tabuleiro jogo = new Tabuleiro();
        Tabuleiro vetor = new Tabuleiro();

        csv.setDataSource(caminho);
        String[] jogadas = csv.requestCommands();
        jogo.imprimirTabuleiro(jogadas);
        
        return vetor.saidaVetor(jogadas);
    }
    public static void main(String[] args)  throws IOException
    {
        String[] jogadas = AppDama.executaJogo(args[0]);
        Tabuleiro jogo = new Tabuleiro();
        jogo.exportarArquivo(args[1]);
    }
}
