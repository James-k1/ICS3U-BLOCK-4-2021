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
      int c1Points = 0, c2Points = 0, playerPoints = 0;


      while(!gameOver(playerPoints,c2Points,c1Points)){ // checks if the game is over based on the player points
         String result = playRound(in,playerPoints,c1Points,c2Points); //starts a round 

         playerPoints += Integer.parseInt(result.substring(0, result.indexOf("-"))); //calculates player points
         c1Points+=Integer.parseInt(result.substring(result.indexOf("-")+1,result.lastIndexOf("-"))); //calculates computer 1's points
         c2Points+=Integer.parseInt(result.substring(result.lastIndexOf("-")+1)); //calculates computer 2's points
         System.out.println("Player points: " + playerPoints + " Computer 1 points: " + c1Points + " Computer 2 points: " + c2Points);
         
      }
      
      minValue = Math.min(playerPoints, Math.min(c1Points, c2Points)); //finds who got the least amount of points

      //states who won bases on the amount of point each player ended with
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

    /**
     * 
     * @param in
     * @param playerPoints
     * @param c1Points
     * @param c2Points
     * @return playerPoints-computerOnePoints-computerTwoPoints
     */
    
    private static String playRound(Scanner in, int playerPoints, int c1Points, int c2Points) {
       String playerHand = "";
       String c1Hand = "";
       String c2Hand = "";
       String topCard = getCard(); //sets the top card

       //distributes cards 
       for (int i = 0; i <CARDS_PER_PLAYER; i++){ 
         playerHand += getCard()+" ";
         c1Hand += getCard()+" ";
         c2Hand += getCard()+" ";
     }
     playerHand = playerHand.trim();
     c1Hand = c1Hand.trim();
     c2Hand = c2Hand.trim();
   
      // makes sure that the topCard is not an 8
      while (topCard.substring(0, topCard.length()-1).equals("8")){
         topCard = getCard();
      }

       String temp = "";
      
       
      while (playerHand.length()!=0 && c1Hand.length() != 0 && c2Hand.length() != 0){// checks if any of the players have no cards
       
       
       temp = processPlayer(in, playerHand, topCard); //lets the player play
       playerHand = temp.substring(0,temp.indexOf("-")); //resets the player hand
       topCard = temp.substring(temp.indexOf("-")+1); // resets the top card

         
     
       temp = processComputer(c1Hand, topCard, playerHand, c2Hand);// lets the computer play
       c1Hand = temp.substring(0,temp.indexOf("-")); //resets the computers hand
       topCard = temp.substring(temp.indexOf("-")+1); // resets the top card


       System.out.print("Computer 1 hand : " );
      
       drawCards(c1Hand); // displays the number of computer cards
       System.out.println();
       
       temp = processComputer(c2Hand, topCard ,playerHand, c1Hand); // lets the computer play
       c2Hand = temp.substring(0,temp.indexOf("-")); //resets the computers hand
       topCard = temp.substring(temp.indexOf("-")+1); // resets the top card
       

       System.out.print("Computer 2 hand : " );
       drawCards(c2Hand); // displays the number of computer cards
       System.out.println();
       System.out.println();




      }
      System.out.println("ROUND OVER");

       return calculatePoints(playerHand) + "-" + calculatePoints(c1Hand) + "-" + calculatePoints(c2Hand);                             
   }
   
   /**
    * 
    * @param hand
    */
   private static void drawCards(String hand) {
      
      if (hand.trim().length()==0){ //checks if the play has no cards
         return;
      }
      hand = hand.trim()+ " ";
      while (hand.length()>0){ // for every card print two x's and a space
         System.out.print("XX ");
         hand = hand.substring(hand.indexOf(" ")+1);
      }
   }
   
   /**
    * 
    * @param hand
    * @return points based of their hand
    */
   private static int calculatePoints(String hand) {
      int index = 0;
      int points = 0;
      String card = "";
      hand = hand.trim()+ " ";
      while (hand.trim().length()!=0){ // while they're is still cards in their hand
         card = hand.substring(index, hand.indexOf(" ")); // gets the card

         //checks if the card's rank is between 0-10 but not including 8
         if (!(card.substring(0,2).equals("8")) && (int) card.charAt(0)<=MAX_ASCII_VALUE && (int) card.charAt(0) >= MIN_ASCII_VALUE){
            points+= Integer.parseInt(card.substring(0, card.length()-1));

         //checks if the card is an ace   
         } else if (card.substring(0, card.length()-1).equals("A")){
            points+=1;

         //checks if the card's rank is a 10, Jack, Queen, or king
         } else if (card.substring(0, card.length()-1).equals("10")||card.substring(0, card.length()-1).equals("J")||card.substring(0, card.length()-1).equals("Q")||card.substring(0, card.length()-1).equals("K")){
            points+=10;

         //checks if the card's rank is an 8
         } else if (card.substring(0, card.length()-1).equals("8")){
            points+=50;
         
         } else{
            System.out.println("IF THIS MESSAGE PRINTS THERE IS A PROBLEM WITH CALCULATING POINTS");
         }
         if (hand.trim().indexOf(" ")==-1){
            return points;
         }
         //get's rid of card we just looked at
         hand=hand.substring(hand.indexOf(" ")+1);

      }
      
      


      return 0;
   }
   
   /**
    * 
    * @param cHand
    * @param topCard
    * @param opp1Hand
    * @param opp2Hand
    * @return updatedComputerHand-updatedTopCard
    */
   private static String processComputer(String cHand, String topCard, String opp1Hand, String opp2Hand) {
      

      int index = 0;
      String card = "";
      String suit = "";

      String topCardRank = topCard.substring(0,topCard.length()-1);
      String topCardSuit = topCard.substring(topCard.length()-1);

      cHand = validHand(cHand.trim(),topCardSuit,topCardRank); //makes sure the player has a valid card or gains 5 cards
      
      if (cHand.indexOf(topCardRank)!=-1 || cHand.indexOf(topCardSuit)!=-1 || cHand.indexOf("8")!=-1){ // if the player hand has a playable card
         
         if (opp1Hand.indexOf(" ")==-1 || opp2Hand.indexOf(" ")==-1){//checks is the opponents have 1 card
            
            while (cHand.indexOf(topCardRank,index)!=-1){ // find if we can change the suit via the same ranked card
               index = cHand.indexOf(topCardRank,index);
               card = cHand.substring(index, cHand.indexOf(" ", index));
               if (!(card.substring(card.length()-1).equals(topCardSuit))){ // checks if the cards rank is an 8
                  return cHand.replaceFirst(card + " ", "").trim() + "-" + card; 
               }

               index++;
               
            } if (cHand.indexOf("8")!=-1){ //finds if we can change the suit via and 8
               suit = getHighSuit(cHand,topCard.substring(topCard.length())); //gets the best suit we can play

               return cHand.replaceFirst(cHand.substring(cHand.indexOf("8"), cHand.indexOf("8")+2), "").trim() + "-8"+suit;
               
            }
         }
         
        
         index = 0;
         while (cHand.indexOf(topCardSuit,index)!=-1){ //finds if we can play a card with the same suit at topCard
            
            index = cHand.indexOf(topCardSuit,index);
            card = cHand.substring(cHand.lastIndexOf(" ", index)+1, cHand.indexOf(" ", index));
            if (card.indexOf("8")==-1){ //checks is the cards rank is an 8
               
            return cHand.replaceFirst(card + " ", "").trim() + "-" + card;
            } else{
               index++;
            }
         }
      
      
            
         
          
         index = 0;
         while (cHand.indexOf(topCardRank,index)!=-1){ //finds if we can play a card with the same rank at topCard
            index = cHand.indexOf(topCardRank,index);
            card = cHand.substring(index, cHand.indexOf(" ", index));
            if (card.indexOf("8")==-1){ //checks if the rank is an 8
            
            return cHand.replaceFirst(card + " ", "").trim() + "-" + card;
               } else{
                  index++;
               }
            }
         
            
            
            if (cHand.indexOf("8")!=-1){ //finds if we can change the suit via and 8 (this should always evaluate to true)
            suit = getHighSuit(cHand, "X"); // gets the suit that occurs most frequently in the hand
            card = cHand.substring(cHand.indexOf("8"),cHand.indexOf("8")+2);
            return cHand.replaceFirst(card + " ", "").trim() + "-8" + suit;

         } 
         

      }
      System.out.println("Computer was skipped"); // the computer was skipped because it picked up 5 cards an still could no play
      return cHand + "-" + topCard;
   }
       
