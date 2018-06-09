package pixSort;

/**
 * Binary Insertion Sort, uses a binary search to insert items making this an in-place, n log(n) algorithm
 * 
 * @author: Michael Naples
 * @version: 2018.4.4
 */
public class BinaryInsertionSort
{
    int[] arr;
    int comps;
    int shifts;
    
    public void sort(int[] arr) {
        this.arr = arr;
        comps = 0;
        shifts = 0;
        for(int i = 1; i < arr.length; i++) {
            comps++;
            if(arr[i-1] > arr[i])   {
                //grab and store searching value
                int temp = arr[i];
                //perform binary search for the value
                int pos = binarySearch(i, temp);
                //shift the items over by 1 to make room for the value
                shifts++;
                for(int j = i; j > pos; j--) {
                    arr[j] = arr[j-1];
                }
                //drop value at appropriate position
                arr[pos] = temp;
            }
        }
    }
    
    private int binarySearch(int partition, int item)   {
        int left = 0;
        int right = partition;
        int mid = 0;
        boolean searching = true;
        while(searching)    {
            comps++;
            mid = (left+right) / 2;
            if(left >= right)   {
                searching = false;
            }
            else if(arr[mid] == item)  {
                searching = false;
            }
            else if(arr[mid] > item)  {
                right = mid;
            }
            else if(arr[mid] < item)    {
                left = mid + 1;
            }
        }
        return mid;
    }

    public int getComps()   {
        return comps;   
    }

    public int getShifts()  {
        return shifts;
    }
}
