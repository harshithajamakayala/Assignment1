package task1;
import java.util.Scanner;

public class TaxCalculator
{
   public static void main(String args[])
   {
	   
	   Scanner sc = new Scanner(System.in);
	   
	System.out.print("Enter Salary :- ");
	int salary = sc.nextInt();
    float tax=1;
    float HRA;
    float DA;
    HRA=0.15f*salary;
    DA=0.60f*salary;
    
	int taxRate = 0;
	if (salary<=500000) {
		taxRate=0;
		tax=(float)(salary*0);
	}
	else if(salary>=500001 && salary<=1000000)
	{
		taxRate = 20;
		tax = (float)(salary * 0.20);
	}
	else if (salary>1000000) {
		taxRate = 30;
		tax = (float)(salary * 0.30);
		
	}
	int Insalary=salary-(int)tax;
	
	System.out.println("The HRA for salary="+HRA);
	System.out.println("The DA for salary="+DA);
	System.out.println("the tax rate="+taxRate);
	System.out.println("The In hand salary="+Insalary);
	
   }
}

