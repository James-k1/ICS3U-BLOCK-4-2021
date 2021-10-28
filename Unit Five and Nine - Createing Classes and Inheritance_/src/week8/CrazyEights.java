package week8;


import java.util.Scanner;

public class CrazyEights {
    private static final int NUM_SUITS = 4;
    private static final String HEARTS = "H";
    private static final String DIAMONDS = "D";
    private static final String CLUBS = "C";
    private static final String SPADES = "S";
    private static final double CARDS_PER_SUIT = 13;
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";
    private static final int CARDS_PER_PLAYER = 5;
   private static final int MIN_ASCII_VALUE = 50;
   private static final int MAX_ASCII_VALUE = 57;
    
    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int minValue = 0;
      
       //System.out.println(processPlayer(in,"2S 7H QS 9D KD 6D 6S JH 8H JC","10C"));
       //processComputer("2S 8C 3S 10C 10C", "10S", "4C AS", "5C 9D 8S");
       //processComputer("3S 2S AD 7D 2D 7C KS AC 2D 6S", "5D", "4C AS", "5C 9D 8S");

      int c1Points = 0, c2Points = 0, playerPoints = 0;
      while(!gameOver(playerPoints,c2Points,c1Points)){
         String result = playRound(in,playerPoints,c1Points,c2Points);
         playerPoints += Integer.parseInt(result.substring(0, result.indexOf("-")));
         c1Points+=Integer.parseInt(result.substring(result.indexOf("-")+1,result.lastIndexOf("-")));
         c2Points+=Integer.parseInt(result.substring(result.lastIndexOf("-")+1));
         System.out.println("Player points: " + playerPoints + " Computer 1 points: " + c1Points + " Computer 2 points: " + c2Points);
         
      }
      minValue = Math.min(playerPoints, Math.min(c1Points, c2Points));
      if (playerPoints==minValue){
         if (playerPoints==c1Points){
            System.out.println("Player and Computer 1 Tie.");
         } else if (playerPoints==c2Points){
            System.out.println("Player and Computer 2 Tie.");
         } else{
            System.out.println("Player Wins!");
         }
      } else if (c1Points==minValue){
         if (c1Points==c2Points){
            System.out.println("Computer 1 and Computer 2 Tie.");
         } else{
            System.out.println("Computer 1 Wins!");
         }
      } else{
         System.out.println("Computer 2 Wins!");
      } 
        
        
    }
    private static String playRound(Scanner in, int playerPoints, int c1Points, int c2Points) {
       String playerHand = "";
       String c1Hand = "";
       String c2Hand = "";
       for (int i = 0; i <CARDS_PER_PLAYER; i++){ 
         playerHand += getCard()+" ";
         c1Hand += getCard()+" ";
         c2Hand += getCard()+" ";
     }
     playerHand = playerHand.trim();
     c1Hand = c1Hand.trim();
     c2Hand = c2Hand.trim();
   
       String topCard = getCard();
       String temp = "";
      
      while (playerHand.length()!=0 && c1Hand.length() != 0 && c2Hand.length() != 0){
       temp = processPlayer(in, playerHand, topCard);
       playerHand = temp.substring(0,temp.indexOf("-"));
       topCard = temp.substring(temp.indexOf("-")+1);

       temp = processComputer(c1Hand, topCard, playerHand, c2Hand);
       c1Hand = temp.substring(0,temp.indexOf("-"));
       topCard = temp.substring(temp.indexOf("-")+1);
       System.out.print("Computer 1 hand : " );
      
       drawCards(c1Hand);
       System.out.println();
       
       temp = processComputer(c2Hand, topCard ,playerHand, c1Hand);
       c2Hand = temp.substring(0,temp.indexOf("-"));
       topCard = temp.substring(temp.indexOf("-")+1);
       System.out.print("Computer 2 hand : " );
       drawCards(c2Hand);
       System.out.println();
       System.out.println();




      }
      System.out.println("ROUND OVER");

       return calculatePoints(playerHand) + "-" + calculatePoints(c1Hand) + "-" + calculatePoints(c2Hand);                             
   }
   
   private static void drawCards(String hand) {
      if (hand.trim().length()==0){
         return;
      }
      hand = hand.trim()+ " ";
      while (hand.length()>0){
         System.out.print("XX ");
         hand = hand.substring(hand.indexOf(" ")+1);
      }
   }
   private static int calculatePoints(String hand) {
      int index = 0;
      int points = 0;
      String card = "";
      hand = hand.trim()+ " ";
      while (hand.trim().length()!=0){
         card = hand.substring(index, hand.indexOf(" "));
         if (!(card.substring(0,2).equals("8")) && (int) card.charAt(0)<=MAX_ASCII_VALUE && (int) card.charAt(0) >= MIN_ASCII_VALUE){
            points+= Integer.parseInt(card.substring(0, card.length()-1));
         } else if (card.substring(0, card.length()-1).equals("A")){
            points+=1;
         } else if (card.substring(0, card.length()-1).equals("10")||card.substring(0, card.length()-1).equals("J")||card.substring(0, card.length()-1).equals("Q")||card.substring(0, card.length()-1).equals("K")){
            points+=10;
         } else if (card.substring(0, card.length()-1).equals("8")){
            points+=50;
         } else{
            System.out.println("IF THIS MESSAGE PRINTS THERE IS A PROBLEM WITH CALCULATING POINTS");
         }
         if (hand.trim().indexOf(" ")==-1){
            return points;
         }
         hand=hand.substring(hand.indexOf(" ")+1);

      }
      //cHand.indexOf(topCard.substring(0,topCard.length()-1),index)!=-1
      


      return 0;
   }
   private static String processComputer(String cHand, String topCard, String opp1Hand, String opp2Hand) {
      cHand = validHand(cHand.trim(),topCard) + " ";

      int index = 0;
      String card = "";
      String suit = "";
      //checks is there are any valid cards
      if (cHand.indexOf(topCard.substring(0,topCard.length()-1))!=-1 || cHand.indexOf(topCard.substring(topCard.length()-1))!=-1 || cHand.indexOf("8")!=-1){
         //checks is the opponents have 1 card
         if (opp1Hand.indexOf(" ")==-1 || opp2Hand.indexOf(" ")==-1){
            // find if we can change the suit via the same ranked card
            while (cHand.indexOf(topCard.substring(0,topCard.length()-1),index)!=-1){
               index = cHand.indexOf(topCard.substring(0,topCard.length()-1),index);
               card = cHand.substring(index, cHand.indexOf(" ", index));
               if (!(card.substring(card.length()-1).equals(topCard.substring(topCard.length()-1)))){
                  return cHand.replaceFirst(card + " ", "").trim() + "-" + card;
               }

               index++;
               //finds if we can change the suit via and 8
            } if (cHand.indexOf("8")!=-1){
               suit = getHighSuit(cHand,topCard.substring(topCard.length()));

               return cHand.replaceFirst(cHand.substring(cHand.indexOf("8"), cHand.indexOf("8")+2), "").trim() + "-8"+suit;
               
            }
         //finds a card with the same suit 
        }if (cHand.indexOf(topCard.substring(topCard.length()-1))!=-1){
         index = 0;
         while (cHand.indexOf(topCard.substring(topCard.length()-1),index)!=-1){
            
            index = cHand.indexOf(topCard.substring(topCard.length()-1),index);
            card = cHand.substring(cHand.lastIndexOf(" ", index)+1, cHand.indexOf(" ", index));
            if (card.indexOf("8")==-1){
               
            return cHand.replaceFirst(card + " ", "").trim() + "-" + card;
            } else{
               index++;
            }
         }
            
         //finds a card with the same rank (this does not yet handel if the card is an 8)
         } if (cHand.indexOf(topCard.substring(0,topCard.length()-1))!=-1  && cHand.indexOf("8")==-1 ){
            index = 0;
            
            index = cHand.indexOf(topCard.substring(0,topCard.length()-1),index);
            card = cHand.substring(index, cHand.indexOf(" ", index));
               //if (!(card.substring(card.length()-1).equals(topCard.substring(topCard.length()-1)))){
            
            return cHand.replaceFirst(card + " ", "").trim() + "-" + card;
            

            
               //finds if we can change the suit via and 8
            //this basically has to be true
         } if (cHand.indexOf("8")!=-1){
            suit = getHighSuit(cHand, "X");
            card = cHand.substring(cHand.indexOf("8"),cHand.indexOf("8")+2);
            return cHand.replaceFirst(card + " ", "").trim() + "-8" + suit;

         } 
         System.out.println("if this message is printing there is something wrong with my code");

      }else{
         System.out.println("Computer was skipped");
         return cHand + "-" + topCard;
      }
      return ""; // change this
   }
   // private static String processPlayer(String playerHand, String topCard) {

   private static String getHighSuit(String hand, String bannedSuit){
      int H = 0;
      int D = 0;
      int C = 0;
      int S = 0;
      int maxNum = 0;

      for (int i = 0; i<hand.length(); i++){
         if (hand.substring(i, i+1).equals("H")&&!hand.substring(i-1,i).equals("8") && !("H".equals(bannedSuit))){
            H++;
         }else if (hand.substring(i, i+1).equals("D")&&!hand.substring(i-1,i).equals("8") && !("D".equals(bannedSuit))){
            D++;
         }else if (hand.substring(i, i+1).equals("S")&&!hand.substring(i-1,i).equals("8") && !("S".equals(bannedSuit))){
            S++;
         }else if (hand.substring(i,i+1).equals("C")&&!hand.substring(i-1,i).equals("8") && !("C".equals(bannedSuit))){
            C++;
         }

      } 
      maxNum = Math.max(Math.max(H, C), Math.max(D, S));
      if (H==maxNum){
         return "H";
      } else if (D==maxNum){
         return "D";
      }else if (C==maxNum){
         return "C";
      }else if (S==maxNum){
         return "S";
      }

      return null;
   }
   //    return "3D HS-5D";
   // }
   private static boolean gameOver(int playerPoints, int c2Points, int c1Points) {
      return playerPoints >= 100 || c1Points >= 100 | c2Points >= 100;
   }

    private static String getCard() {
        String card = getFace() + getSuit();
        
        return card;
     }
  
     private static String getSuit() {
        int suit = (int) (Math.random() * NUM_SUITS);
  
        if (suit == 0)
           return HEARTS;
        else if (suit == 1)
           return DIAMONDS;
        else if (suit == 2)
           return CLUBS;
        else
           return SPADES;
  
     }
  
     private static String getFace() {
        int suit = (int) (Math.random() * CARDS_PER_SUIT);
        if (suit >= 2 && suit <= 10)
           return suit + "";
        else if (suit == 1)
           return ACE;
        else if (suit == 11)
           return JACK;
        else if (suit == 12)
           return QUEEN;
        else
           return KING;
  
     }
  
    


