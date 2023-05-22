package training.basics.io;

import java.util.Scanner;

public class ScannerTrial
{
    static String input = "42\nIt is a magic number.\n";
    
    public static void main(String[] args)
    {
        // nextLine()
        Scanner sc1 = new Scanner(input);
        int num1 = Integer.parseInt(sc1.nextLine());
        String nextLineText1 = sc1.nextLine();
        giveNoticeWhenFalse(42 == num1);
        giveNoticeWhenFalse("It is a magic number.".equals(nextLineText1));
    
        // nextInt()
        Scanner sc2 = new Scanner(input);
        int num2 = sc2.nextInt(); // nextInt() leaves the newline charater (\n) behind
        String nextLineText2 = sc2.nextLine();
        
        giveNoticeWhenFalse(42==num2);
        giveNoticeWhenFalse("".equals(nextLineText2));
    }
    
    private static void giveNoticeWhenFalse(boolean booleanValue)
    {
        if(!booleanValue)
        {
            System.out.println("False!!!");
        }
    }
}
