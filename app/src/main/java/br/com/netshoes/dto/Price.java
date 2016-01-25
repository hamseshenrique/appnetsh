package br.com.netshoes.dto;

/**
 * Created by hamseshenrique on 21/01/16.
 */
public class Price {

    private String original_price;
    private String from_price;
    private String saving;
    private String payment_condition;
    private String actual_price;

    public Price(){}

    public String getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(String original_price) {
        this.original_price = original_price;
    }

    public String getFrom_price() {
        return from_price;
    }

    public void setFrom_price(String from_price) {
        this.from_price = from_price;
    }

    public String getSaving() {
        return saving;
    }

    public void setSaving(String saving) {
        this.saving = saving;
    }

    public String getPayment_condition() {
        return payment_condition;
    }

    public void setPayment_condition(String payment_condition) {
        this.payment_condition = payment_condition;
    }

    public String getActual_price() {
        return actual_price;
    }

    public void setActual_price(String actual_price) {
        this.actual_price = actual_price;
    }
}
