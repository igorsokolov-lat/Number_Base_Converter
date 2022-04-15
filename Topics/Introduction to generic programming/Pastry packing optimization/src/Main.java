
class Box<T> {
    private T boxName;

    public void put(T boxName) {
        this.boxName = boxName;
    }

    public T get() {
        return this.boxName;
    }


}

// Don't change classes below
class Cake {
}

class Pie {
}

class Tart {
}