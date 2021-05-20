package mc322.lab06;

public class Arrow extends Component{
    protected int quantidade = 1;
    protected boolean equipada = false;

    public boolean equiparFlecha(){
        quantidade--;
        if (quantidade >= 0 && !equipada){
            equipada = true;
        }

        return equipada;
    }
}
