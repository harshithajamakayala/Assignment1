package task1;

public class ArrayWork {
int arr[] = {15,19,6,3,74,84,62,100,20,38,415,3,74,16,15,9,650,67};
	
	
	public void getRepeatedValues()
	{
		// code to return arr[] containing only duplicate values, such as 15,3 etc
		System.out.println("Repeated values in given array: ");
		 for(int i = 0; i < arr.length; i++) {  
	            for(int j = i + 1; j < arr.length; j++) {  
	                if(arr[i] == arr[j])  
	              

	                	System.out.print(arr[j]+" ");
	               
	                
	                }
	            
		 }
	}
	
	public void getSum()
	{
		// code to return the total of all values;
		int sum = 0;  
  
        for (int i = 0; i < arr.length; i++) {  
           sum = sum + arr[i];  
        }  
        System.out.println("");
        System.out.println("Sum of all the values of an array: " + sum);  
	}
	
	public void getUniqueValues()
	{
		// code to return arr[] containing all unique values only;
		int n=arr.length;
		 System.out.println("Unique values of an array: ");
		 for (int i = 0; i < n; i++)
	        {
	            
	            int j;
	            for (j = 0; j < i; j++)
	            if (arr[i] == arr[j])
	                break;
	     
	            
	            if (i == j)
	            System.out.print( arr[i] + " ");
	        }
	}
	

}


