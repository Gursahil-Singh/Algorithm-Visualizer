public class Selection extends Algorithm {
    @Override
    public void runSort(ArrayCreater array) {
        int len = array.arraySize();
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (array.getValue(j) < array.getValue(minIndex)) {
                    minIndex = j;
                }
            }
            array.swap(i, minIndex, 40);
        }
    }
}
