public class Bubble extends Algorithm  {

    public void runSort(ArrayCreater array){
        for (int i = 0; i < array.arraySize() - 1 ; i++){
            for (int j = 0; j < array.arraySize()- i -1; j++){
                if(array.getValue(j)>array.getValue(j+1)){
                    int temp = array.getValue(j);
                    array.updateSingle(j, array.getValue(j+1), 5);
                    array.updateSingle(j + 1, temp, 5);
                }
            }
        }
    }

}
