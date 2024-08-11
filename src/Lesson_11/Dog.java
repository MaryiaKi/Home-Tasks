public class Dog extends Animal {
    int maxRunDistance = 500;
    int maxSwimDistance = 10;
    public Dog(String name) {
        this.name = name;
    }
    @Override
    public void run(int dist) {
        if (dist <= maxRunDistance) {
            System.out.println(name + " runs " + dist + " m");
        }
        else {
            System.out.println("Impossible distance!");
        }
    }
    @Override
    public void swim(int dist) {
        if (dist <= maxSwimDistance) {
            System.out.println(name + " runs " + dist + " m");
        }
        else {
            System.out.println("Impossible distance!");
        }
    }
}
