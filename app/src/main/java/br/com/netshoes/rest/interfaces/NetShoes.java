package br.com.netshoes.rest.interfaces;

import br.com.netshoes.dto.RetornoDTO;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by hamseshenrique on 21/01/16.
 */
public interface NetShoes {

    @GET("/{action}")
    Call<RetornoDTO> action(@Path("action") String action);

    @GET("/produto/{action}")
    Call<RetornoDTO> produto(@Path("action") String action);

}
