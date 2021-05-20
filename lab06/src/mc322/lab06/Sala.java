package mc322.lab06;

public class Sala {
    private Component[] components = new Component[2];
    private boolean visitada =false, empty = true;

    public void setComponent(Component atribuido, int coordI, int coordJ)
    {
        if(atribuido != null && atribuido.getClass().getSimpleName().equals("Player"))
        {
            components[0] = atribuido;
            components[0].setCoordinates(coordI, coordJ);
            visitada = true;
        }else {
            components[1] = atribuido;
            if (components[1] != null) components[1].setCoordinates(coordI, coordJ);
        }
    }

    public Component getComponent() {
        if (components[0] != null &&
                (components[1] == null ||
                    components[1].getClass().getSimpleName().equals("Brisa") ||
                        components[1].getClass().getSimpleName().equals("Fedor"))) {
                return components[0];
        }

        return components[1];
    }

    public Component existePlayer(){
        return components[0];
    }

    public void setVisitada(){
        visitada = true;
    }

    public boolean getVisitada(){
        return visitada;
    }

    public void alocated()
    {
        empty = false;
    }

    public void setEmpty(){
        components[1] = new Component();
        components[0] = new Component();
        empty = true;
    }

    public boolean getEmpty(){
        return empty;
    }
}
