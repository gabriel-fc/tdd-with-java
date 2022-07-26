package exercise9;

public class Name {
    private String name;


    public Name(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object that) {
        return name.equals(((Name)that).name);
    }

    public String getName() {
        return name;
    }
}
