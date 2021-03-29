package hwArray;
//Создайте массив из чётных чисел [2;20] и выведите элементы массива
//        в консоль в обратном порядке (20 18 16 ... 4 2)
public class ArrayCountable {
    public static void main(String[] args) {

        int [] countableNum = new int[10];
        for (int i = 0, num = 2; num <= 20; num+=2, i++ ) {
            countableNum[i] = num ;
        }
        int length = countableNum.length ;
        for (int i = length-1; i >=0 ; i--) {
            System.out.println(countableNum[i]);
        }
    }
}
