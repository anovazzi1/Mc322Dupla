package mc322.lab06;

public class Component {
    protected static Caverna caverna;
    protected int coordI, coordJ;


    static public void setCave(Caverna cave)
    {
        caverna = cave;
    }

    public void setCoordinates(int i, int j){
        coordI = i;
        coordJ = j;
    }
}
