package epam.view;

import java.util.ArrayList;

public class GameView {

    public static final String MORE_MSG = "Больше ...";
    public static final String LESS_MSG = "Меньше ...";
    public static final String WRONG_RANGE_MSG_D_D = "Должно быть число в диапазоне: [%d,%d] \n";
    public static final String TRY_N_MSG = " Попытка №%d число - %d \n";
    public static final String PRINT_HISTORY_MSG = "История ходов :";
    public static final String NUMBER_MSG = "Загаданное число :";
    public static final String GREETINGS_MSG = "Поздравляю.Вы угадали";
    public static final String GAME_BREACK_MSG = "Игра прервана ..";
    public static final String GAME_FINISHED_MSG = "Игра окончена. Интервал уменьшился до одного числа";
    public static final String MUST_BE_NUMBER = "Должно быть число. Повторите ввод :";
    public static final String TRY_MSG = "Ведите число в интервале [%d,%d]  или q  для окончания игры : ";
    public static final String TRY_COUNT = "Попытка № %d \n";


    public void showTryWelcomeMsg(int tryNumber,int left,int right ){
        printMsg(TRY_COUNT,tryNumber);
        printMsg(TRY_MSG,left,right);
    }

    public void showFinishedMsg(){
        printMsg(GAME_FINISHED_MSG);
    }

    public  void showQuitMsg(){
        printMsg(GAME_BREACK_MSG);
    }

    public void showWinMsg(){
        printMsg(GREETINGS_MSG);
    }

    public void showNumber(int number){
        printMsg(NUMBER_MSG + number);
    }

    public void showHistory(ArrayList gameLog) {
        printMsg(PRINT_HISTORY_MSG);
        for (int i = 0; i < gameLog.size(); i++) {
            printMsg(TRY_N_MSG, i + 1, (int)gameLog.get(i));

        }
    }
    public void inputOutOfRangeMsg(int left,int right){
        printMsg(WRONG_RANGE_MSG_D_D,left,right);
    }

    public void showLessMsg(){
        printMsg(LESS_MSG);
    }

    public void showMoreMsg(){
        printMsg(MORE_MSG);
    }

    public void showMustBeNumer(){
        printMsg(MUST_BE_NUMBER);
    }

    public void printMsg(String str){
        System.out.println(str);
    }

    public void printMsg(String str,int arg){
        System.out.printf(str,arg);
    }

    public  void printMsg(String str,int arg1,int arg2){
        System.out.printf(str,arg1,arg2);
    }

}
