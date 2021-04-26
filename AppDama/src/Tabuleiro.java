public class Tabuleiro {
    Dama campoD[][]= new Dama[8][8];
    Peao campoP[][]= new Peao[8][8];
    //cor true é branca
    //cor false é preta

    public Tabuleiro()
    {
        for(int i=0;i<campoD.length;i++)
        {
            for(int j =0;j<campoD.length;j++)
            {   Dama x = new Dama();
                campoD[i][j]= x;
                campoD[i][j].setCord(i, j);
                campoD[i][j].setViva(false);
            }
        }
        for(int i =0;i< campoP.length;i++)
        {
            for(int j=0; j<campoP.length;j++)
            {
                Peao x = new Peao();
                campoP[i][j] =x;
                campoP[i][j].setCord(i,j);
                campoP[i][j].setViva(false);
                if(((i<3 && i%2==0) && (j%2 != 0)) || ((i<3 && i%2!=0)&& (j%2 == 0)))
                {

                    campoP[i][j].setCor(false);
                    campoP[i][j].setViva(true);
                }
                if(((i>4 && i%2!=0) && (j%2 == 0)) || ((i>4 && i%2==0)&& (j%2 != 0)))
                {
                    campoP[i][j].setCor(true);
                    campoP[i][j].setViva(true);
                }
            }
            
        }
    }

    void eliminarPeca(String jogada)
    {

    }

    void realizarJogada(String jogada) //precisa remover peça ainda
    {
        {
            String[] posicao = jogada.split(":");
            int i_inicio = ((posicao[0].charAt(1)-48)-8)*-1;
            int j_inicio = posicao[0].charAt(0) - 97;
            int i_fim = ((posicao[1].charAt(1)-48)-8)*-1;
            int j_fim = posicao[1].charAt(0) - 97;
            if(campoD[i_inicio][j_inicio].getViva())
            {
                campoD[i_fim][j_fim].setCor(campoD[i_inicio][j_inicio].getCor());
                campoD[i_fim][j_fim].setViva(true);
                eliminarPeca(jogada);
                campoD[i_inicio][j_inicio].setViva(false);

            }
            else
            {
               campoP[i_fim][j_fim].setCor(campoP[i_inicio][j_inicio].getCor());
               campoP[i_fim][j_fim].setViva(true);
               campoP[i_inicio][j_inicio].setViva(false);
               if(i_fim ==0 && campoP[i_fim][j_fim].getCor()) //transforma em damas
               {
                   campoP[i_fim][j_fim].setViva(false);
                   campoD[i_fim][j_fim].setViva(true);
                   campoD[i_fim][j_fim].setCor(true);
               }
               if(i_fim ==7 && !campoP[i_fim][j_fim].getCor()) //transforma em damas
               {
                   campoP[i_fim][j_fim].setViva(false);
                   campoD[i_fim][j_fim].setViva(true);
                   campoD[i_fim][j_fim].setCor(false);
               }
            }
        }
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
        for(int i=0;i<campoP.length;i++)
        {
            System.out.print(-1*(i-8)+ " ");
            for(int j=0;j<campoP.length;j++)
            {
                if(!campoP[i][j].getViva())
                {
                    System.out.print("- ");
                }
                else if(campoP[i][j].getViva() && campoP[i][j].getCor())
                {
                    System.out.print("b ");
                }
                else if(campoP[i][j].getViva() && !campoP[i][j].getCor())
                {
                    System.out.print("p ");
                }
            }
            System.out.println();

        }
        System.out.print("  a b c d e f g h\n");
    }


    boolean converter(String posicao)
    {
        String acao[] = posicao.split(":");
        int i = ((acao[0].charAt(1)-48)-8)*-1;
        int j = acao[0].charAt(0) - 97;
        int destinoI = ((acao[1].charAt(1)-48)-8)*-1;
        int destinoJ = acao[1].charAt(0) - 97;
        if(campoD[i][j].getViva())
        {
            return campoD[i][j].verificarValidade(campoD, campoP, destinoI, destinoJ);
        }
        else if(campoP[i][j].getViva())
        {
            return campoP[i][j].verificarValidade(campoD, campoP, destinoI, destinoJ);
        }
        else
        {
            return false;
        }
        
    }

    String criarString()
    {
        String jogo = "";
        for(int i =0;i<campoP.length;i++)
        {
            for(int j=0;j<campoP[0].length;i++)
            {
                if(!campoP[i][j].getViva() && !campoD[i][j].getViva())
                {
                    jogo += "-";
                }
                if(campoP[i][j].getViva() && campoP[i][j].getCor())
                {
                    jogo += "b";
                }
                else if(campoP[i][j].getViva() && !campoP[i][j].getCor())
                {
                    jogo += "p";
                }
                if(campoD[i][j].getViva() && campoD[i][j].getCor())
                {
                    jogo += "B";
                }
                else if(campoD[i][j].getViva() && !campoD[i][j].getCor())
                {
                    jogo += "P";
                }
            }
            jogo +="\n";
        }
        return jogo;
    }

    String[] saidaVetor(String[] jogadas)
    {

        String inicio = criarString();
        String[] resposta = new String[jogadas.length];
        resposta[0] = inicio;
        for(int i = 1;i<resposta.length;i++)
        {
            if(converter(jogadas[i]))
            {
                realizarJogada(jogadas[i]);
                resposta[i] = criarString();
            }
            else
            {
                resposta[i] = criarString();
            }
        }
        return resposta;
    }

    void saidaGrafica(String[] jogadas)
    {
        imprimir_atual(null);
        for(int i =0; i< jogadas.length;i++)
        {
            if(converter(jogadas[i]))
            {
                realizarJogada(jogadas[i]);
                imprimir_atual(jogadas[i]);
            }
            else
            {
                imprimir_atual(jogadas[i]);
            }
        }
    }
}
