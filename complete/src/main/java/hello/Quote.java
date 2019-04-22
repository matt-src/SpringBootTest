package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    private Item item;

    public Quote() {
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem(){
        return item;
    }


}