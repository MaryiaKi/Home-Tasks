public class Employee {
    public static void main(String[] args) {
        Employee[] employeesArray = new Employee[5];
        employeesArray[0] = new Employee("Ivanov Ivan", "engineer", "ivanov@mailbox.com", 892312312, 3000, 30);
        employeesArray[1] = new Employee("Petrov Petr", "QA engineer", "petrov@mailbox.com", 892312313, 3100, 31);
        employeesArray[2] = new Employee("Sidorov Sidor", "manager", "sidorov@mailbox.com", 892312314, 3200, 32);
        employeesArray[3] = new Employee("Vladimirov Vladimir", "lead engineer", "vlavimirov@mailbox.com", 892312315, 3300, 33);
        employeesArray[4] = new Employee("Dmitriev Dmitriy", "developer", "dmitriev@mailbox.com", 892312316, 6000, 34);
        employeesArray[2].info();
    }
    private String name;
    private String jobTitle;
    private String email;
    private long phoneNumber;
    private int salary;
    private int age;
    public Employee(String name, String jobTitle, String email, long phoneNumber, int salary, int age) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }
    public void info() {
        System.out.println("ФИО: " + name + "; должность: " + jobTitle + "; email: " + email + "; телефон: " + phoneNumber + "; зарплата: " + salary + "; возраст: " + age);
    }
}

