package epam.view;

import java.util.ArrayList;
import java.util.Scanner;


public class GameView {
    private Scanner sc;
    public  GameView(){
        sc = new Scanner(System.in);
    }

    public void showTryWelcomeMsg(int tryNumber,int[] tryInterval ){
        System.out.printf("Попытка № %d \n",tryNumber);
        System.out.printf("Ведите число в интервале [ %d , %d ]  или q  для окончания игры : ",tryInterval[0],tryInterval[1]);
    }
    public Integer readConsoleInput(){
        Integer result;
        if (sc.hasNext("q")) return null;

        while (true) {

            if (!sc.hasNextInt()) {
                sc.next();
                System.out.println("Должно быть число ");
                continue;
            }
            result  = sc.nextInt();
            break;
        }
        return result;
    }
    public void showFinishedMsg(){
        System.out.println("Игра окончена. Интервал уменьшился до одного числа");
    }
    public  void showQuitMsg(){
        System.out.println("Игра прервана ..");
    }
    public void showWinMsg(){
        System.out.println("Поздравляю.Вы угадали");
    }
    public void showNumber(int number){
        System.out.println("Загаданное число :" + number);
    }
    public void showHistory(ArrayList gameLog) {
        System.out.println("История ходов :");
        for (int i = 0; i < gameLog.size(); i++) {
            System.out.printf(" Попытка №%d число - %d \n", i + 1, gameLog.get(i));

        }
    }
    public void inputOutOfRangeMsg(int left,int right){
        System.out.println("Должно быть число в диапазоне: [" + left + "," + right + "]");
    }
}
