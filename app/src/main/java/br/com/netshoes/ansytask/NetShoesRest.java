package br.com.netshoes.ansytask;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import br.com.netshoes.appnetsh.ProdutoActivity;
import br.com.netshoes.dto.EnvioRest;
import br.com.netshoes.dto.RetornoDTO;
import br.com.netshoes.enums.TipoEnvioEnum;
import br.com.netshoes.observer.NetShoesObservable;
import br.com.netshoes.rest.interfaces.NetShoes;
import br.com.netshoes.util.NetShoesUtil;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by hamseshenrique on 21/01/16.
 */
public class NetShoesRest extends AsyncTask<EnvioRest,RetornoDTO,RetornoDTO>{

    private ProgressBar progressBar;
    private NetShoesObservable netShoesObservable;

    public NetShoesRest(final NetShoesObservable netShoesObservable){
        this.netShoesObservable = netShoesObservable;
    }
    public NetShoesRest(final ProgressBar progressBar,final NetShoesObservable netShoesObservable){
        this.progressBar = progressBar;
        this.netShoesObservable = netShoesObservable;
    }

    @Override
    protected RetornoDTO doInBackground(EnvioRest... params) {

        RetornoDTO retornoDTO = null;

        try{
            final OkHttpClient okHttpClient = new OkHttpClient();
            okHttpClient.setConnectTimeout(220 * 1000, TimeUnit.MILLISECONDS);
            okHttpClient.setReadTimeout(220 * 1000, TimeUnit.MILLISECONDS);
            okHttpClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .header("User-Agent","Netshoes App")
                            .header("X-Requested-With", "XMLHttpRequest")
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                }
            });

            final Retrofit retrofit = new Retrofit.Builder().baseUrl(
                    "http://www.netshoes.com.br").client(
                    okHttpClient).addConverterFactory(
                    GsonConverterFactory.create()).build();

            final EnvioRest envioRest = params[0];
            final NetShoes netShoes = retrofit.create(NetShoes.class);
            Call<RetornoDTO> call = null;

            if(TipoEnvioEnum.LIST_PRODUTO.equals(envioRest.getTipoEnvioEnum())){
                call = netShoes.action(envioRest.getUrl());
            }else if(TipoEnvioEnum.DETALHE_PRODUTO.equals(envioRest.getTipoEnvioEnum())){
                call = netShoes.produto(envioRest.getUrl());
            }

            final retrofit.Response<RetornoDTO> response = call.execute();

            if(response.isSuccess()){
                retornoDTO = response.body();
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return retornoDTO;
    }

    @Override
    protected void onPostExecute(final RetornoDTO retornoDTO) {
        netShoesObservable.setRetornoDTO(retornoDTO);
        if(progressBar != null){
            progressBar.setVisibility(View.GONE);
        }
    }
}
