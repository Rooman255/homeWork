package person;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable, Comparable<Person> {
    private String name;
    private int yearBirth;
    private int yearDeath;
    private Gender gender;
    private Person father;
    private Person mother;
    private List<Person> children = new ArrayList<>();

    public Person() {
    }
    public Person(String name, Person father, Person mother)
    {
        this();
        setName(name);
        this.father = father;
        this.mother = mother;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }
    public List<Person> getChildrenList() {
        return children;
    }
    public String getChildrenInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Дети: ");
        if (children.size() != 0) {
            sb.append(children.get(0).getName());
            for (int i=1; i < children.size();i++)
            {
                sb.append(", ");
                sb.append(children.get(i).getName());
            }
        }else {sb.append("нет");}
        return sb.toString();
    }

    public void addChild(Person child) {
        if(!(this.children.contains(child))){
        this.children.add(child);}
    }

    public String getFatherInfo() {
    String res = "Отец :";
    if (father != null) {
        res += father.getName();
    } else {
        return res + "неизвестен";}
    return res;
    }

    public String getMatherInfo()
    {
        String res = "Мать :";
        if (mother!=null)
        {
            res += mother.getName();
        }else{
            return res + "неизвестна";
        }
        return res;
    }
    public int getYearBirth() {
        return this.yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth=yearBirth;
    }

    public int getYearDeath() {
        return this.yearDeath;
    }

    public void setYearDeath(int yearDeath) {
        this.yearDeath=yearDeath;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public String getInfo()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(getName());
        sb.append(", ");
        sb.append(getMatherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }
    public boolean equals(Object obj){
        if(this==obj){
          return true;
        }
        if(!(obj instanceof Person)){
            return false;
        }
        Person person = (Person) obj;
        return person.getName().equals(getName());

    }
    public String toString() {
        return getName();
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.getName());
    }
}