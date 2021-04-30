import java.io.*;

public class Tabuleiro {
    private int jogadaInvalida = 0;
    //cor true é branca
    //cor false é preta
    Peca campo[][] = new Peca[8][8];

    public Tabuleiro()
    {
        for(int i =0;i< campo.length;i++)
        {
            for(int j=0; j<campo.length;j++)
            {
                Peca x = new Peao();
                campo[i][j] =x;
                campo[i][j].setCord(i,j);
                campo[i][j].setViva(false);
                if(((i<3 && i%2==0) && (j%2 != 0)) || ((i<3 && i%2!=0)&& (j%2 == 0)))
                {

                    campo[i][j].setCor(false);
                    campo[i][j].setViva(true);
                }
                if(((i>4 && i%2!=0) && (j%2 == 0)) || ((i>4 && i%2==0)&& (j%2 != 0)))
                {
                    campo[i][j].setCor(true);
                    campo[i][j].setViva(true);
                }
            }
            
        }
    }
    void realizarJogada(String jogada) //precisa remover peça capturada ainda (pode ser no tabuleiro ou na peca)
    {
        {
            String[] posicao = jogada.split(":");
            int i_inicio = ((posicao[0].charAt(1)-48)-8)*-1;
            int j_inicio = posicao[0].charAt(0) - 97;
            int i_fim = ((posicao[1].charAt(1)-48)-8)*-1;
            int j_fim = posicao[1].charAt(0) - 97;

            campo[i_fim][j_fim].setCor(campo[i_inicio][j_inicio].getCor());
            campo[i_fim][j_fim].setViva(true);
            campo[i_inicio][j_inicio].setViva(false);

            if((i_fim==0 && campo[i_fim][j_fim].getCor()) || (i_fim==7 && !campo[i_fim][j_fim].getCor()))
            {
                Peca nova = new Dama();
                nova.setCor(campo[i_fim][j_fim].getCor());;
                campo[i_fim][j_fim] = nova;
                campo[i_fim][j_fim].setViva(true);
            }
        }
    }
    void imprimir_atual(String acao) //imprime no console o tabuleiro
    {
        if(acao == null)
        {
            System.out.println("Tabuleiro inicial:");
        }
        else
        {
            String[] movimento = acao.split(":");
            System.out.println("Source: "+ movimento[0]);
            System.out.println("Target: "+ movimento[1]);
        }
        for(int i=0;i<campo.length;i++)
        {
            System.out.print(-1*(i-8)+ " ");
            for(int j=0;j<campo.length;j++)
            {
                if(!campo[i][j].getViva())
                {
                    System.out.print("- ");
                }
                else if(campo[i][j].getViva() && campo[i][j].getCor())
                {
                    System.out.print("b ");
                }
                else if(campo[i][j].getViva() && !campo[i][j].getCor())
                {
                    System.out.print("p ");
                }
            }
            System.out.println();

        }
        System.out.print("  a b c d e f g h\n");
    }
    Boolean estalivre(int i, int j) //retorna se uma posicao do tabuleiro esta livre
    {
        if(campo[i][j].getViva())
        {
            return false;
        }
        else
        {
            return true;
        }   
    }
    Boolean difColor(int i, int j, Boolean color) //verifica se a peca tem cor diferente da cor passada
    {
        if( campo[i][j].getCor() == color)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    boolean solicitaMovimento(String posicao) // pede pra peca verificar o movimento
    {
        String acao[] = posicao.split(":");
        int i = ((acao[0].charAt(1)-48)-8)*-1;
        int j = acao[0].charAt(0) - 97;
        int destinoI = ((acao[1].charAt(1)-48)-8)*-1;
        int destinoJ = acao[1].charAt(0) - 97;
        if(campo[i][j].getViva())
        {
            return campo[i][j].verificarValidade(destinoI, destinoJ);
        }
        else
        {
            return false;
        }  
    }
    String CriarCsv() //cria string pro .csv
    {
        String jogo = "";
        for(int j =0;j<campo.length;j++)
        {
            String coluna = ""+ (char)(j+97);
            for(int i=0;i<campo[0].length;i++)
            {
                int linha =(-1*(i-8));
                if(!campo[i][j].getViva())
                {
                    jogo += coluna+ linha+ "_\n";
                }
                else if(campo[i][j].getClass().getName() == "Peao")
                {
                    if(campo[i][j].getCor())
                    {
                        jogo+= coluna+ linha+"b\n";
                    }
                    else
                    {
                        jogo+= coluna+ linha+"p\n";
                    }
                }
                else
                {
                    if(campo[i][j].getCor())
                    {
                        jogo+=coluna+ linha+"B\n";
                    }
                    else
                    {
                        jogo+=coluna+ linha+ "P\n";
                    }
                }
            }
        }
        return jogo;
    }
    void exportarArquivo(String caminho) throws IOException
    {
        String inicio = CriarCsv();
        FileWriter arq = new FileWriter(caminho);
        PrintWriter gravar = new PrintWriter(arq);
        if(jogadaInvalida == 0)
        {
            gravar.printf(inicio);
        }
        else
        {
            gravar.printf("erro"); 
        }
        arq.close();
    }
    void imprimirTabuleiro(String[] jogadas)
    {
        imprimir_atual(null);
        for(int i =0; i< jogadas.length;i++)
        {
            if(solicitaMovimento(jogadas[i]))
            {
                realizarJogada(jogadas[i]);
                imprimir_atual(jogadas[i]);
            }
            else
            {
                jogadaInvalida = 1;
                System.out.println("Movimento invalido!");
            }
        }
    }

    String criarString() //cria strings para o vetor
    {
        String jogo = "";
        for(int i =0;i<campo.length;i++)
        {
            for(int j=0;j<campo[0].length;i++)
            {
                if(!campo[i][j].getViva())
                {
                    jogo += "-";
                }
                else
                {
                    if(campo[i][j].getClass().getName() == "Peao")
                    {
                        if(campo[i][j].getCor())
                        {
                            jogo+= "b";
                        }
                        else
                        {
                            jogo+= "p";
                        }
                    }
                    else
                    {
                        if(campo[i][j].getCor())
                        {
                            jogo+= "B";
                        }
                        else
                        {
                            jogo+= "P";
                        }
                    }
                }
            }
            jogo +="\n";
        }
        return jogo;
    }

    String[] saidaVetor(String[] jogadas) //saida igual ao vetor do RestaUm
    {
        String inicio = criarString();
        String[] resposta = new String[jogadas.length];
        resposta[0] = inicio;
        for(int i = 1;i<resposta.length;i++)
        {
            if(solicitaMovimento(jogadas[i]))
            {
                realizarJogada(jogadas[i]);
                resposta[i] = criarString();
            }
            else
            {
                resposta[i] = "Movimento invalido!";
                jogadaInvalida = 1;
            }
        }
        return resposta;
    }
}
