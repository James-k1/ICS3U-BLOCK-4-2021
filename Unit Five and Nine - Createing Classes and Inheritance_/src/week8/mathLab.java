package week8;

public class mathLab {
    public static void main(String[] args) {
        int temp = 0;
        int x = 0;
        int y = 6;
        int randNum = 0;
        System.out.println("("+x+","+y+")");
        for (int i = 0; i<50; i++){
            temp=0;
            for (int j=0; j<y; j++){

                randNum = (int)(Math.random()*6)+1;

                if (randNum==1){
                    temp--;

                }
                if (randNum==6||randNum==5){
                    temp++;
                

            }


            }
            y= y+temp;
            x++;
            System.out.println("("+x+","+y+")");
            
        }

    } 
}
