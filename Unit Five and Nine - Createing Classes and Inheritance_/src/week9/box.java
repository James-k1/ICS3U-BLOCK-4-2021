package week9;

public class box extends rectangle{
    private int height;
    public box(int l, int w, int h){
        /** 
        length =l; these are private in the parent classs
        width = w;
        */
       super(l, w); //MUST BE THE FIRST STATEMENT OF THE CONSTRICTOR
        height = h;
        
    }
    public int getArea(){
        return 2*super.getArea()+ 2* getWidth()*height +2*getLength();


    }
    public boolean equals(Object obj){

        if(super.equals(obj)){
            if (obj instanceof box){
                return height == ((box)obj).height;
            }
        }
        return false;
        // if (obj==this){
        //     return true;
        // }
        // if (obj instanceof box){
        //     return getLength()==((box)obj).getLength() &&  this.getWidth()==((box)obj).getWidth() && ((box)obj).height==height;
        // }else {
        //     return false;
        // }

    }

}
