public class MyTestingClass {
    private int id;
    private String name;

    public MyTestingClass(int id, String name) {
        this.id   = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + name; // used by MyHashTable.hash()
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyTestingClass)) return false;
        MyTestingClass other = (MyTestingClass) o;
        return this.id == other.id &&
                (this.name == null ? other.name == null : this.name.equals(other.name));
    }
}