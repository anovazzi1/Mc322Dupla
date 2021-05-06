## Lab 05

Fernando dos Reis Santos Filho

Otavio Anovazzi

## Jogo de Damas

   O seu desafio aqui é escrever um conjunto de classes que simule o funcionamento de
um jogo de damas. Este jogo tomará como base o jogo Resta Um e deve seguir duas
premissas do mesmo:
    
    ● defina pelo menos uma classe cujo objeto represente o tabuleiro;
    
    ● defina uma classe para representar cada tipo de peça do tabuleiro.

   Como o jogo de damas tem dois tipos de peça - a peça comum (peão) e a dama - deve
haver uma classe para cada uma delas. A requisição de movimento será feita ao tabuleiro, que
repassa a requisição à peça. A peça verificará se o movimento é compatível com o seu tipo
(peça comum ou dama) e se o movimento é possível no tabuleiro. Para verificar se o
movimento é possível, a peça receberá do tabuleiro informações sobre o trajeto que deve
percorrer.
    Se a peça verificar que é possível, ela atualiza seu estado interno e retorna para o
tabuleiro um boolean true que valida a movimentação pelo o tabuleiro. O tabuleiro executa o
movimento, retirando a peça da origem e colocando no destino.
A verificação de captura pode ser feita pela peça ou pelo tabuleiro (você deve escolher),
mas é o tabuleiro quem executa a remoção da peça.

[Lab05 A](https://github.com/otavioanovazzi/Mc322Dupla/tree/master/lab05/src/mc322/lab05a)

[Lab05 B](https://github.com/otavioanovazzi/Mc322Dupla/tree/master/lab05/src/mc322/lab05b)
