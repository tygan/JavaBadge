package org.familysearch.test.codeshare;

/**
 * Created by tyganshelton on 5/12/2015.
 */
public class WeddingGift {
    private String name;
    private String store;
    private int price;

    public WeddingGift(String name, int price, String store) {
        this.name = name;
        this.price = price;
        this.store = store;
    }

    public String getName() {return name; }

    public int getPrice() {
        return price;
    }

    public String getStore() { return store; }
}
