import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args){
        // Call the quicksort method
        int[] myArray = new int[]{1,3,4,2,5,6};
        int low = 0;
        int high = myArray.length - 1;
        quicksort(myArray, low, high);
        System.out.print(Arrays.toString(myArray));
    }

    private static void quicksort(int[] array, int lowIndex, int highIndex){
        // To know when the recursion is finished
        if(lowIndex >= highIndex){
            return;
        }

        // Pivot is the number that is used to sort the array
        // Find the median
        // swap the high index with the median
        int middle = array.length / 2;
        int medSum = lowIndex + highIndex + middle;
        int median = medSum / 3;
        int pivot = array[median];
        swap(array, median, highIndex);

        // leftPointer is the number that checks form the left of the array, and rightPointer is the number that checks the array from the right.
        int leftPointer = lowIndex;
        int rightPointer =highIndex;

        // Create loop that moves the left and right pointers toward each other.
        while(leftPointer < rightPointer){

            // Create another loop that moves the left pointer towards the right pointer or a number that is bigger then the pivot.
            while(array[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }

            // Create another loop that moves the right pointer towards the left pointer or a number smaller than or equal to the pivot.
            while(array[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, highIndex);

        // Recursive call so that both sides of the pivot are sorted
        quicksort(array, lowIndex, leftPointer - 1);
        quicksort(array, leftPointer + 1, highIndex);
    }

    private static void swap(int[] array, int index, int index2){
        //This is used to swap items in the array.
        int temp = array[index];
        array[index] = array[index2];
        array[index2] = temp;
    }
}
