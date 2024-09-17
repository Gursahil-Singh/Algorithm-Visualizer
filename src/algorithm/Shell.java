package algorithm;
import main.ArrayCreater;

public class Shell extends Algorithm {
    @Override
    public void runSort(ArrayCreater array){
        for(int gap = array.arraySize()/2 ; gap>0; gap/=2){
            for (int i = gap; i < array.arraySize(); i++) {
                int j = i;
                while (j >= gap && array.getValue(j) < array.getValue(j-gap)) {
                    array.swap(j, j-gap, 8);
                    j-=gap;
                }
            }
        }
    }
}
