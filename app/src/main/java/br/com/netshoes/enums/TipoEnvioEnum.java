package br.com.netshoes.enums;

/**
 * Created by hamseshenrique on 24/01/16.
 */
public enum TipoEnvioEnum {

    LIST_PRODUTO(1,"LIST PRODUTOS"),
    DETALHE_PRODUTO(2,"DETALHE PRODUTO");

    private Integer codigo;
    private String desc;

    private TipoEnvioEnum(final Integer codigo, final String desc){
        this.codigo = codigo;
        this.desc = desc;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDesc() {
        return desc;
    }
}
