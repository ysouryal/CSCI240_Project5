// Honor Pledge: I pledge that I have neither given nor received any help on this assignment.

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;
public class Driver {

    public static void main (String [] args) {
        //Employee  Test= new Pharmacy_Manager();
        int input1 = 0; //input of first menu
        int input2 = 0; //input of second menu
        float HWorked = -1; //hours employees worked
        File file = new File("employees.txt"); //create a file of employees
        ArrayList<Employee> List = new ArrayList<Employee>(); //Array list to hold the employee objects

        System.out.println("1.Load Employee (From FIle)" + "\n" + "2.Exit Program"); //menu printing
        Scanner reader = new Scanner(System.in); //read input 1 from user using a scanner object
        input1 = reader.nextInt(); //take the input
        if (input1==2) //if user inputs 2 in the first menu
        {
            System.out.println("Exiting Program");
            reader.close(); //close reader

        }
        //if statement for the 1st menu consisting of 2 options
        while (input1 != 2)
        {
            if (input1 == 1) //if user inputs 1, load the employees and create the array
            {
                try {
                    Scanner stri = new Scanner(file); //read the file
                    String line = stri.nextLine(); // Gets the first line in the file.
                    //while loop to iterate through the file line by line
                    while (stri.hasNextLine()) {
                        line = stri.nextLine();
                        String[] parts = line.split(","); //splitting the line into parts
                        //If statements to identify the ID and the type of employee to get the right Hourly rate for him/her
                        if (parts[0].equals("1")) {
                            Employee PManager = new Pharmacy_Manager(); //Pharmacy manager object of type Employee
                            PManager.setAttributes(line); //setting attributes of Pharmacy Manager
                            List.add(PManager); //adding Pharmacy manager object to array
                        } else if (parts[0].equals("2")) {
                            Employee P = new Pharmacist(); //Pharmacist object of type Employee
                            P.setAttributes(line); //setting attributes of Pharmacist
                            List.add(P); //adding Pharmacist object to array
                        } else if (parts[0].equals("3")) {
                            Employee Tech = new Technician();//Technician object of type Employee
                            Tech.setAttributes(line); //setting attributes of Pharmacist
                            List.add(Tech);
                        } else if (parts[0].equals("4")) {
                            Employee STech = new Senior_Technician(); //Senior Technician object of type Employee
                            STech.setAttributes(line); //setting attributes of Pharmacist
                            List.add(STech);
                        } else {
                            System.out.print("Employee Unrecognizable");
                        }
                    }
                    stri.close();
                } catch (IOException ex) {
                    System.err.println(ex); //handling the IO exception
                    System.out.println("Please make sure the file exists then retry");
                }
                while (input2 != 4) //while loop that exits if user presses on 4, otherwise do other tasks
                {
                    System.out.println("1. Print Employee Information" + "\n" + "2. Enter Hours Worked" + "\n" + "3. Calculate Paychecks" + "\n" + "4. Exit program");
                    Scanner reader2 = new Scanner(System.in); //Scanner Object for switch input
                    Scanner number = new Scanner(System.in); //Scanner object for hours worked
                    input2 = reader2.nextInt(); //taking input
                    switch (input2) {
                        case 1:
                            //Advanced For loop that goes through the entire array and prints every object.
                            for (Employee temp : List) {
                                System.out.println(temp.PrintRate());
                            }
                            break;
                        case 2:
                            System.out.println("Please enter the number of hours worked now"); //takes the number of hours worked
                            HWorked = number.nextFloat();

                            break;
                        case 3:
                            if (HWorked == -1) { //if statement to handle pressing 3 before inputing hours worked
                                System.out.println("Please enter the hours worked though option2 first");
                            } else {
                                for (Employee temp : List) { //Advanced for loop to print the checks
                                    System.out.println(temp.PrintCheck(HWorked));
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Goodbye");
                            input1=2; //exit big loop
                            reader2.close(); //close input menu input
                            number.close(); //close hours worked scanner
                            break;
                        default: //handles inputs >4
                            System.out.println("Wrong Input, please choose from 1-4");
                            break;
                    }
                }
            }

            else{
                System.out.println("Wrong Input, Please retry");
                 System.out.println("1.Load Employee (From FIle)" + "\n" + "2.Exit Program"); //menu printing
                input1 = reader.nextInt(); //take the input
                if (input1==2) //if user inputs 2 in the first menu
                {
                    System.out.println("Exiting Program");
                    reader.close(); //close reader

                }
                }
        }
    }
}
