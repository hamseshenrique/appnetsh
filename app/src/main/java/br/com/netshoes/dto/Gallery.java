package br.com.netshoes.dto;

import java.util.List;

/**
 * Created by hamseshenrique on 24/01/16.
 */
public class Gallery {

    private List<Items> items;

    public Gallery(){}

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
