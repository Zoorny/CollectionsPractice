package listpack;

/**
 * Created by WorkStation on 01.01.02.
 */
public class Cat implements Pet, Comparable {
    private String name;
    private int size;

    public Cat(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void pet() {
        System.out.println("Meow");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
