package ClassWork.week2.day1.Inheart;

/**
 * Created by zhabenya on 28.05.16.
 */
public class Manager extends  Employee {

    private Employee[] employee;

    public Manager(int age, String name, String surname, Employee[] employee) {
        super(age, name, surname);
        this.employee = employee;
    }

    @Override
    public void work() {

        System.out.println("I`m do manager work");

        for (Employee emp: employee) {
            if(emp != null) {
                emp.work();
                if(emp instanceof Coder){
                    Coder tmp = (Coder) emp;
                    tmp.writeCode();
                }
            }

        }

    }
}
