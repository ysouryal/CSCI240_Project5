// Honor Pledge: I pledge that I have neither given nor received any help on this assignment.

public class Employee {

    private String Job_ID;
    private String Employee_ID;
    private String FName;
    private String LName;
    protected int Rate;

    //constructor
    public Employee(){}

    public void setAttributes(String line)
    {
        String[] parts = line.split(",");//break the line into parts
        Job_ID= parts[0]; //assign name the first part
        Employee_ID= parts[1]; //assign Employee ID the first part
        FName= parts[2]; //assign Fname the first part
        LName= parts[3]; //assign Lname the first part
    }

    public String PrintRate()
    { //print the values of variables
        return String.format("ID: %-10s Name: %-20s Rate: %-10.2s",Employee_ID,FName+" "+LName,Rate);
    }
    public String PrintCheck(float Hours_Worked)
    { //print the values of variables
        return String.format("ID: %-10s Check Amount: %-10.2f",Employee_ID,Rate*Hours_Worked);
    }
}
