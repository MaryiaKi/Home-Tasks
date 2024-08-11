public class Cat extends Animal {
    int maxRunDistance = 200;
    boolean isNotHungry = false;
    int catMaxEatFood = 8;
    public Cat(String name) {
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
        System.out.println("Cats don't swim!");
    }
    public void eat() {
        if (Bowl.currentQuantityOfFood >= catMaxEatFood) {
            Bowl.currentQuantityOfFood -= catMaxEatFood;
            isNotHungry = true;
        } else {
            System.out.println("Not enough food in the bowl!");
        }
    }
}
