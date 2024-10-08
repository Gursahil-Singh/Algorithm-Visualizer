package algorithm;
import main.ArrayCreater;

public class Merge extends Algorithm{
    private long getDelay = 10;

    private int[] getSubArray(ArrayCreater array, int begin, int size) {
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = array.getValue(begin + i);
        }
        return arr;
    }
    
    private void merge(ArrayCreater array, int left, int middle, int right) {

        int leftSize = middle - left + 1;
        int rightSize = right - middle;
        
        int leftArray[]  = getSubArray(array, left, leftSize);
        int rightArray[] = getSubArray(array, middle + 1, rightSize);
        
        int i = 0, j = 0, k = left;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                array.updateSingle(k, leftArray[i], getDelay);
                i++;
            }
            else {
                array.updateSingle(k, rightArray[j], getDelay);
                j++;
            }
            k++;
        }
        
        while (i < leftSize) {
            array.updateSingle(k, leftArray[i], getDelay);
            i++;
            k++;
        }
        while (j < rightSize) {
            array.updateSingle(k, rightArray[j], getDelay);
            j++;
            k++;
        }
    }
    
    private void mergeSort(ArrayCreater array, int left, int right) {
        if (left < right) {
            int middleIndex = (left + right) / 2;
            
            mergeSort(array, left, middleIndex);
            mergeSort(array, middleIndex + 1, right);
            
            merge(array, left, middleIndex, right);
        }
    }
    
    @Override
    public void runSort(ArrayCreater array) {
        int left = 0;
        int right = array.arraySize() - 1;
        mergeSort(array, left, right);
    }
}
