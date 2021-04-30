import java.io.IOException;

public class AppDama {
    static String[] executaJogo(String caminho) throws IOException
    {
        CSVHandling csv = new CSVHandling();

        csv.setDataSource(caminho);
        String[] jogadas = csv.requestCommands();
        Tabuleiro jogo = new Tabuleiro();
        Tabuleiro vetor = new Tabuleiro();
        jogo.imprimirTabuleiro(jogadas);
        vetor.saidaVetor(jogadas);
        
        return vetor.saidaVetor(jogadas);
    }
    public static void main(String[] args)throws IOException
    {
        String[] jogadas;
        jogadas = AppDama.executaJogo(args[0]);
        Tabuleiro jogo = new Tabuleiro();
        jogo.exportarArquivo(args[1]);
        
    }
}
