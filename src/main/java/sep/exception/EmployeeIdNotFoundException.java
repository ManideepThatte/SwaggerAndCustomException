package sep.exception;

public class EmployeeIdNotFoundException extends Exception{

    public  EmployeeIdNotFoundException(){}

    public EmployeeIdNotFoundException (String mesg){
        super(mesg);
    }

}
