package br.com.netshoes.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by hamseshenrique on 24/01/16.
 */
public class NetShoesUtil {

    public static Boolean existeConexao(final Context context){
        Boolean isConexao = Boolean.FALSE;
        try{
            final ConnectivityManager cm = (ConnectivityManager) context.getSystemService(
                    Context.CONNECTIVITY_SERVICE);

            NetworkInfo netInfo = cm.getActiveNetworkInfo();

            isConexao = netInfo != null && netInfo.isConnectedOrConnecting()
                    && netInfo.isAvailable();
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return isConexao;
    }
}
