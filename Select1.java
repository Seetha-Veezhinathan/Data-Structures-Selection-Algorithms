import java.util.Random;
import java.util.ArrayList;
import java.io.IOException;

public class Select1 {
    int array[], array1[];
    int QCOUNT = 0;
    
    // Method to initialize the call to select1 functionality
    public void Select1Init(int[] array, int n) 
    {
        array1 = new int[n];
        System.arraycopy( array, 0, array1, 0, array.length );   
        SELECT1(array);
    }
    
    public void SELECT1(int[] array) 
    {
        int x = array.length/2;
        int n = array.length;
        QuickSort(array, 0, array.length - 1);
        System.out.println("SELECT1: " + "Number of Elements 'n':"+n +   ",  k :"+x+  ",  A[KSmallest] : " +array[0]+  ",  Number of Key-Comparisons : " + QCOUNT);
        
    }

    // Quick sort function 
    public  void QuickSort(int array[], int low, int high) 
    {
        int left = low;
        int right = high;
        int pivot = array[low + (high - low) / 2];
 
        /* Divide and compare the pivot */
        while (left <= right) 
        {
        	while (array[left] < pivot && QuickSortCompare(left, pivot))
            {
            	left++;
            }
                
        	while (array[right] > pivot && QuickSortCompare(pivot, right))
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
 
        /* recursively sort lower half */
        if (low < right)
            QuickSort(array, low, right);
        /* recursively sort upper half */
        if (left < high)
            QuickSort(array, left, high);
    }		

    // Swap Functionality
    public  void swap(int[] array, int i, int j) 
	{
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
    
    // Count the number of Comparisons
    public boolean QuickSortCompare(int x, int y) {
        QCOUNT++;
        return x <= y;
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
        Select1Init(array, n);
        n = 100000;
        array = new int[n];
        for (int i = 0; i < n; i++) 
        {
            array[i] = rand.nextInt(n);
        } 
        Select1Init(array, n);
        n = 1000000;
        array = new int[n];
        for (int i = 0; i < n; i++) 
        {
            array[i] = rand.nextInt(n);
        }
        Select1Init(array, n);
   }  
    
    public static void main(String[] args) {
       Select1 s = new Select1();
        s.init_Start();
     
    }
}

