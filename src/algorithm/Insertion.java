package algorithm;
import main.ArrayCreater;

public class Insertion extends Algorithm {
    @Override
    public void runSort(ArrayCreater array){
        for (int i = 0; i < array.arraySize(); i++) {
            int key = array.getValue(i);
            int j = i - 1;
            while (j >= 0 && array.getValue(j) > key) {
                array.updateSingle(j + 1, array.getValue(j), 5);
                j--;
            }
            array.updateSingle(j + 1, key, 2);
        }
    }
}
