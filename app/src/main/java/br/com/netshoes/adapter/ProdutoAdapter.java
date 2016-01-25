package br.com.netshoes.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import br.com.netshoes.appnetsh.DetalheActivity;
import br.com.netshoes.appnetsh.R;
import br.com.netshoes.dto.Product;
import br.com.netshoes.viewholder.ProdutoViewHolder;

/**
 * Created by hamseshenrique on 22/01/16.
 */
public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoViewHolder>{

    private List<Product> list = new ArrayList<>();

    @Override
    public ProdutoViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.product_list,viewGroup,false);

        if (view.getLayoutParams ().width == RecyclerView.LayoutParams.MATCH_PARENT)
            view.getLayoutParams ().width = viewGroup.getWidth();

        return new ProdutoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProdutoViewHolder holder, int position) {
        final Context context = holder.itemView.getContext();
        final Product product = list.get(position);
        holder.getImageProduto().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = product.getUrl().substring(9,product.getUrl().length());

                Intent intent = new Intent(context, DetalheActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url",url);
                intent.putExtras(bundle);

                context.startActivity(intent);

            }
        });
        Picasso.with(context).load("http:" + product.getImage().getLarge())
                .error(android.R.drawable.stat_notify_error)
                .placeholder(android.R.drawable.ic_popup_sync)
                .into(holder.getImageProduto());

        holder.getTextProduto().setText(product.getGtmData().getName());

        if(!TextUtils.isEmpty(product.getPrice().getOriginal_price())){
            holder.getTextOriginalPreco().setText("DE : "+product.getPrice().getOriginal_price());
            holder.getTextOriginalPreco().setPaintFlags(
                    holder.getTextOriginalPreco().getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }

        holder.getTextPreco().setText("POR : " + product.getPrice().getActual_price());




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public List<Product> getList() {
        return list;
    }
}
