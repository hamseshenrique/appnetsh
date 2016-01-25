package br.com.netshoes.appnetsh;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import br.com.netshoes.adapter.ProdutoAdapter;
import br.com.netshoes.ansytask.NetShoesRest;
import br.com.netshoes.componentes.InfiniteScrollListener;
import br.com.netshoes.dto.EnvioRest;
import br.com.netshoes.dto.RetornoDTO;
import br.com.netshoes.enums.TipoEnvioEnum;
import br.com.netshoes.observer.NetShoesObservable;
import br.com.netshoes.observer.ProductObserver;
import br.com.netshoes.util.NetShoesUtil;

public class ProdutoActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private NetShoesObservable netShoesObservable;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);
        try{
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordination);

            netShoesObservable = new NetShoesObservable();
            final ProdutoAdapter produtoAdapter = new ProdutoAdapter();

            final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycleProdutos);
            recyclerView.setHasFixedSize(true);

            final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(produtoAdapter);

            final ProductObserver productObserver = new ProductObserver(produtoAdapter);

            netShoesObservable.addObserver(productObserver);

            progressBar = (ProgressBar)findViewById(R.id.progressBar);
            progressBar.setVisibility(View.VISIBLE);
            obterProdutos("?Nr=AND(product.genderList:Masculino,sku.lancamento:1)");

            recyclerView.addOnScrollListener(new InfiniteScrollListener(gridLayoutManager) {
                @Override
                public void loadMore() {
                    if(!TextUtils.isEmpty(productObserver.getUrlNextPage())){
                        obterProdutos(productObserver.getUrlNextPage());
                    }
                }
            });


        }catch(Exception e){
            Log.e("ERROr",e.getMessage());
        }
    }

    private void obterProdutos(final String url){
        if(NetShoesUtil.existeConexao(this)){
            new NetShoesRest(progressBar,netShoesObservable).execute(
                    new EnvioRest(TipoEnvioEnum.LIST_PRODUTO,
                            "departamento"+url));
        }else{
            Snackbar snackbar = Snackbar.make(coordinatorLayout,R.string.conexao,Snackbar.LENGTH_INDEFINITE);
            snackbar.setAction(R.string.tenteNovamente, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    progressBar.setVisibility(View.VISIBLE);
                    obterProdutos(url);
                }
            });

            snackbar.setActionTextColor(Color.RED);

            View sbView = snackbar.getView();

            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextSize(12);

            progressBar.setVisibility(View.GONE);
            snackbar.show();
        }
    }
}
