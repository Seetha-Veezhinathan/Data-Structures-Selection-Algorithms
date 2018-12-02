import java.util.Random;
import java.util.ArrayList;
import java.io.IOException;

public class Select2 {
	int array[], array1[];
	int COMPCOUNT = 0;

    // Method to initialize the call to select1 functionality
	public void Select2Init(int[] array, int n) 
	{
	    array1 = new int[n];
        System.arraycopy( array, 0, array1, 0, array.length );
        int x = array.length/2;
	    quickSelect(array, 0, array.length - 1, x);        
	}
	   
   // Quick Select Method
    public void quickSelect(int[] array, int low, int high, int k)
    {
    	int n = array.length;
    	int x = k;
    	// If number of elements less than 25 perform Insertion Sort
    	if ((high - low) < 25) 
    	{
            int b[] = new int[high - low];
            b = CopyTheArray(array, low, high);
            ISort(b, b.length - 1);
            System.out.println("SELECT2: " + "Number of Elements 'n':"+n +   ",  k :"+x+  ",  A[KSmallest] : " +array[k]+  ",  Number of Key-Comparisons : " + COMPCOUNT);
            return;
        }
    	
    	int left = low;
        int right = high;
        int pivot = array[low + (high - low) / 2];        
        int r = high;
        
        /* Divide and compare the pivot */
        while (left <= right) 
        {
        	while (array[left] < pivot && Compare(left, pivot))
            {
            	left++;
            }
                
        	while (array[right] > pivot && Compare(pivot, right))
            {
            	right--;
            }
                
            if (left <= right) 
            {
            	swap(array,left,right);
                left++;
                right--;
            }
        }	
        swap(array,left,r);
        if (CompareE(r, k)) 
        {
        	System.out.println("SELECT2: " + "Number of Elements 'n':"+n +   ",  k :"+x+  ",  A[KSmallest] : " +array[k]+  ",  Number of Key-Comparisons : " + COMPCOUNT);
        } else if (k < r) 
        {
           	quickSelect(array, left, r - 1, k);
        } else 
        {
           	quickSelect(array, r + 1, right, k);
        }

    }

    public int[] CopyTheArray(int[] array, int start, int end) {
        int size = end - start + 1;
        int[] b = new int[size];
        for (int i = start; i <= end; i++) {
            b[i - start] = array[i];
        }
        return b;
    }

    // Swap Functionality
    public  void swap(int[] array, int i, int j) 
	{
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
    
    // Method to perform Insertion Sort
    public void ISort(int[] array, int n) 
    {
        if (n == 0) 
        {
            return;
        }
        ISort(array, n - 1);
        int j = n - 1;
        while (j > 0 && Compare(array[j], array[j - 1])) 
        {
            int temp = array[j - 1];
            array[j - 1] = array[j];
            array[j] = temp;
            j--;
        }
    }
    
    public boolean Compare(int x, int y) 
    {
        COMPCOUNT++;
        return x <= y;
    }

    public boolean CompareE(int x, int y) 
    {
        COMPCOUNT++;
        return x == y;
    }
 
    // INIT method to initialize all the 'n' values
    public void init_Start() 
    {
    	int n = 10000;
    	array = new int[n];
    	Random rand = new Random();
    		for (int i = 0; i < n; i++) 
    		{
    			array[i] = rand.nextInt(n);
    		}
    	Select2Init(array, n);
    	n = 100000;
    	array = new int[n];
    		for (int i = 0; i < n; i++) 
    		{
    			array[i] = rand.nextInt(n);
    		} 
    	Select2Init(array, n);
    	n = 1000000;
    	array = new int[n];
    		for (int i = 0; i < n; i++) 
    		{
    			array[i] = rand.nextInt(n);
    		}
    	Select2Init(array, n);
    }  
	
    public static void main(String[] args) 
    {
    	
    	Select2 s = new Select2();
    	s.init_Start();

    }
}