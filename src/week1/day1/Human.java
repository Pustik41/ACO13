package week1.day1;

/**
 * Created by zhabenya on 21.05.16.
 */
public class Human {

//  fields

    private String name;
    private int age;
    private String sex;
    private int weight;
    private int height;

    public Human(String name, int age, String sex, int weight, int height){

        this.name = name;
        this.age = age;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public  String getName(){
        return name;
    }

    public void setName(String name){
        if(name == null || name.equals("")) return;
        this.name = name;
    }


    public String asString(){

        return String.format("Name - %s, age - %d, height - %d", name, age, height);
    }

}
