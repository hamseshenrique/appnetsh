package br.com.netshoes.dto;

/**
 * Created by hamseshenrique on 21/01/16.
 */
public class Seller {

    private String message;
    private String name;
    private String label;

    public Seller(){}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
