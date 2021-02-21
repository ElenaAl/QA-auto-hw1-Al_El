package tf.qa.automation;


public class Main {

    public static void main(String[] args) {

        int[] x = new int[]{8, 1, 4, 2, 20, 9, -5,500,-150};

        System.out.println("До сортировки");
        for (int i = 0; i < x.length; i++) {

            System.out.print(x[i] + " ");
        }

        int low = 0;
        int high = x.length - 1;

        tanosSort(x, low, high);

        System.out.println("\nПосле");
        for (int i = 0; i < x.length; i++) {

            System.out.print(x[i] + " ");
       }

    }

    public static void tanosSort(int[] array,int low,int high ) {

        if (array.length == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если нечего делить

        int sum = 0;
        int count = 0;
        int i = low, j = high;
        int i2=0;
        for (i2 = low; i2 < high; i2++) {
            sum += array[i2];
            count++;
        }
        int average = sum / count;


        while (i <= j) {
            while (array[i] < average) {
                i++;

            }

            while (array[j] > average) {
                j--;
            }

            if (i <= j) {

                int buffer = array[i];
                array[i] = array[j];
                array[j] = buffer;
                i++;
                j--;
            }
        }

        if (low < j)
            tanosSort(array,low, j);

        if (high > i)
            tanosSort(array, i, high);

        }

    }
