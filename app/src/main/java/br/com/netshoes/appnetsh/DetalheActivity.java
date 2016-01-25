package br.com.netshoes.appnetsh;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import br.com.netshoes.adapter.DetalheAdapter;
import br.com.netshoes.ansytask.NetShoesRest;
import br.com.netshoes.dto.EnvioRest;
import br.com.netshoes.enums.TipoEnvioEnum;
import br.com.netshoes.observer.DetalheProductObserver;
import br.com.netshoes.observer.NetShoesObservable;
import br.com.netshoes.util.NetShoesUtil;

public class DetalheActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private NetShoesObservable netShoesObservable;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinationDetalhe);

        try{
            final TextView precoOriginal = (TextView) findViewById(R.id.precoOriginal);
            final TextView precoAtual = (TextView) findViewById(R.id.precoAtual);

            netShoesObservable = new NetShoesObservable();
            final DetalheAdapter detalheAdapter = new DetalheAdapter();
            detalheAdapter.setPrecoAtual(precoAtual);
            detalheAdapter.setPrecoOriginal(precoOriginal);

            final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycleDetalhes);
            recyclerView.setHasFixedSize(true);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(detalheAdapter);

            final DetalheProductObserver detalheProductObserver = new DetalheProductObserver(detalheAdapter);
            netShoesObservable.addObserver(detalheProductObserver);

            progressBar = (ProgressBar)findViewById(R.id.progressBar);
            progressBar.setVisibility(View.VISIBLE);

            Bundle bundle = getIntent().getExtras();
            if(bundle != null){
                String url = (String) bundle.get("url");
                obterDetalhe(url);
            }

        }catch (Exception e){
        }
    }

    public void obterDetalhe(final String url){

        if(NetShoesUtil.existeConexao(this)){
            new NetShoesRest(progressBar,netShoesObservable).execute(new EnvioRest(TipoEnvioEnum.DETALHE_PRODUTO,url));
        }else{
            Snackbar snackbar = Snackbar.make(coordinatorLayout,R.string.conexao,Snackbar.LENGTH_INDEFINITE);
            snackbar.setAction(R.string.tenteNovamente, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    progressBar.setVisibility(View.VISIBLE);
                    obterDetalhe(url);
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
