import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);       //to read all types of input from the user

        //---Display board game for the user -----------------------------------------------------------------------
//        int [][] board=new int[3][3];
//        int count=1;
//        for (int i=0;i<board.length;i++){
//            System.out.println();
//            for(int j=0;j<board.length;j++){
//                board [i][j]=count;
//                System.out.print("  "+board [i][j]);
//                count++;
//            }
//        }
        String[][] board = new String[3][3];
        board[0][0] = "1";
        board[0][1] = "2";
        board[0][2] = "3";
        board[1][0] = "4";
        board[1][1] = "5";
        board[1][2] = "6";
        board[2][0] = "7";
        board[2][1] = "8";
        board[2][2] = "9";
        //print the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print("  " + board[i][j]);
            }
            System.out.println();
        }
        String num;
        String num_x = "123456789";
        String numx;
        String num_2;

//--------------------------------------------------choose 1 player /2player--------------------------------------------
        try {
            System.out.println("Choose 1 for one player OR  2 for tow players:");
            int player = input.nextInt();
            switch (player) {
                case 1:
                    //---------------------------------------------------1player----------------------------------------------------------
                    System.out.println("you want 1/ round 2/rounds ");
                    int r=input.nextInt();
                    if (r>3 && r<=0){
                        throw new Exception("Enter number 1 or 2 for rounds ");
                    }
                    System.out.println("Choose a role X or O");
                    String role = input.next();
//                    if ( !role.equalsIgnoreCase("X")  || ( !role.equalsIgnoreCase("O")) ){
//                        throw new Exception( "Enter X or O only");    }

                    //Start to play---------------------------------------------------------------------------------------------
                    if (role.equalsIgnoreCase("x")) {
                        String rolx = "o";
                        while (r>0){

                        while (full(board) && (!win(board))) {
                            do {
                                System.out.println("Player 1:  Enter number");  //اسوي throw enter number from 1-9
                                num = input.next();
                                if (check_availble(board, num)) {
                                    place_role(board, num, role);
                                    win(board);
                                    break;

                                } else
                                    System.out.println("choose again");

                            } while (!check_availble(board, num));

                            if (!win(board)) {
                                if (full(board)) {
                                    do {
                                        numx = randomNumberGenerator(num_x);
                                        if (check_availble(board, numx)) {
                                            place_role(board, numx, rolx);
                                            win(board);
                                            break;
                                        } else
                                            System.out.println("choose again");
                                    } while (!check_availble(board, num));
                                }


                            }
                        }
                        r--;

                        }
                        print_score(board);


                    } else if (role.equalsIgnoreCase("o")) {
                        String rolx = "x";

                        while (full(board) && (!win(board))) {
                            do {
                                System.out.println("Player 1:  Enter number");  //اسوي throw enter number from 1-9
                                num = input.next();
                                if (check_availble(board, num)) {
                                    place_role(board, num, role);
                                    win(board);
                                    break;

                                } else
                                    System.out.println("choose again");

                            } while (!check_availble(board, num));

                            if (!win(board)) {
                                if (full(board)) {
                                    do {
                                        numx = randomNumberGenerator(num_x);
                                        if (check_availble(board, numx)) {
                                            place_role(board, numx, rolx);
                                            win(board);
                                            break;
                                        } else
                                            System.out.println("choose again");
                                    } while (!check_availble(board, num));
                                }
                            }
                        }

                        print_score(board);
                    }
                    break;

                case 2://-------------------------------------------------2player------------------------------------------------------------

                    //--Ask the user to pick a role (X or O)--------------------------------------------------------------------
                    System.out.println("Choose a role X or O");
                    role = input.next();
//                    if ( !role.equalsIgnoreCase("x")  || ( !role.equalsIgnoreCase("o")) ){                // if i use throw the if condition below not work
//                        throw new Exception( "Enter X or O only");    }

                    //Start to play---------------------------------------------------------------------------------------------
                    if (role.equalsIgnoreCase("x")) {
                        String rolx = "o";

                        while (full(board) && (!win(board))) {
                            do {
                                System.out.println("Player 1:  Enter number");  //اسوي throw enter number from 1-9
                                num = input.next();
                                if (check_availble(board, num)) {
                                    place_role(board, num, role);
                                    win(board);
                                    break;

                                } else
                                    System.out.println("choose again");

                            } while (!check_availble(board, num));

                            if (!win(board)) {
                                if (full(board)) {
                                    do {

                                        System.out.println("Player 2:  Enter number");  //اسوي throw enter number from 1-9
                                        num_2 = input.next();
                                        if (check_availble(board, num_2)) {
                                            place_role(board, num_2, rolx);
                                            win(board);
                                            break;
                                        } else
                                            System.out.println("choose again");
                                    } while (!check_availble(board, num));
                                }


                            }
                        }
                        print_score(board);


                    } else if (role.equalsIgnoreCase("o")) {
                        String rolx = "x";

                        while (full(board) && (!win(board))) {
                            do {
                                System.out.println("Player 1:  Enter number");  //اسوي throw enter number from 1-9
                                num = input.next();
                                if (check_availble(board, num)) {
                                    place_role(board, num, role);
                                    win(board);
                                    break;

                                } else
                                    System.out.println("choose again");

                            } while (!check_availble(board, num));

                            if (!win(board)) {
                                if (full(board)) {
                                    do {

                                        System.out.println("Player 2:  Enter number");  //اسوي throw enter number from 1-9
                                        num_2 = input.next();
                                        if (check_availble(board, num_2)) {
                                            place_role(board, num_2, rolx);
                                            win(board);
                                            break;
                                        } else
                                            System.out.println("choose again");
                                    } while (!check_availble(board, num));
                                }


                            }
                        }
                        print_score(board);
                    }


                    break;
                default:
                    System.out.println("Choose 1 or 2 ");
            }
        }catch (InputMismatchException e){
            System.out.println("Enter number 1 or 2 ");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

//


    //    public static boolean play(String[][] board) {
//        boolean play = true;
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board.length; j++) {
//                if (board[i][j].contains("x") || board[i][j].contains("o")) {
//                    play = false;
//                }
//            }
//        }
//        return play;
//    }
    public static void place_role(String board[][], String x, String role) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {

                if (x.equals(board[i][j])) {
                    board[i][j] = role;
                }
                System.out.print("  " + board[i][j]);
            }
            System.out.println();
        }
    }


    public static boolean check_availble(String board[][], String x) {
        boolean free = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {

                if (x.equals(board[i][j])) {
                    free = true;
                }
            }
        }
        return free;
    }

    public static String randomNumberGenerator(String num_x) {
        // create random string builder
        StringBuilder str_num = new StringBuilder();
        // create an object of Random class
        Random r = new Random();
        // specify length of random string
        for (int i = 0; i < 1; i++) {
            // generate random index number
            int index = r.nextInt(num_x.length());
            // get character specified by index
            // from the string
            char randomChar = num_x.charAt(index);
            // append the character to string builder
            str_num.append(randomChar);
        }
        String randomString = str_num.toString();
        num_x = randomString;
        return num_x;
    }


    public static boolean win(String[][] board) {
        boolean win = false;

            for(int i=0;i<3;++i){// row win
                if (board[i][0].equalsIgnoreCase("x")  &&  board[i][1].equalsIgnoreCase("x") && board[i][2].equalsIgnoreCase("x")) {
                   //count_x++;
                    win=true;


                }  else if (board[i][0].equalsIgnoreCase("o")  &&  board[i][1].equalsIgnoreCase("o") && board[i][2].equalsIgnoreCase("o")) {
                  //  count_o++;
                    win=true;

                }

            }

            for (int j=0;j<3;++j){//win colum
                if (board[0][j].equalsIgnoreCase("x")  &&  board[1][j].equalsIgnoreCase("x") && board[2][j].equalsIgnoreCase("x")) {
                    win=true;


                }  else if (board[0][j].equalsIgnoreCase("o")  &&  board[1][j].equalsIgnoreCase("o") && board[2][j].equalsIgnoreCase("o")) {
                  // count_o++;
                    win=true;

                }

            }

            //win cross
            if (board[0][0].equalsIgnoreCase("x")  && board[1][1].equalsIgnoreCase("x")  && board[2][2].equalsIgnoreCase("x")) {
                //count_x++;
                win=true;

            } else if (board[0][2].equalsIgnoreCase("x")  && board[1][1].equalsIgnoreCase("x")  && board[2][0].equalsIgnoreCase("x")) {
               // count_x++;
                win=true;

            }
            else if  (board[0][0].equalsIgnoreCase("o")  && board[1][1].equalsIgnoreCase("o")  && board[2][2].equalsIgnoreCase("o")) {
                     // count_o++;
                       win=true;


            }else if (board[0][2].equalsIgnoreCase("o")  && board[1][1].equalsIgnoreCase("o")  && board[2][0].equalsIgnoreCase("o")) {
               // count_o++;
                win=true;
            }
//print number of win
//        System.out.println("Player x win :"+count_x);
//        System.out.println("Player x win :"+count_o);

        return win;
    }
        public static boolean full (String[][]board){
            boolean full = true;
            int count = 0;
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[i].length; ++j) {
                    if (board[i][j].equalsIgnoreCase("x") ) {
                        count++;
                    } else if (board[i][j].equalsIgnoreCase("o")){
                        count++;
                    }
                }
            }

            if (count == 9) {
                System.out.printf("End game ");
                full = false;
            }
            return full;
        }
        public static void print_score(String [][]board){
            int count_x=0;
            int count_o=0;
            int win_x=0;
            int win_o=0;
                                //win  x  colum
            if (board[0][0].equalsIgnoreCase("x")  &&  board[1][0].equalsIgnoreCase("x") && board[2][0].equalsIgnoreCase("x")) {
               count_x++;}
            else if (board[0][1].equalsIgnoreCase("x")  &&  board[1][1].equalsIgnoreCase("x") && board[2][1].equalsIgnoreCase("x")) {
                count_x++;}
            else if (board[0][2].equalsIgnoreCase("x")  &&  board[1][2].equalsIgnoreCase("x") && board[2][2].equalsIgnoreCase("x")) {
                count_x++;}



                                 //win  o  colum
            if (board[0][0].equalsIgnoreCase("o")  &&  board[1][0].equalsIgnoreCase("o") && board[2][0].equalsIgnoreCase("o")) {
                count_o++;}
            else if (board[0][1].equalsIgnoreCase("o")  &&  board[1][1].equalsIgnoreCase("o") && board[2][1].equalsIgnoreCase("o")) {
                count_o++;}
            else if (board[0][2].equalsIgnoreCase("o")  &&  board[1][2].equalsIgnoreCase("o") && board[2][2].equalsIgnoreCase("o")) {
                count_o++;}


                                //win  x  row
            if (board[0][0].equalsIgnoreCase("x")  &&  board[0][1].equalsIgnoreCase("x") && board[0][2].equalsIgnoreCase("x")) {
                count_x++;}
            else if (board[1][0].equalsIgnoreCase("x")  &&  board[1][1].equalsIgnoreCase("x") && board[1][2].equalsIgnoreCase("x")) {
                count_x++;}
            else if (board[2][0].equalsIgnoreCase("x")  &&  board[2][1].equalsIgnoreCase("x") && board[2][2].equalsIgnoreCase("x")) {
                count_x++;}

                             //win  o  row
            if (board[0][0].equalsIgnoreCase("o")  &&  board[0][1].equalsIgnoreCase("o") && board[0][2].equalsIgnoreCase("o")) {
                count_o++;}
            else if (board[1][0].equalsIgnoreCase("o")  &&  board[1][1].equalsIgnoreCase("o") && board[1][2].equalsIgnoreCase("o")) {
                count_o++;}
            else if (board[2][0].equalsIgnoreCase("o")  &&  board[2][1].equalsIgnoreCase("o") && board[2][2].equalsIgnoreCase("o")) {
                count_o++;}



            //win cross
            if (board[0][0].equalsIgnoreCase("x")  && board[1][1].equalsIgnoreCase("x")  && board[2][2].equalsIgnoreCase("x")) {
                count_x++;
            }
            else if (board[0][2].equalsIgnoreCase("x")  && board[1][1].equalsIgnoreCase("x")  && board[2][0].equalsIgnoreCase("x")) {
                count_x++;

            }
            else if  (board[0][0].equalsIgnoreCase("o")  && board[1][1].equalsIgnoreCase("o")  && board[2][2].equalsIgnoreCase("o")) {
                count_o++;



            }else if (board[0][2].equalsIgnoreCase("o")  && board[1][1].equalsIgnoreCase("o")  && board[2][0].equalsIgnoreCase("o")) {
                count_o++;
            }


            System.out.println("Player x win :"+count_x);
            System.out.println("Player o win :"+count_o);

        }

        //_____________________________________________________THE CALCULATOR ________________________________________________________

