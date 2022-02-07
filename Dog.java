import java.io.Serializable;
import java.util.Objects;

public class Dog implements Serializable {
/************************************** INSTANCE VARS ****************************************/
    // Define a constant to keep track of
    // serial version unique id
    private static final long serialVersionUID = 1020190924L;
    private String mName;
    private String mBreed;
    private double mAge;
    
/************************************** CONSTRUCTORS ****************************************/
    public Dog(String name, String breed, double age) {
        mName = name;
        mBreed = breed;
        mAge = age;
    }

    public Dog(Dog aDog){
        if(aDog == null){
            System.out.println("Fatal error!");
            System.exit(0);
        }
        mName = aDog.mName;
        mBreed = aDog.mBreed;
        mAge = aDog.mAge;
    }
/************************************** OTHER METHODS ****************************************/
public double ageInHumanYears(){
    double ageInHumanY = 0;
    if(mAge <= 2){
        ageInHumanY = mAge * 11;

    }
    else{
        ageInHumanY = (mAge -2) * 5 + 22;
    }
    return ageInHumanY;

}

/************************************** GETTERS ADN SETTERS ****************************************/
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getBreed() {
        return mBreed;
    }

    public void setBreed(String breed) {
        mBreed = breed;
    }

    public double getAge() {
        return mAge;
    }

    public void setAge(double age) {
        mAge = age;
    }
/************************************** EQUALS() toSTRING() hashCODE() ****************************************/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Double.compare(dog.mAge, mAge) == 0 &&
                Objects.equals(mName, dog.mName) &&
                Objects.equals(mBreed, dog.mBreed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mName, mBreed, mAge);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "mName='" + mName + '\'' +
                ", mBreed='" + mBreed + '\'' +
                ", mAge=" + mAge +
                '}';
    }
}
