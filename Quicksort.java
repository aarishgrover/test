import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Quicksort {
	int array[];
	int counter =0;
public int[] qs1(int[] array, int p, int r) 
{
	if(p<r)
		{
		//counter++;	
		int q = partition(array,p,r);
			qs1(array,p,q-1);
			qs1(array,q+1,r);
		}
	return array;
}
public int partition(int[] a, int p, int r) {
		int x =a[r];
		int i =p-1;
		for(int j=p;j<=r-1;j++)
		{
			counter++;
			if(a[j]<=x)
			{
				i++;
				swap(a,i,j);
			}
		}
		swap(a,i+1,r);

		return i+1;	
	}
public void swap(int[] a, int i, int j) {
        // TODO Auto-generated method stub
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
public void reset() 
{
		array = null;
		counter=0;
}
public int[] populate(int i) 
{
	System.out.println(i);
	int array1[]=new int[i];
	for(int x=0;x<i;x++)
		{
			array1[x] = ThreadLocalRandom.current().nextInt(0, i);
		}
	return array1;
}

public int[] qs2(int[] array1, int p, int r) 
{
		
		if(p<r)
		{
			int i = array1.length % 2 == 0 ? array1.length/2 : (array1.length + 1)/2 ;
			int median_index = medianofmedian(array1);	
			swap(array1,median_index,r);
			array1=qs1(array1,p,r);
		}
		return array1;
	
}
public int medianofmedian(int[] array)
{
	int i;
	
	if (array.length < 5)
	{
		return medianofpartition(array, 0, array.length-1);
	}

	for(i =0;i<array.length;i=i+5)
	{
		int last = i+4;
		if (last > array.length -1)
		{
			last = array.length-1;
		}
		
		int partition_median = medianofpartition(array, i, last);
		swap(array, partition_median, i/5);
	}
	return randomisedselect(array, 0, array.length/5, array.length/10);
	
}

public int medianofpartition(int[] array, int p, int r)
{
	//insertion sort code
	int j;                     // the number of items sorted so far
    int key;                // the item to be inserted
    int i;  

    for (j = p; j < (r-p+1); j++)    // Start with 1 (not 0)
   {
          key = array[ j ];
          for(i = j - 1; (i >= 0) && (array[ i ] < key); i--)   // Smaller values are moving up
         {
                array[ i+1 ] = array[ i ];
         }
        array[ i+1 ] = key;    // Put the key in its proper location
    }
	
	return (r-p+1) % 2 == 0 ? (r-p+1)/2 : (r-p+1)/2 ;
	
}
public int randomisedselect(int[] array, int p, int r, int i) {
		
		if (p==r)
		{
			return p;
		}
		int q = randomisedpartition(array,p,r); 
		int k = q-p+1;
		counter++;
		if(i==k)
		{			
			return q;
		}
		else if(i<k)
		{
			return randomisedselect(array, p, q-1,i);
		}
		else
			return randomisedselect(array, (q+1),r,i-k);
	}

	public int randomisedpartition(int[] array, int p, int r) {
		int i = ThreadLocalRandom.current().nextInt(p, r);
		swap(array, r, i);
		return partition(array, p,r);
	}
	public long getPartCount() {
		// TODO Auto-generated method stub
		return counter;
	}

}