## Lab 05

Fernando dos Reis Santos Filho

Otavio Anovazzi

## O Mundo de Wumpus

``
                    for(int k=0;k<componentes.length-1;k++)
                    {
                        if(componentes[k]!= null)
                        {
                            switch (componentes[k].getClass().getSimpleName())
                            {
                                case "Wumpus":
                                    System.out.print("W");
                                    break;
                                case "Gold":
                                    System.out.print("O");
                                    break;
                                case "Hole":
                                    System.out.print("B");
                                    break;
                                case "Player":
                                    System.out.print("P");
                                    break;
                                case "Fedor":
                                    System.out.print("f");
                                    break;
                                case "Brisa":
                                    System.out.print("b");
                                    break;
                            } ``

O corte de código acima consegue resumir as principais vantagens do nosso programa. Nós optamos por criar uma classe para cada componente, criando uma Super classe Components que é herdada por cada componente. Uma das vantagens dessa abordagem pode ser vista acima. Podemos destacar a lista com nome de componentes, essa lista é uma lista da Super Classe Components, que é extendida as classes de Wumpus, Gold, Hole, Player, Fedor e Brisa. cada sala contem sua prórpia lista de classes que são herdeiras de Components, assim, usando os métodos getClass().getSimpleName(),podemos diferencias as instancias que foram declaradas como Components, esse método facilita a implementação e a manipulação de novos componentes, pois só é preciso criar uma nova classe para o componente desejado e adiciona-lo no switch para que ele funcione.
