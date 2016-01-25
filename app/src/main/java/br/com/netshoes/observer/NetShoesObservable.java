package br.com.netshoes.observer;

import java.util.Observable;

import br.com.netshoes.dto.RetornoDTO;

/**
 * Created by hamseshenrique on 21/01/16.
 */
public class NetShoesObservable extends Observable{

    private RetornoDTO retornoDTO;

    public NetShoesObservable(){}

    public RetornoDTO getRetornoDTO() {
        return retornoDTO;
    }

    public void setRetornoDTO(RetornoDTO retornoDTO) {
        this.retornoDTO = retornoDTO;
        setChanged();
        notifyObservers();
    }
}