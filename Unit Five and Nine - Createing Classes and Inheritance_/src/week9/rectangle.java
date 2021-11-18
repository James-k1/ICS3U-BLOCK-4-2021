package week9;

public class rectangle {
    private int length;
    private int width;
    
    public rectangle(int l, int w){
        length=l;
        width=w;

    }
    public rectangle(int l){
        length = l;
        width = l;
    }
    public int getArea(){
        return length*width;
    }
    public int getPerimeter(){
        return 2*length+2*width;
    }
    public boolean isSquare(){
        return length==width;
    }
    public String toString(){
        return "Rectangle with width of " + width + " and length of "+ length;
    }
    public boolean equals(Object obj){
        if (obj==this){
            return true;
        }
        if (obj instanceof rectangle){
            return this.length==((rectangle)obj).length &&  this.width==((rectangle)obj).width;
        }else {
            return false;
        }

    }
    public int getLength(){
        return length;
    }
    public int getWidth(){
        return width;
    }
}
