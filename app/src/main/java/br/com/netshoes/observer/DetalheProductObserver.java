package br.com.netshoes.observer;

import java.util.Observable;
import java.util.Observer;

import br.com.netshoes.adapter.DetalheAdapter;

/**
 * Created by hamseshenrique on 24/01/16.
 */
public class DetalheProductObserver  implements Observer {

    private DetalheAdapter detalheAdapter;

    public DetalheProductObserver(final DetalheAdapter detalheAdapter){
        this.detalheAdapter = detalheAdapter;
    }

    @Override
    public void update(Observable observable, Object data) {
        if(observable instanceof NetShoesObservable){
            final NetShoesObservable netShoesObservable = (NetShoesObservable) observable;

            if(netShoesObservable.getRetornoDTO() != null
                    && netShoesObservable.getRetornoDTO().getValue() != null){
                detalheAdapter.getList().add(netShoesObservable.getRetornoDTO().getValue());
                detalheAdapter.notifyDataSetChanged();
            }
        }
    }
}
