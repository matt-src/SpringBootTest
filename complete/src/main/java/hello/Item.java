package hello;

public class Item {
    private String name;
    private String description;

    private Current current;

    public Item(){

    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }
}
