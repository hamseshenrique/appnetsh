package br.com.netshoes.observer;

import android.text.TextUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Observable;
import java.util.Observer;

import br.com.netshoes.adapter.ProdutoAdapter;
import br.com.netshoes.dto.RetornoDTO;
import br.com.netshoes.dto.Value;

/**
 * Created by hamseshenrique on 21/01/16.
 */
public class ProductObserver implements Observer{

    private ProdutoAdapter produtoAdapter;
    private String urlNextPage;

    public ProductObserver(final ProdutoAdapter produtoAdapter){
        this.produtoAdapter = produtoAdapter;
    }

    @Override
    public void update(Observable observable, Object data) {
        if(observable instanceof NetShoesObservable){
            final NetShoesObservable netShoesObservable = (NetShoesObservable) observable;

            if(netShoesObservable.getRetornoDTO() != null
                    && netShoesObservable.getRetornoDTO().getValue() != null){

                final Value value = netShoesObservable.getRetornoDTO().getValue();

                if(!TextUtils.isEmpty(value.getUrl())){
                    urlNextPage = URLDecoder.decode(value.getUrl());
                }else{
                    urlNextPage = "";
                }

                produtoAdapter.getList().addAll(value.getProducts());
                produtoAdapter.notifyDataSetChanged();
            }
        }
    }

    public String getUrlNextPage() {
        return urlNextPage;
    }
}
