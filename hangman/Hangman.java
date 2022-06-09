import java.util.Random;
public class Hangman {
    private StringBuffer secretWord = new StringBuffer();
    private StringBuffer knownSoFar = new StringBuffer();
    private StringBuffer allLetters = new StringBuffer();
    private StringBuffer usedLetters = new StringBuffer();
    private int numberOfIncorrectTries;
    private int maxAllowedTries = 7;
    private String[] wordList;
    public static int letterCount;
    private String [][] hangman = { {" ","_","_","_","_","_"," "},
                                    {"|"," "," "," "," "," ","|"},
                                    {"|"," "," "," "," "," ","|"},
                                    {"|"," "," "," "," "," ","|"},
                                    {"|"," "," "," "," "," ","|"},
                                    {"|","_","_","_","_","_","|"}
                                                                    };

    public Hangman(){
        this.wordList = new String[] {"afghanistan","armenia","azerbaijan","bahrain","bangladesh","bhutan","brunei","cambodia","china","cyprus","georgia","india","indonesia","iran","iraq","israel","japan","jordan","kazakhstan","kuwait","kyrgyzstan","laos","lebanon","malaysia",
"maldives","mongolia","myanmar","nepal","northkorea","oman","pakistan","palestine","philippines","qatar","russia","saudiarabia","singapore","southkorea","srilanka","syria","taiwan","tajikistan","thailand","timorleste","turkey","turkmenistan","unitedarabemirates","uzbekistan","vietnam","yemen" };

        chooseSecretWord();
        for( int i=0; secretWord.length()>i;i++){ //creating knownSoFar with blanks
            knownSoFar = knownSoFar.append(".");
            allLetters.append(secretWord.charAt(i)); //allLetters may contain same letters!!!
        }
    }
    public int getLength(){
        return wordList.length;
    }
    public int getMaxAllowedTries(){
        return maxAllowedTries;
    }
    public String getAllLetters() {
        return allLetters.toString();
    }
    public String getUsedLetters(){
        return usedLetters.toString();
    }
    public int getNumOfIncorrectTries() {
        return numberOfIncorrectTries;
    }
    public String getKnownSoFar() {
        return knownSoFar.toString();
    }
    public boolean isGameOver(){
        if(this.knownSoFar.toString().equals(this.secretWord.toString()) || hasLost()){
            return true;
        }
        return false;
    }
    public boolean hasLost(){
        if(this.maxAllowedTries==this.numberOfIncorrectTries){
            return true;
        }
        return false;
    }
    private void chooseSecretWord(){
        Random RANDOM = new Random();
        this.secretWord.append(wordList[RANDOM.nextInt(wordList.length)]);
        //int i=(int) Math.random()*(wordList.length-1);
        //secretWord=new StringBuffer(this.wordList[i]);
    }
    public int tryThis(char c){
        this.letterCount =0;
        boolean b = false; //Same letter for the second time?
        boolean isTheLetterExist = false;
        for(int i = 0; i< this.usedLetters.length();i++){
            if(c == (this.usedLetters.charAt(i))){
               b=true;
            }
        }
        if(b){ //2nd time
            System.out.println("You have already tried the same letter!");
            numberOfIncorrectTries++;
            letterCount++;
            hasLost();
            isGameOver();
        }
        else{ //1st time
            for(int i = 0; i<this.secretWord.length();i++){
                if(c == (this.secretWord.charAt(i))){
                    letterCount++;
                    knownSoFar.replace(i,i+1,Character.toString(c));
                    isTheLetterExist=true;
                }
            }
            usedLetters.append(c);
            if(isTheLetterExist==false){ //1st time but not in the secretWord
                numberOfIncorrectTries++;
            }
            hasLost();
            isGameOver();
        }
        return letterCount;
    }
//UI
    public void drawnTable(){
    switch (this.numberOfIncorrectTries) {
        case 0:
            System.out.println(HangmanToString(hangman));
            break;
        case 1:
            hangman[1][3]="|";
            System.out.println(HangmanToString(hangman));
            break;
        case 2:
            hangman[2][3]="O";
            System.out.println(HangmanToString(hangman));
            break;
        case 3:
            hangman[3][3]="|";
            System.out.println(HangmanToString(hangman));
            break;
        case 4:
            hangman[4][2]="/";
            System.out.println(HangmanToString(hangman));
            break;
        case 5:
            hangman[4][4]="\\";
            System.out.println(HangmanToString(hangman));
            break;
        case 6:
            hangman[3][2]="/";
            System.out.println(HangmanToString(hangman));
            break;
        case 7:
            hangman[3][4]="\\";
            System.out.println(HangmanToString(hangman));
            break;
    }
    }
    public String HangmanToString(String [][] hangman){
        String result = "\n";
        for(int i=0; i<hangman.length; i++){
          for(int j=0; j<hangman[0].length; j++)
            result+= hangman[i][j];
          result+= "\n";      
        }
        return result;
      }

}