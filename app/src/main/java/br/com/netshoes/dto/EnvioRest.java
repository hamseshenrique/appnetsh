package br.com.netshoes.dto;

import br.com.netshoes.enums.TipoEnvioEnum;

/**
 * Created by hamseshenrique on 24/01/16.
 */
public class EnvioRest {

    private TipoEnvioEnum tipoEnvioEnum;
    private String url;

    public EnvioRest(final TipoEnvioEnum tipoEnvioEnum,final String url){
        this.tipoEnvioEnum = tipoEnvioEnum;
        this.url = url;
    }

    public TipoEnvioEnum getTipoEnvioEnum() {
        return tipoEnvioEnum;
    }

    public void setTipoEnvioEnum(TipoEnvioEnum tipoEnvioEnum) {
        this.tipoEnvioEnum = tipoEnvioEnum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
