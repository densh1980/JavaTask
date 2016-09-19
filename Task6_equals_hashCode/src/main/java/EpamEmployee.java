import java.util.Optional;

/**
 * Created by Denys_Shmyhin on 9/19/2016.
 */

public class EpamEmployee {
    private String name;
    private int age;
    private String position;
    private  double sallary;

    public EpamEmployee(String name, int age, String position, double sallary) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.sallary = sallary;
    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//
//        EpamEmployee that = (EpamEmployee) obj;
//
//        if (age != that.age) return false;
//        if (Double.compare(that.sallary, sallary) != 0) return false;
//        if (!name.equals(that.name)) return false;
//        return position.equals(that.position);
//
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof EpamEmployee)) return false;

        EpamEmployee that = (EpamEmployee) obj;

        if (age != that.age) return false;
        if (Double.compare(that.sallary, sallary) != 0) return false;
        if (!name.equals(that.name)) return false;
        return position.equals(that.position);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + position.hashCode();
        temp = Double.doubleToLongBits(sallary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

}
