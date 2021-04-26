public class AppDama {
    static String[] executaJogo(String caminho)
    {
        CSVReader csv = new CSVReader();
        String jogadas[];
        csv.setDataSource(caminho);
        jogadas = csv.requestCommands();
        Tabuleiro vetor = new Tabuleiro();
        Tabuleiro console = new Tabuleiro();
        String[] resposta = vetor.saidaVetor(jogadas);
        console.saidaGrafica(jogadas);
        
        return resposta;
    }
    public static void main(String[] args) 
    {
        // AppDama.executaJogo("./src/db/arq001.csv");
        Tabuleiro teste = new Tabuleiro();
        teste.imprimir_atual(null);
    }
}
