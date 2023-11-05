import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

public class NumberGame {
    private static ArrayList<Boolean> track = new ArrayList<>();
    public boolean response = false;
    public Scanner value = new Scanner(System.in); 

    protected void finalize(){
        value.close();
    }

    void wantToContinue() {
        
        System.out.print("\nEnter (Yes/No) : ");
        
        String yesorno = value.next();

        if (yesorno.equalsIgnoreCase("Yes")) {
            this.response = true;
        } else if(yesorno.equalsIgnoreCase("No")){
            this.response = false;
        } else{
            System.err.println("[Error] Invalid Input.");
            wantToContinue();
        }       
    }

    void play() 
    {
        byte num = 0;
        byte userGuessedNumber = 0;
        byte i;         

        for (i = 3; i > 0; --i) 
        {
            num = (byte)(Math.random() * 100);
            System.out.print("\nEnter your choice : ");

            if(value.hasNextByte())
            userGuessedNumber = value.nextByte();
            else{
                System.out.println("\t\tIncorrect number!!!");
                System.out.println("\t\tYou lost your attempt too !!!");
                value.next();
                continue;
            }            

            if (num == userGuessedNumber){                    
                track.add(true);
                System.out.println("\t\t\tNumber is corrext ");               
                System.out.println("\t\tYou Won !!!");
                return;
            } 
            
            else{
                if(num > userGuessedNumber)
                {
                    System.out.println("\t\t\tNumber is too low ");
                }
                else{
                    System.out.println("\t\t\tNumber is too high ");
                }

                if(i != 1)
                System.out.format("\t\tTry again, you still got %d attempts\n\n", i-1);
            }             
        }       

        if (i == 0) {
            track.add(false);
            System.out.println("\n\t\t\tYou lost!!!");
        }                           
    }

    void gametrack() {
        System.out.println("\n\n\t\t*********ScoreBoard***********");
        byte i = 1;
        for (boolean result : track) 
        {
            if (result == true) {
                System.out.format("\t\tMatch %d : Player %s Computer %s\n\n", i, "Won", "Lost");
            } else {
                System.out.format("\t\tMatch %d : Player %s Computer %s\n\n\n", i, "Lost", "Win");
            }
            i++;
        }
    }

    public static void main(String[] args) {

        System.out.println("\t\tWelcome to Number Game\n");
        System.out.println("\t\tHow to play this game?");
        System.out.println("\t\t1. You are supposed to guess the number between 1 to 100 (Make sure you write the number in this range only.)");
        System.out.println("\t\t2. If you get it right, you win!");
        System.out.println("\t\t3. If you do not then don't worry you are given 3 attempts to guess the correct number");
        System.out.println("\t\tSo are you ready to play this game?!!!");

        for(;;)
        {
            NumberGame letsPlay = new NumberGame();

            letsPlay.wantToContinue();
            
            if(letsPlay.response == false)
            break;
            
            letsPlay.play();
            letsPlay.gametrack();            
        }

        System.out.println("Thanks for visiting!!!");

        return;
    }
}
