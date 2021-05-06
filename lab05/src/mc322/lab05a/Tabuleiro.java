package mc322.lab05a;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Tabuleiro {
    private int jogadaInvalida = 0;
    //cor branca é true
    //cor preta é false
    Peca[][] pecas = new Peca[8][8];

    public Tabuleiro()
    {
        for(int i = 0; i< pecas.length; i++)
        {
            for(int j = 0; j< pecas.length; j++)
            {
                Peca x = new Peao();
                pecas[i][j] =x;
                pecas[i][j].setCord(i,j);
                if(((i<3 && i%2==0) && (j%2 != 0)) || ((i<3 && i%2!=0)&& (j%2 == 0)))
                {

                    pecas[i][j].setCor(false);
                    pecas[i][j].setViva(true);
                }
                if(((i>4 && i%2!=0) && (j%2 == 0)) || ((i>4 && i%2==0)&& (j%2 != 0)))
                {
                    pecas[i][j].setCor(true);
                    pecas[i][j].setViva(true);
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

            Peca x = new Peao();
            pecas[i_fim][j_fim] = x;
            pecas[i_fim][j_fim].setCord(i_fim,j_fim);
            pecas[i_fim][j_fim].setCor(pecas[i_inicio][j_inicio].getCor());
            pecas[i_fim][j_fim].setViva(true);
            pecas[i_inicio][j_inicio].setViva(false);

            if((i_fim==0 && pecas[i_fim][j_fim].getCor()) || (i_fim==7 && !pecas[i_fim][j_fim].getCor()) || pecas[i_inicio][j_inicio].getClass().getSimpleName().equals("Dama")) {
                Peca nova = new Dama();
                pecas[i_fim][j_fim] = nova;
                pecas[i_fim][j_fim].setCor(pecas[i_inicio][j_inicio].getCor());
                pecas[i_fim][j_fim].setCord(i_fim, j_fim);
                pecas[i_fim][j_fim].setViva(true);
            }

            capturaPeca(i_inicio, i_fim, j_inicio, j_fim);
        }
    }

    void capturaPeca(int i_inicio, int i_fim, int j_inicio, int j_fim){
        int delta_i = i_fim-i_inicio;
        int delta_j = j_fim-j_inicio;

        if (delta_i > 0 && delta_j > 0) {   //Movimento Superior Direito
            int j = j_inicio+1;
            for (int i = i_inicio+1 ; i < i_fim; i++) {
                if (pecas[i][j].viva) {
                    pecas[i][j].viva = false; //Comer uma peca que estiver no caminho
                    return;
                }
                j++;
            }
        }
        else if (delta_i > 0 && delta_j < 0) { //Movimento Superior Esquerdo
            int j = j_inicio-1;
            for (int i = i_inicio+1 ; i < i_fim; i++) {
                if (pecas[i][j].viva) {
                    pecas[i][j].viva = false; //Comer uma peca que estiver no caminho
                    return;
                }
                j--;
            }

        }
        else if (delta_i < 0 && delta_j > 0) { //Movimento Inferior Direito
            int j = j_inicio+1;
            for (int i = i_inicio-1 ; i > i_fim; i--) {
                if (pecas[i][j].viva) {
                    pecas[i][j].viva = false; //Comer uma peca que estiver no caminho
                    return;
                }
                j++;
            }
        }
        else { //Movimento Inferior Esquerdo
            int j = j_inicio-1;
            for (int i = i_inicio-1 ; i > i_fim; i--) {
                if (pecas[i][j].viva) {
                    pecas[i][j].viva = false; //Comer uma peca que estiver no caminho
                    return;
                }
                j--;
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
        for(int i = 0; i< pecas.length; i++)
        {
            System.out.print(-1*(i-8)+ " ");
            for(int j = 0; j< pecas.length; j++)
            {
                if(!pecas[i][j].getViva())
                {
                    System.out.print("- ");
                }
                else if(pecas[i][j].getViva() && pecas[i][j].getCor())
                {
                    if (pecas[i][j].getClass().getSimpleName().equals("Dama")) {
                        System.out.print("B ");
                    }else {
                        System.out.print("b ");
                    }

                }
                else if(pecas[i][j].getViva() && !pecas[i][j].getCor())
                {
                    if (pecas[i][j].getClass().getSimpleName().equals("Dama")) {
                        System.out.print("P ");
                    }else {
                        System.out.print("p ");
                    }
                }
            }
            System.out.println();

        }
        System.out.print("  a b c d e f g h\n");
    }

    boolean solicitaMovimento(String posicao) // pede pra peca verificar o movimento
    {
        String[] acao = posicao.split(":");
        int i = ((acao[0].charAt(1)-48)-8)*-1;
        int j = acao[0].charAt(0) - 97;
        int destinoI = ((acao[1].charAt(1)-48)-8)*-1;
        int destinoJ = acao[1].charAt(0) - 97;
        if(pecas[i][j].getViva())
        {
            return pecas[i][j].verificarValidade(destinoI, destinoJ);
        }
        else
        {
            return false;
        }  
    }
    String CriarCsv() //cria string pro .csv
    {
        StringBuilder jogo = new StringBuilder();
        for(int j = 0; j< pecas.length; j++)
        {
            String coluna = ""+ (char)(j+97);
            for(int i = 0; i< pecas[0].length; i++)
            {
                int linha =(-1*(i-8));
                if(!pecas[i][j].getViva())
                {
                    jogo.append(coluna).append(linha).append("_\n");
                }
                else if(pecas[i][j].getClass().getName().equals("Peao"))
                {
                    if(pecas[i][j].getCor())
                    {
                        jogo.append(coluna).append(linha).append("b\n");
                    }
                    else
                    {
                        jogo.append(coluna).append(linha).append("p\n");
                    }
                }
                else
                {
                    if(pecas[i][j].getCor())
                    {
                        jogo.append(coluna).append(linha).append("B\n");
                    }
                    else
                    {
                        jogo.append(coluna).append(linha).append("P\n");
                    }
                }
            }
        }
        return jogo.toString();
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
        for (String jogada : jogadas) {
            if (solicitaMovimento(jogada)) {
                realizarJogada(jogada);
                imprimir_atual(jogada);
            } else {
                jogadaInvalida = 1;
                System.out.println("Movimento invalido!");
            }
        }
    }

    String criarString() //cria strings para o vetor
    {
        StringBuilder jogo = new StringBuilder();
        for(int i = 0; i< pecas.length; i++)
        {
            for(int j = 0; j< pecas[0].length; i++)
            {
                if(!pecas[i][j].getViva())
                {
                    jogo.append("-");
                }
                else
                {
                    if(pecas[i][j].getClass().getSimpleName().equals("Peao"))
                    {
                        if(pecas[i][j].getCor())
                        {
                            jogo.append("b");
                        }
                        else
                        {
                            jogo.append("p");
                        }
                    }
                    else
                    {
                        if(pecas[i][j].getCor())
                        {
                            jogo.append("B");
                        }
                        else
                        {
                            jogo.append("P");
                        }
                    }
                }
            }
            jogo.append("\n");
        }
        return jogo.toString();
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
