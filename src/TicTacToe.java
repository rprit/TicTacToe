import java.util.Scanner;

public class TicTacToe{
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        char[][] boxNumber = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
        char[][] board ={{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        char symbol = 'x';
        int box, count=0;

        System.out.println("Let's play Tic-Tac-Toe! The boxes are numbered as below: ");
        displayBoard(boxNumber);
        System.out.println("\n");
        displayBoard(board);

        do
        {
            System.out.print("\nPlayer "+ ( (symbol=='x')?"1":"2" )+"'s turn. Select a box number to play: ");
            box=keyboard.nextInt();
            keyboard.nextLine();

            if(!playIfValidTurn(box, symbol, board))
            {
                System.out.println("\nSelect a valid box number!");
                continue;
            }

            count++;
            symbol = (symbol=='x')?'o':'x';
            displayBoard(board);

        }while( !isGameCompleted(board) && count!=9);

        if(isGameCompleted(board))
        {
            if (symbol == 'x')
                System.out.println("\nPlayer 2 wins!");
            else
                System.out.println("\nPlayer 1 wins!");
        }
        else
            System.out.println("\nNo winner this time!");
    }
    public static boolean playIfValidTurn(int box, char symbol, char[][] board)
    {
        int i,j;
        switch(box)
        {
            case 1: i=0; j=0; break;
            case 2: i=0; j=1; break;
            case 3: i=0; j=2; break;
            case 4: i=1; j=0; break;
            case 5: i=1; j=1; break;
            case 6: i=1; j=2; break;
            case 7: i=2; j=0; break;
            case 8: i=2; j=1; break;
            case 9: i=2; j=2; break;
            default: return false;
        }
        if(board[i][j]==' ')
        {
            board[i][j]=symbol;
            return true;
        }
        return false;
    }

    public static boolean isGameCompleted(char[][] board)
    {
        return (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] != ' ') ||
                (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] != ' ') ||
                (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] != ' ') ||
                (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] != ' ') ||
                (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] != ' ') ||
                (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] != ' ') ||
                (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != ' ') ||
                (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1] != ' ');
    }

    public static void displayBoard(char[][] board)
    {
        System.out.println();
        for(char i = 0; i<3; i++)
        {
            for(char j=0; j<3; j++)
            {
                System.out.print(board[i][j]);
                if(j!=2)
                    System.out.print(" | ");
            }
            if(i!=2)
                System.out.print("\n- - - - -\n");
        }
    }
}