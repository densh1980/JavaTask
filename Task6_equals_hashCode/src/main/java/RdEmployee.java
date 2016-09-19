/**
 * Created by Denys_Shmyhin on 9/19/2016.
 */
public class RdEmployee extends EpamEmployee {
    private RdDepCategory category;

    public RdEmployee(String name, int age, String position, double sallary, RdDepCategory category) {
        super(name, age, position, sallary);
        this.category = category;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        RdEmployee that = (RdEmployee) obj;

        return category == that.category;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + category.hashCode();
        return result;
    }
}
