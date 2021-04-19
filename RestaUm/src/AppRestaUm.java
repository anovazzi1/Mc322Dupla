public class AppRestaUm 
{
    String caminho;
    
    static String[] executaJogo(String caminho)
    {
        CSVReader csv = new CSVReader();
        String jogadas[];
        csv.setDataSource(caminho);
        jogadas = csv.requestCommands();
        tabuleiro vetor = new tabuleiro();
        tabuleiro console = new tabuleiro();
        String[] resposta = vetor.saida_vetor(jogadas);
        console.saida_grafica(jogadas);
        
        return resposta;
    }

    public static void main(String[] args) 
    {
        AppRestaUm.executaJogo("./src/db/arq001.csv");
    }
}
