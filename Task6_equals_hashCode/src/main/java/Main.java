import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        EpamEmployee ep1 = new EpamEmployee("Pupkin",25,"java",2000.01);
        EpamEmployee ep2 = new EpamEmployee("Pupkin",25,"java",2000.00);
        EpamEmployee ep3 = new RdEmployee("Pupkin",25,"java",2000.00,RdDepCategory.AUTOMATION_TESTING);
        System.out.println(ep1.equals(ep3));
        System.out.println(ep2.equals(ep3));
        System.out.println(ep3.equals(ep2));

        String[] asd = {"asd","zxc","qwe"};
        Arrays.stream(asd).map(s -> s + "dfgd")
                            .forEach(s -> {
                                System.out.println(s);
                            });


    }

}
