public class tabuleiro 
{
    pecas resta_um[][] = new pecas[7][7];
    
    public tabuleiro()
    {
        for(int i=0;i<resta_um.length;i++)
        {
            for(int j =0;j<resta_um.length;j++)
            {
                pecas x = new pecas();
                x.viva = true;
                resta_um[i][j] = x;
                if(i<2 && j<2 || i<2 && j>4)
                {
                    resta_um[i][j] = null;
                }
                else if(i>4 && j<2 || i>4 && j>4)
                {
                    resta_um[i][j] = null;
                }
            }
        }
        resta_um[3][3].viva =false;
    }
    Boolean verificar_coordenada(String posicao, int parametro)
    {
        int i = ((posicao.charAt(1)-48)-7)*-1;
        int j = posicao.charAt(0) - 97;
        if(parametro ==0)
        {
            if(resta_um[i][j]!= null && resta_um[i][j].viva)
            {
                return true;
            }
        }
        else if(parametro == 1)
        {
            if(resta_um[i][j]!= null && !resta_um[i][j].viva)
            {
                return true;
            }
        }
        return false;
    }
    String localizar_comida(String[] posicoes)
    {
        String local = "";
        int a,b;
        if(posicoes[0].charAt(0) == posicoes[1].charAt(0))
        {
            a = ((posicoes[0].charAt(1)-48)-7)*-1;
            b = ((posicoes[1].charAt(1)-48)-7)*-1;
            local += posicoes[0].charAt(0);
            local = local + ((a+b)/2);
        }
        else if(posicoes[0].charAt(1) == posicoes[1].charAt(1))
        {
            a = posicoes[0].charAt(0) - 97;
            b = posicoes[1].charAt(0) - 97;
            local = local + ((a+b)/2);
            local += posicoes[0].charAt(1);
        }

        return local;

    }
    Boolean verificar_validade(String jogada)
    {
        int a,b,c,d;
        String[] posicao = jogada.split(":");
        a= posicao[0].charAt(0);
        b= posicao[1].charAt(0);
        c= posicao[0].charAt(1);
        d= posicao[1].charAt(1);
        if(a == b || c == d)
        {
            if(Math.sqrt((a-b)*(a-b))  == 2 || Math.sqrt((c-d)*(c-d)) == 2)
            {
                if(verificar_coordenada(posicao[0], 0) && verificar_coordenada(posicao[1], 1))
                {
                    if(verificar_coordenada(localizar_comida(posicao), 0))
                    return true;
                }
            }
        }
        return false;
    }
    void realizar_jogada(String jogada)
    {
        String[] posicao = jogada.split(":");
        String comida = localizar_comida(posicao);
        int i_inicio = ((posicao[0].charAt(1)-48)-7)*-1;
        int j_inicio = posicao[0].charAt(0) - 97;
        int i_fim = ((posicao[1].charAt(1)-48)-7)*-1;
        int j_fim = posicao[1].charAt(0) - 97;
        int i = ((comida.charAt(1)-48)-7)*-1;
        int j = comida.charAt(0) - 97;
        resta_um[i_inicio][j_inicio].viva = false;
        resta_um[i_fim][j_fim].viva = true;
        resta_um[i][j].viva = false;
    }
    String criar_string()
    {
        String jogo = "";
        for(int i =0;i<resta_um.length;i++)
        {
            for(int j=0;j<resta_um[0].length;i++)
            {
                if(resta_um[i][j]==null)
                {
                    jogo += " ";
                }
                else if(resta_um[i][j].viva ==true)
                {
                    jogo += "P";
                }
                else if(resta_um[i][j].viva == false)
                {
                    jogo += "-";
                } 
            }
            jogo +="\n";
        }
        return jogo;
    }
    void imprimir_atual(String acao)
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
        for(int i=0;i<resta_um.length;i++)
        {
            System.out.print(-1*(i-7)+ " ");
            for(int j=0;j<resta_um.length;j++)
            {
                if(resta_um[i][j]==null)
                {
                    System.out.print(" ");
                }
                else if(resta_um[i][j].viva ==true)
                {
                    System.out.print("P ");
                }
                else if(resta_um[i][j].viva == false)
                {
                    System.out.print("- ");
                }
            }
            System.out.println();

        }
        System.out.print("  a b c d e f g\n");
    }
    String[] saida_vetor(String[] jogadas)
    {
        String inicio = criar_string();
        String[] resposta = new String[jogadas.length];
        resposta[0] = inicio;
        for(int i = 1;i<resposta.length;i++)
        {
            if(verificar_validade(jogadas[i]))
            {
                realizar_jogada(jogadas[i]);
                resposta[i] = criar_string();
            }
            else
            {
                resposta[i] = criar_string();
            }
        }
        return resposta;
    }
    void saida_grafica(String[] jogadas)
    {
        imprimir_atual(null);
        for(int i =0; i< jogadas.length;i++)
        {
            if(verificar_validade(jogadas[i]))
            {
                realizar_jogada(jogadas[i]);
                imprimir_atual(jogadas[i]);
            }
            else
            {
                imprimir_atual(jogadas[i]);
            }
        }
    }
}
