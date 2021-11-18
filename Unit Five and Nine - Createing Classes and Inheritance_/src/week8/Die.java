package week8;

public class Die {
    private int numSides;
    private int topSide;
    public Die(){
        numSides = 6;
        roll();
    }
    public Die (int numSides){
        this.numSides = numSides;
        roll();

    }
    //accessor method
    public int getTopSide(){
        return topSide;
    }
    //mutator methods
    public void roll(){
        topSide = (int)(Math.random()*numSides)+1;

    }
    public boolean equals(Object obj){
        if (obj==this){
            return true;
        }
        if (obj instanceof Die){
            return this.topSide==((Die)obj).topSide;
        }else {
            return false;
        }

    }
    public String toString(){
        return ""+topSide;
    }
}