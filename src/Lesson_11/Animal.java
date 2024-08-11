public class Animal {
    String name;
    public static int counter = 0;
    public Animal(String name) {
        this.name = name;
        counter++;
    }
    public Animal() {
        counter++;
    }
    public void run(int dist) {
        System.out.println(name + " runs " + dist + " m");
    }
    public void swim(int dist) {
        System.out.println(name + " swims " + dist + " m");
    }
    public static void main(String[] args) {
        Cat[] catArr = {
                new Cat("Alice"),
                new Cat("Bob"),
                new Cat("Charlie")
        };
        Bowl bowl = new Bowl();
        catArr[0].eat();
        catArr[1].eat();
        catArr[2].eat();
        System.out.println(catArr[0].isNotHungry + "," + catArr[1].isNotHungry + "," + catArr[2].isNotHungry);
        bowl.fillBowl();
    }
}
