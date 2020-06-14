package algebra_tutor;


import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class AlgebraTutor
{
    public static int random_int()
    {
        int random_number = ThreadLocalRandom.current().nextInt(-100,100);
        return random_number;
    }
    public static int create_y_equation()
    {
        int m = random_int();
        int x = random_int();
        int b = random_int(); 
        System.out.println("If m = "+ m + ", x = " + x + ", and b = " + b + ", what is the value of y?");
        int y = (m * x) + b;
        
        return y;
    }
    public static int create_m_equation()
    {
        int y = random_int();
        int x = random_int();
        int b = random_int(); 
        System.out.println("If y = " + y + ", x = " + x + ", and b = " + b + ", what is the value of m?");
        int m = (y - b) / x; 
        
        return m;
    }
    public static int create_b_equation()
    {
        int y = random_int();
        int x = random_int();
        int m = random_int(); 
        System.out.println("If y = " + y + ", x = " + x + ", and m = " + m + ", what is the value of b?");
        int b = y - (m * x); 
        
        return b;
    }
    public static int get_student_answer()
    {
        Scanner user_input = new Scanner( System.in );
        int get_student_answer;
        System.out.print("\nPlease enter your answer: ");
        get_student_answer = user_input.nextInt();
        System.out.println("\nYou answered " + get_student_answer + ".");
        return get_student_answer;
    }
    public static void percentage_correct(int total_correct, int total_questions)
    {
        int correct_calculation = 100 * (total_correct / total_questions);
        System.out.println("\nYou answered " + correct_calculation + "% correctly.");
    }
    public static void present_y_package()
    {
        int number_correct = 0;
        int number_attempted = 0;
        while (number_attempted < 6)
        {

            int y = create_y_equation();
            int student_answer = get_student_answer();
            if (student_answer == y)
            {
                number_correct++;
                number_attempted++;
                System.out.println("\nYou are correct, y is equal to " + y + ".");    
                
            } 
            else 
            {
                number_attempted++;
                System.out.println("\nYou are incorrect, y is equal to " + y + ". Please try again.\n");
                if (number_attempted > 3)
                {
                    System.out.println("Hint: the correct equation to use is y = m * x + b.");
                }
            }
            if (number_correct == 3)
            {
                break;
            }
        }
        percentage_correct(number_correct, number_attempted);
        return;
    }
    public static void present_m_package()
    {
        int number_correct = 0;
        int number_attempted = 0;
        while (number_attempted < 6)
        {
            System.out.println("check number_attempted " + number_attempted);
            int m = create_m_equation();
            int student_answer = get_student_answer();
            if (student_answer == m)
            {
                number_correct++;
                number_attempted++;
                System.out.println("check number_attempted " + number_attempted);
                System.out.println("\nYou are correct, m is equal to " + m + ".");    
            } 
            else 
            {
                number_attempted++;
                System.out.println("check number_attempted in else" + number_attempted);
                System.out.println("\nYou are incorrect, m is equal to " + m + ". Please try again.\n");
                if (number_attempted > 3)
                {
                    System.out.println("Hint: the correct equation to use is m = (y - b) / x.");
                    System.out.println("check number_attempted in hint" + number_attempted);
                }
            }
            if (number_correct == 3)
            {
                break;
            }
        }
        percentage_correct(number_correct, number_attempted);
        return;
    }
    public static void present_b_package()
    {
        int number_correct = 0;
        int number_attempted = 0;
        while (number_attempted < 6)
        {
            int b = create_b_equation();
            int student_answer = get_student_answer();
            if (student_answer == b)
            {
                number_correct++;
                number_attempted++;
                System.out.println("\nYou are correct, b is equal to " + b + ".");    
            } 
            else
            {
                number_attempted++;
                System.out.println("\nYou are incorrect, b is equal to " + b + ". Please try again.\n");
                if (number_attempted > 3)
                {
                    System.out.println("Hint: the correct equation to use is b = y - (m * x).");
                }
            }
            if (number_correct == 3)
            {
                break;
            }
        }
        percentage_correct(number_correct, number_attempted);
        return;
    }
    public static void main(String[] args)
    {
        Scanner menu = new Scanner( System.in );
        int menu_choice;
        
        while (true)
        {
            menu_choice = 0;
            System.out.print("\nPlease select a number from the following menu: \n1) Solve for y. \n2) Solve for m. \n3) Solve for b. \n4) Quit the program. \n\nYour choice: ");
            while ( !menu.hasNextInt() ) 
            {    
                System.out.print("\nPlease select a number from 1-4");
                menu.next();
            }
            menu_choice = menu.nextInt();
            while ((1 <= menu_choice) && (menu_choice <= 4))
            {
                if (menu_choice == 1)
                {
                    present_y_package();
                    menu_choice = 0;
                }
                else if (menu_choice == 2)
                {    
                    present_m_package();
                    menu_choice = 0;
                }
                else if (menu_choice == 3)
                {    
                    present_b_package();
                    menu_choice = 0;
                } 
                else if (menu_choice == 4)
                {    
                    menu_choice = 0;
                    return;
                }
                else
                {
                    menu_choice = 0;
                    return;
                }
            }
        }    
    }   
}