//    public static void main(String[] args) {
//
//        ArrayList<Integer>  cal= new ArrayList<Integer>();
//        int num1;
//        int num2;
//        int add;
//        int sub;
//        int mul;
//        int div;
//        int mod;
//        int avr;
//        int min;
//        int max;
//        int ans;
//        String q="q";
//        Scanner input=new Scanner(System.in);
//int sum=0;
//        int choose;
//
//
//try {
//    do {
//        System.out.println("Enter number to perform");
//        System.out.println("1/ addithion");
//        System.out.println("2/ subtract");
//        System.out.println("3/ Multiplication");
//        System.out.println("4/ Division");
//        System.out.println("5/ Module");
//        System.out.println("6/ Minimum");
//        System.out.println("7/ Maximum");
//        System.out.println("8/ Find the average ");
//        System.out.println("9/ Last result");
//        System.out.println("10/ Print list of all answers");
//        System.out.println("0/ Quit");
//        choose = input.nextInt();
//        switch (choose) {
//            case 1:
//                System.out.println("Enter number to add ");
//                num1 = input.nextInt();
//                System.out.println("Enter number 2");
//                num2 = input.nextInt();
//
//                cal.add(addition(num1, num2));
//                break;
//            case 2:
//                System.out.println("Enter number 1");
//                num1 = input.nextInt();
//                System.out.println("Enter number 2");
//                num2 = input.nextInt();
//
//                cal.add(sub(num1, num2));
//                break;
//            case 3:
//                System.out.println("Enter number 1");
//                num1 = input.nextInt();
//                System.out.println("Enter number 2");
//                num2 = input.nextInt();
//                cal.add(mul(num1, num2));
//
//                break;
//            case 4:
//                System.out.println("Enter number 1");
//                num1 = input.nextInt();
//                System.out.println("Enter number 2");
//                num2 = input.nextInt();
//
//                cal.add(div(num1, num2));
//
//                break;
//            case 5:
//                System.out.println("Enter number 1");
//                num1 = input.nextInt();
//                System.out.println("Enter number 2");
//                num2 = input.nextInt();
//                cal.add(mod(num1, num2));
//                break;
//            case 6:
//                System.out.println("Enter number 1");
//                num1 = input.nextInt();
//                System.out.println("Enter number 2");
//                num2 = input.nextInt();
//                cal.add(min(num1, num2));
//
//                break;
//            case 7:
//                System.out.println("Enter number 1");
//                num1 = input.nextInt();
//                System.out.println("Enter number 2");
//                num2 = input.nextInt();
//                cal.add(max(num1, num2));
//                break;
//            case 8:
//                System.out.println("Enter number 1");
//                num1 = input.nextInt();
//                System.out.println("Enter number 2");
//                num2 = input.nextInt();
//                cal.add(avr(num1, num2));
//                break;
//            case 9:
//                System.out.println("The last answer is " + cal.getLast());
//
//                break;
//            case 10:
//                System.out.println(cal);
//                break;
//
//
//        }
//    } while (!(choose == 0));
//}catch (InputMismatchException e)
//{
//    System.out.println("Enter numbers only");
//}catch (ArithmeticException e){
//    System.out.println("Cannot divid by zero");
//}
//
//    }
//
//
//    public static int addition(int x,int y){
//        int sum=0;
//        sum=x+y;
//        System.out.println("The answer is " + sum);
//        return sum;
//    }
//    public static int sub(int x,int y){
//        int sub=x-y;
//        System.out.println("The answer is " + sub);
//        return sub;
//    }
//    public static int mul(int x,int y){
//        int mul=x*y;
//        System.out.println("The answer is " + mul);
//        return mul;
//    }
//    public static int div(int x,int y){
//        int div=x/y;
//        System.out.println("The answer is " + div);
//        return div;
//    }
//    public static int mod(int x,int y){
//        int mod=x%y;
//        System.out.println("The answer is " + mod);
//        return mod;
//    }
//
//    public static int min(int x,int y){
//        int     min = Math.min(x, y);
//        System.out.println("The answer is " + min);
//        return min;
//    }
//    public static int max(int x,int y){
//        int     max = Math.max(x, y);
//        System.out.println("The answer is " + max);
//        return max;
//    }
//    public static int avr(int x,int y){
//        int     avr = (x + y) / 2;
//        System.out.println("The answer is " + avr);
//        return avr;
//    }



}