private static String processPlayer(Scanner in, String playerHand, String topCard) {
   boolean validInput = false;
   String suit = "";
   String card = "";
   String temp = "";
   playerHand = validHand(playerHand,topCard);
   
   if (playerHand.indexOf(topCard.substring(0,topCard.length()-1))!=-1 || playerHand.indexOf(topCard.substring(topCard.length()-1))!=-1 || playerHand.indexOf("8")!=-1){
   

   while (!validInput){
      
      
      System.out.println("Cards: " + playerHand);
      System.out.println("Top card is: " + topCard);
      System.out.print("Pick a card:");
      
      card = in.nextLine().toUpperCase();
      System.out.println();
      if (playerHand.indexOf(card) > -1 && card.indexOf(" ")==-1 && cardValid(card,topCard)){
         validInput = true;
         if (card.indexOf("8")!=-1){
            suit = promptSuit(in);
            return playerHand.replaceFirst(card + " ", "").trim() + "-8" + suit;

         }
         

      } else if (!cardValid(card,topCard)){
         System.out.println();
         System.out.println("Invalid card: this card is not playable");
      }
   
   
   
      else{
         System.out.println();
         System.out.println("Invalid input:");
         
         System.out.println("Valid cards are: ");
      }


   }
} else{
   System.out.println("Your turn was skipped because you have no valid cards");
   return playerHand.trim() + "-" + topCard;
}
   temp = playerHand.replaceFirst(card, "").trim() + "-" + card;
   return temp.replace("  ", " ");


   
   }
private static String promptSuit(Scanner in) {
   boolean validInput = false;
   String suit = "";
   while(!validInput){
      System.out.print("what would you like to change the suit to:");
      suit = in.nextLine().toUpperCase();
      if (suit.equals("H")||suit.equals("C")||suit.equals("D")||suit.equals("S")){
         return suit;
      } else{
         System.out.println("Invalid input: options are H, C, D, S");
      }
   }
   return null;
}
private static boolean cardValid(String card, String topCard) {
   if (card.substring(0,card.length()-1).equals("8")){
      return true;
   }
   else if ((topCard.indexOf(card.substring(0,card.length()-1))!=-1||topCard.indexOf(card.substring(card.length()-1))!=-1)){
      return true;
   }
   return false;


   
}
private static String validHand(String playerHand, String topCard) {
   if (playerHand.length()==0){
      return "";
   }
   int addedCards = 0;
   while(playerHand.indexOf(topCard.substring(0,topCard.length()-1))==-1 && playerHand.indexOf(topCard.substring(topCard.length()-1))==-1&&playerHand.indexOf("8")==-1){
      playerHand+= " " + getCard();
      addedCards++;
      if (addedCards==5){
         return playerHand;

      } 

      
           

   }
   return playerHand + " ";
   
}

}

