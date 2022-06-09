import java.util.Scanner;
public class Hangman_Tester {
    public static void main(String[] args){
        Hangman h = new Hangman ();
        Scanner in = new Scanner(System.in);
        //Introductin and information
        System.out.println("Welcome to the Hangman Game");
       // System.out.println("The Category: Countries in Asia");
       System.out.println("The Category: Ton Agalari");
        System.out.println("You will try to find the name of a country\nYou have "+h.getMaxAllowedTries()+" tries in total.");
        System.out.println("Please use only the english alphabet. Otherwise you will loose one of your tries.");
        System.out.println("So if you are ready, let's start the game :)");
        System.out.println("--------------------------------------------");
        
        /*final String engAlphabet = "abcdefghijklmnopqrstuvwxyz";
        boolean engAlphabetCheck; */
        System.out.println("Here is the word: "+h.getKnownSoFar());
        h.drawnTable();
        while(!h.isGameOver()){
            System.out.print("Please enter a letter:");
            char c = in.next().toLowerCase().charAt(0);
        /*  //Continue if c is from the eng alphabet
            engAlphabetCheck = false;
            while(engAlphabetCheck){ 
                for(int i =0; i<engAlphabet.length();i++){
                    if(c == engAlphabet.charAt(i)){
                        engAlphabetCheck = true;
                    }
                }
                if(!engAlphabetCheck){
                    c=in.next().charAt(0);
                }
            } */
            h.tryThis(c);
            System.out.println("You can see this letter "+h.letterCount+" time/s in the word!");
            System.out.println("Here is the word: "+h.getKnownSoFar());
            System.out.println("Number of allowed tries: "+( h.getMaxAllowedTries() - h.getNumOfIncorrectTries()));
            System.out.println("Used letters: " + h.getUsedLetters());
            h.drawnTable();
        }
        System.out.println("The Game Is Over");
        System.out.println("The Secret Word was \""+h.getAllLetters().toUpperCase()+"\"");
        if(h.hasLost()){
            System.out.println("!YOU LOST THE GAME!");
        }
        else{
            System.out.println("! CONGRATULATION, YOU WIN !");
        }
        in.close();
    }
}
