import java.util.Random;
import java.util.ArrayList;
import java.io.IOException;

public class Select3 {
	
	int array[];
	int COMPCOUNT = 0;
    int key=0, j=0, temp=0;
	
/* Method to calculate Pivot Value */
	
	public int calculatePivotValue(int array[], int low ,int high)
	{
		
		// If number of elements less than 25, return the actual median value
		if ((high - low) < 25) 
    	{
             ISort(array);
             return array[array.length/2];
        }
		
		//If number of elements greater than 25,divide the array in to sub arrays of size 5 for 'n' elements
		
	       int [] medians = new int[(int)Math.ceil((double)(high-low+1)/5)];
	       int medianIndex = 0;
	       int temp_arr[] = null;
	   
	       while(low<=high)
	       {
	    	   temp_arr = new int[Math.min(5, high-low+1)];
	    	   for(int j=0; j< temp_arr.length && low<= high; j++)
	           {
	               temp_arr[j]=array[low];
	               low++;
	           }
	   			ISort(temp_arr);
	   	        medians[medianIndex]=temp_arr[temp_arr.length/2];
	   	        medianIndex++;
	   		}
	        return calculatePivotValue(medians, 0, medians.length-1);	       
	}

	   public  void CalculateMedian(int [] array)
	   {
	       int median = CalculateMedofMedian(array, (array.length/2)+1, 0, array.length-1);
	   }
	   
	   public int CalculateMedofMedian(int[] array, int k, int left, int right)
	   {

	       if(left==right)
	       return array[left];

	       int m = quickSelect(array, left, right);
	       int length = m-left+1;
	       if(length == k)
	       {
	    	   return array[m];
	       }
	           
	       if(length > k)
	       {
	    	   return CalculateMedofMedian(array, k,left, m-1);
	       }
	       else	       
	       {
	    	   return CalculateMedofMedian(array, k-length, m+1, right);
	       }
	           
	   }
	 
	   // Sorting the pivot with Quick Select Functionality
	   public int quickSelect(int[] array, int left, int right)
	   {
		   int pivot = calculatePivotValue(array, left, right);
		   
		   /* Divide and compare the pivot */
	        while (left < right) 
	        {
	        	while (array[left] < pivot && Compare(array[left], pivot))
	            {
	            	left++;
	            }
	                
	        	while (array[right] > pivot && Compare(pivot, array[right]))
	            {
	            	right--;
	            }
	                
	        	if(array[left]==array[right])
	                left++;
	            else if(Compare(left, right))
	            {
	            	swap(array,left,right);
	            }
	        }
	        return right;
	   }

	   
	    // Swap Functionality
	public  void swap(int[] array, int i, int j) 
	{
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	    
	//Insertion Sort Logic	
    public void ISort(int[] arr) 
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;

            while (j>=0 && Compare(arr[j], arr[i - 1]))
            {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                j--;
            }
        }
    }
	
    public boolean Compare(int x, int y) 
    {
    	COMPCOUNT++;
        if( x <= y)
        	return true;
        else
        	return false;
    }
    
    
    public static void main(String[] args)
    {
        int n = 10000;
        int array[] = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) 
        	{
            	array[i] = rand.nextInt(n);
        	}
        Select3 s3=new Select3();
        int k = array.length/2;
        s3.CalculateMedian(array);
        System.out.println("SELECT3: " + "Number of Elements 'n':"+n +   ",  k :"+k+  ",  A[KSmallest] : " +array[k]+  ",  Number of Key-Comparisons : " + s3.COMPCOUNT);
       
        n = 100000;
    	array = new int[n];
    		for (int i = 0; i < n; i++) 
    		{
    			array[i] = rand.nextInt(n);
    		} 
    	s3.CalculateMedian(array);
    	k = array.length/2;
    	System.out.println("SELECT3: " + "Number of Elements 'n':"+n +   ",  k :"+k+  ",  A[KSmallest] : " +array[k]+  ",  Number of Key-Comparisons : " + s3.COMPCOUNT);
        
        n = 1000000;
    	array = new int[n];
    		for (int i = 0; i < n; i++) 
    		{
    			array[i] = rand.nextInt(n);
    		} 
    	s3.CalculateMedian(array);
    	k = array.length/2;
    	System.out.println("SELECT3: " + "Number of Elements 'n':"+n +   ",  k :"+k+  ",  A[KSmallest] : " +array[k]+  ",  Number of Key-Comparisons : " + s3.COMPCOUNT);
    }

}
