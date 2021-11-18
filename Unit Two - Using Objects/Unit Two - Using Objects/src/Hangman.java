import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        boolean playAgain = true;
        Scanner in = new Scanner(System.in);
        while(playAgain){
            play("READY TO USE SURFACE CLEANER",in);
            playAgain = playAgain(in);
        }
    }

    private static boolean playAgain(Scanner in) {
        boolean validInput = false;
        while(!validInput){
            System.out.println("Do you want to play again (Y/N): ");
            String answer = in.nextLine().toUpperCase();
            if (answer.equals("Y")){
                return true;
            }
            else if (answer.equals("N")){
                return false;
            }else{
                System.out.println("Invalid Choice");
            }
        }
        return false;
    }

    private static void play(String hint, Scanner in) {
        int numPieces = 0;
        boolean gameOver = false;
        String usedLetters = "";
        String availableLetters = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";

        while(!gameOver){
            String encryptedHint = encryptHint(hint, usedLetters);
            System.out.println(encryptedHint);
            

            String Letter = getLetter(availableLetters,in);
            if (hint.indexOf(Letter)<0){
                numPieces++;
            }
            usedLetters+=Letter;
            availableLetters = availableLetters.replace(Letter, "_" );
            drawHangman(numPieces);
            if (numPieces==7){
                gameOver = true;
                System.out.println("U Lose");
            }
            if (encryptHint(hint,usedLetters).indexOf("_")==-1){
                gameOver = true;
                System.out.println("U Win");

            }


            

        }
        
    } 

    private static void drawHangman(int numPieces) {
        if (numPieces == 7) {
            System.out.println("-------");
            System.out.println("|     |");
            System.out.println("|     O");
            System.out.println("|   --|--");
            System.out.println("|     |");
            System.out.println("|    / \\");
            System.out.println("-----------");
         } else if (numPieces == 6) {
            System.out.println("-------");
            System.out.println("|     |");
            System.out.println("|     O");
            System.out.println("|   --|--");
            System.out.println("|     |");
            System.out.println("|    / ");
            System.out.println("-----------");
         } else if (numPieces == 5) {
            System.out.println("-------");
            System.out.println("|     |");
            System.out.println("|     O");
            System.out.println("|   --|--");
            System.out.println("|     |");
            System.out.println("|");
            System.out.println("-----------");
         } else if (numPieces == 4) {
            System.out.println("-------");
            System.out.println("|     |");
            System.out.println("|     O");
            System.out.println("|   --|--");
            System.out.println("|     ");
            System.out.println("|");
            System.out.println("-----------");
         } else if (numPieces == 3) {
            System.out.println("-------");
            System.out.println("|     |");
            System.out.println("|     O");
            System.out.println("|   --|");
            System.out.println("|     ");
            System.out.println("|");
            System.out.println("-----------");
         } else if (numPieces == 2) {
            System.out.println("-------");
            System.out.println("|     |");
            System.out.println("|     O");
            System.out.println("|     |");
            System.out.println("|     ");
            System.out.println("|");
            System.out.println("-----------");
         } else if (numPieces == 1) {
            System.out.println("-------");
            System.out.println("|     |");
            System.out.println("|     O");
            System.out.println("|");
            System.out.println("|     ");
            System.out.println("|");
            System.out.println("-----------");
         } else {
            System.out.println("-------");
            System.out.println("|     |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("-----------");
         }

    }

    private static String getLetter(String availableLetters, Scanner in) {
        boolean validInput = false;
        String letter = "";
        while(!validInput){
            System.out.println("Available Letters:\n" + availableLetters + "\n");
            letter = in.nextLine().toUpperCase();

            
            if (availableLetters.indexOf(letter)>=0 && letter.length()==1 && !(letter.equals("_")) && !(letter.equals(" "))){
                validInput = true;
            }else {
                System.out.println("Invalid Choice!");
            }

        }
        return letter;
    }

    private static String encryptHint(String hint, String usedLetters) {
        String result = "";
        for (int i = 0; i < hint.length(); i++){
            String s = hint.substring(i,i+1);
            if (s.equals(" ")){
                result+=" / ";
            }
            else if (usedLetters.indexOf(s)>=0){
                result+= s + " ";

            }else {
                result += " _ ";
            }
        }  
        return result;
    }
}
