import java.util.Scanner;
public class TicTakGame {
    public static String tictakBoard[][]={{"1","2","3"},{"4","5","6"},{"7","8","9"}};

    public static int playerCount=0;
    public static void print(){
        for(int i=0;i<tictakBoard.length;i++)
        {
            for(int j=0;j<tictakBoard[i].length;j++)
            {
                System.out.print(tictakBoard[i][j]+" | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // greeting to ask
    public static void greeting(Scanner sc)
    {
        int num;
        //int y;
        System.out.println(playerCount%2==0 ? "Player X" : "Player O");
        System.out.println();
        System.out.println("Enter  pos");
        num = sc.nextInt();
        int row = (num-1)/3;
        int col = (num-1)%3;
        System.out.println(placing(row,col,playerCount%2==0 ? "X" : "O"));
    }

    //placing X and O method
    public static String placing(int row, int col, String playerName) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            if (!tictakBoard[row][col].equals("X") && !tictakBoard[row][col].equals("O")) {
                tictakBoard[row][col] = playerName;
                print();
                playerCount++;
                if (Checking()) {
                    System.out.println(playerName + " Wins!!!!");
                    System.exit(0);
                } else if (playerCount == 9) {
                    System.out.println("Match Draw !!");
                    System.exit(0);
                }
                return "Success";
            } else {
                return "Already Occupied !!!";
            }
        } else {
            return "Undefined Place !!!!!";
        }
    }
    
    //Checking win or draw
    public static boolean Checking()
    {
        //row
        for(int i=0;i<tictakBoard.length;i++)
        {
            if(tictakBoard[i][0].equals(tictakBoard[i][1]) && tictakBoard[i][1].equals(tictakBoard[i][2]))
            {
                return true;
            }
        }
        //col
        for(int i=0;i<tictakBoard.length;i++)
        {
            if(tictakBoard[0][i].equals(tictakBoard[1][i]) && tictakBoard[0][i].equals(tictakBoard[2][i]))
            {
                return true;
            }
        }
        //dia left
        if(tictakBoard[0][2].equals(tictakBoard[1][1]) && tictakBoard[1][1].equals(tictakBoard[2][0]))
        {
            return true;
        }
        // dia right
        if(tictakBoard[0][0].equals(tictakBoard[1][1]) && tictakBoard[1][1].equals(tictakBoard[2][2]))
        {
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        print();
        while(true)
        {
            greeting(sc);
        }
        
    }
}