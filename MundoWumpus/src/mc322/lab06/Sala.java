package mc322.lab06;

public class Sala {
    private Component[] components = new Component[10];
    private int head=0;
    private boolean visitada =false;

    public void setComponent(Component atribuido)
    {
        components[head] = atribuido;
        head++;
        if(atribuido.getClass().getSimpleName().equals("Player"))
        {
            visitada = true;
        }
    }
    public Component[] getComponents()
    {
        return components;
    }

    public boolean getVisitada(){ return visitada;}
}