/**
 * 
 * @param hand
 * @param bannedSuit
 * @return suit [H,C,S,D]
 */
   private static String getHighSuit(String hand, String bannedSuit){
      int H = 0;
      int D = 0;
      int C = 0;
      int S = 0;
      int maxNum = 0;

      //gets the number of Hearts, Diamonds, Spades and Clubs that are currently in the hand
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
      //find which suit has the highest occurences
      maxNum = Math.max(Math.max(H, C), Math.max(D, S));

      //which ever suit equals the highest value. we will return it
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
/**
 * 
 * @param playerPoints
 * @param c2Points
 * @param c1Points
 * @return if the game is over (Boolean)
 */
   private static boolean gameOver(int playerPoints, int c2Points, int c1Points) {
      return playerPoints >= 100 || c1Points >= 100 | c2Points >= 100;
   }

/**
 * 
 * @return a card format rankSuit
 */
private static String getCard() {
        String card = getFace() + getSuit();
        
        return card;
     }
  
/**
 * 
 * @return a random suit
 */
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
/**
 * 
 * @return a random rank
 */
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
/**
 * 
 * @param in
 * @param playerHand
 * @param topCard
 * @return updatedPlayerHand-updatedTopCard
 */

private static String processPlayer(Scanner in, String playerHand, String topCard) {
   boolean validInput = false;
   String suit = "";
   String card = "";
   String temp = "";
   String topCardRank = topCard.substring(0,topCard.length()-1);
   String topCardSuit = topCard.substring(topCard.length()-1);
   playerHand = validHand(playerHand,topCardSuit,topCardRank); //makes sure the player has a valid card or gains 5 cards
   if (playerHand.indexOf(topCardRank)!=-1 || playerHand.indexOf(topCardSuit)!=-1 || playerHand.indexOf("8")!=-1){ //checks if the player has a playable card
   while (!validInput){ //checks if the user has given a valid input
      System.out.println("Cards: " + playerHand);
      System.out.println("Top card is: " + topCard);
      System.out.print("Pick a card:");
      
      card = in.nextLine().toUpperCase(); //lets the user give input
      System.out.println();
      if (playerHand.indexOf(card) > -1 && card.length() > 1 && card.indexOf(" ")==-1 && cardValid(card,topCard) ){ // checks if the player card exists and if its valid
         
         validInput = true;
         if (card.indexOf("8")!=-1){ //checks if the card is an 8
            suit = promptSuit(in); //prompts user for a suit
            return playerHand.replaceFirst(card + " ", "").trim() + "-8" + suit;

         }
         

      } else if (!cardValid(card,topCard)){ //if the card is not valid
         System.out.println();
         System.out.println("Invalid card: this card is not playable"); // tell the user the card is not valid
      }
   
   
   
      else{
         System.out.println();
         System.out.println("Invalid input:"); //the user card does not exist
         
         System.out.println("Valid cards are: ");
      }


   }
} else{
   System.out.println("Your turn was skipped because you have no valid cards"); // the player could not play
   return playerHand.trim() + "-" + topCard;
}
   temp = playerHand.replaceFirst(card, "").trim() + "-" + card;
   return temp.replace("  ", " ");


   
   }

/**
 * 
 * @param in
 * @return suit
 */

private static String promptSuit(Scanner in) {
   boolean validInput = false;
   String suit = "";
   while(!validInput){
      System.out.print("what would you like to change the suit to:"); 
      suit = in.nextLine().toUpperCase(); // allows user to input a suit
      if (suit.equals("H")||suit.equals("C")||suit.equals("D")||suit.equals("S")){ // check if user input was valid
         return suit;
      } else{
         System.out.println("Invalid input: options are H, C, D, S"); // tells user input was not valid
      }
   }
   return null;
}

/**
 * 
 * @param card
 * @param topCard
 * @return if the card is valid
 */
private static boolean cardValid(String card, String topCard) {
   if (card.substring(0,card.length()-1).equals("8")){ //checks if the cards rank is an 8
      return true;
   }
   // else if ((topCard.indexOf(card.substring(0,card.length()-1))!=-1||topCard.indexOf(card.substring(card.length()-1))!=-1)){ //checks if the card has the same suit or rank as the topCard
   //    return true;
   else if (card.indexOf(topCard.substring(0,topCard.length()-1))!=-1||card.indexOf(topCard.substring(topCard.length()-1))!=-1 && card.substring(0,card.length()-1).length()!=card.length()){ //checks if the card has the same suit or rank as the topCard
      return true;

   }
   
   return false; 
}

/**
 * 
 * @param playerHand
 * @param topCardSuit
 * @param topCardRank
 * @return if the hand has a valid card
 */
private static String validHand(String playerHand, String topCardSuit, String topCardRank) {
   if (playerHand.length()==0){ //if there are no cards return an empty string
      return "";
   }
   int addedCards = 0;
   while(playerHand.indexOf(topCardRank)==-1 && playerHand.indexOf(topCardSuit)==-1&&playerHand.indexOf("8")==-1){ // checks if there are no valid cards
      playerHand+= " " + getCard(); //adds a new card
      addedCards++;
      if (addedCards==5){ // if we added five cards return the player hand
         return playerHand + " ";
      }      
   }
   return playerHand + " ";
}
}