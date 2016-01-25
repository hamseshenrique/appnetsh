package br.com.netshoes.dto;

/**
 * Created by hamseshenrique on 21/01/16.
 */
public class Product {

    private Image image;
    private String base_sku;
    private String sku;
    private Seller seller;
    private String url;
    private Price price;
    private GtmData gtmData;

    public Product(){}

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getBase_sku() {
        return base_sku;
    }

    public void setBase_sku(String base_sku) {
        this.base_sku = base_sku;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public GtmData getGtmData() {
        return gtmData;
    }

    public void setGtmData(GtmData gtmData) {
        this.gtmData = gtmData;
    }
}
