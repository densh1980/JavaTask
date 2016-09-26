import java.util.Arrays;

public class Strategy {

    public static void main(String[] args) {
        // write your code here
        StratClient stratClient = new StratClient();
        int []a = {1,2,3,4,5,16,10};
        stratClient.setStrategy(new BubbleSort());
        stratClient.executeStrat(a);

        int []b = {2,6,3,8,4,9,0,9,8,67,5,55,777777};
    }
}

class StratClient{
    Sorting strategy;
    public void setStrategy(Sorting strategy){
        this.strategy = strategy;
    }
    public void executeStrat(int[]arr){
        strategy.sort(arr);
    }

}

interface Sorting{
    void sort(int[]arr);
}

class BubbleSort implements Sorting {
    public void sort(int[]arr){
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j]>(arr[j + 1])) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }

            if(!swapped)

                break;
        }
        System.out.println(Arrays.toString(arr));
    }
}
class InoutSort implements Sorting{
    public void sort(int[]arr){
        int counter=0;
        for(int i=1;i<arr.length-1;i++){
            for(int j=i; j>0 && arr[j-1]>arr[j];j--){
                counter++;
                int tmp=arr[j-1];
                arr[j-1]=arr[j];
                arr[j]=tmp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
