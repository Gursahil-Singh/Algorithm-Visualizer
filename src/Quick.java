public class Quick extends Algorithm {
    @Override
    public void runSort(ArrayCreater array) {
        int start = 0;
        int end = array.arraySize() - 1;
        quickSort(array, start, end);
    }
    private void quickSort(ArrayCreater array, int start, int end){
        if(end<=start)return;

        int pivot = partition(array,start,end);
        quickSort(array, start, pivot-1);
        quickSort(array, pivot+1, end);
    }
    private static int partition(ArrayCreater array, int start, int end){
        
        int pivot = array.getValue(end);
        int i = start-1;
        for(int j = start; j<=end-1 ; j++){
            if(array.getValue(j)<pivot){
                i++;
                int temp = array.getValue(i);
                array.updateSingle(i, array.getValue(j), 10);
                array.updateSingle(j, temp, 10);
            }

        }
        i++;
        int temp = array.getValue(i);
        array.updateSingle(i, array.getValue(end), 10);
        array.updateSingle(end, temp, 10);
        return i;
    }
}
