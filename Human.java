package lesson9.hw.human;
import java.io.Serializable;

public class Human implements Cloneable, Serializable{
    private String name;
    private String lastname;
    private String gender;
    private String profession;

    private int age;      //years
    private int height;     //cm.
    private int weight;   //kg.

    public Human(String name, String lastname, String gender, String profession, int age, int high, int weight)  {
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;

        this.profession = profession;
        this.age = age;
        this.height = high;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender)  {
        this.gender = gender;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int high) {
        this.height = high;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (age != human.age) return false;
        if (height != human.height) return false;
        if (weight != human.weight) return false;
        if (!name.equals(human.name)) return false;
        if (!lastname.equals(human.lastname)) return false;
        if (!gender.equals(human.gender)) return false;
        return profession.equals(human.profession);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + profession.hashCode();
        result = 31 * result + age;
        result = 31 * result + height;
        result = 31 * result + weight;
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Human) super.clone();
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", profession='" + profession + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}