import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("/********************* Array Index Out of Bounds *************************/");

        try {
            int arrayNumber[] = new int[5];
            arrayNumber[10]=53;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println ("ArrayIndexOutOfBounds Exception occurred");
            System.out.println ("System Message: " +e);
        }

        System.out.println("/********************* Number Format Exception *************************/");

        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a String ");
            String stringToNumber = input.nextLine();
            Integer.parseInt(stringToNumber);
        }catch (NumberFormatException e){
            System.out.println("Number Format Exception"+e);
        }

        System.out.println("/********************* File Not Found Exception *************************/");

        String path = "C:/Users/hafss/OneDrive/Bureau/Text/";
        try{
            BufferedReader bufferedReader= new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Not found exception : "+e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("/********************* Custom Exception *************************/");

        Scanner input1 =new Scanner(System.in);

        try {
            System.out.print("Enter a number between 1 and 100: ");
            int userInput = input1.nextInt();

            if (userInput < 1 || userInput > 100) {
                throw new CustomException("Invalid input. Please enter a number between 1 and 100.");
            }

        } catch (CustomException e) {

            System.out.println("Custom Exception: " + e.getMessage());

        } catch (Exception e) {

            System.out.println("An unexpected error occurred: " + e.getMessage());

        }


        System.out.println("/********************* NullPointerException *************************/");

        String check = null;
        try {
            int lenght = check.length();
            System.out.println(lenght);
        }catch (NullPointerException e){
            System.out.println("NullPointerException" + e.getMessage());
        }



        System.out.println("/********************* User Input Validation *************************/");

           Scanner scanner = new Scanner(System.in);
           int inputNumer;
           while (true){
               try {
                   System.out.println("Enter a Positive Number");
                   inputNumer = scanner.nextInt();
                   if (inputNumer>0)
                       break;
                   else
                           System.out.println("Invalid : Negative Number");
               }catch (Exception e){
                   System.out.println("Pleas: Enter a Positive Number");
                   scanner.next();
               }
           }
           System.out.println("the Positive Number is : "+inputNumer);

        System.out.println("/********************* Try-With-Resources *************************/");
        String path1 = "C:/Users/hafss/OneDrive/Bureau/text";

        try (BufferedReader reader = new BufferedReader(new FileReader(path1))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("/********************* Multiple Exceptions *************************/");

        try {
            int result = divide(10, 0);
            System.out.println("Result of division: " + result);

        }catch (ArithmeticException e){
            System.out.println("ArithmeticException : "+e.getMessage());

        }


        try {
                int[] array = {1, 2, 3};
                int value = accessArrayElement(array, 5);
                System.out.println("Value at index 5: " + value);
        }catch (ArrayIndexOutOfBoundsException ex){
                System.out.println(ex.getMessage());
        }


        System.out.println("/****************** Unchecked Exception ****************/");
        try {
            String nullString = null;
            int length = nullString.length();

            System.out.println("Length of the string: " + length);

        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            System.out.println("This code is always executed, whether an exception occurs or not.");
        }

    }


    private static int accessArrayElement(int[] array, int index) {
        return array[index];
    }
    private static int divide(int numerator, int denominator) {
        return numerator / denominator;
    }

}