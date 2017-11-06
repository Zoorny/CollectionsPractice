package listpack;

public class Doggo implements Pet {

    private String name;
    private int size;

    public Doggo(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void pet(){
        System.out.println("Woof");
    }

    @Override
    public String toString() {
        return "Doggo{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
