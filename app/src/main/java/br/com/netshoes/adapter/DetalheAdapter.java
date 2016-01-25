package br.com.netshoes.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import br.com.netshoes.appnetsh.R;
import br.com.netshoes.dto.Value;
import br.com.netshoes.viewholder.DetalheViewHolder;

/**
 * Created by hamseshenrique on 25/01/16.
 */
public class DetalheAdapter extends RecyclerView.Adapter<DetalheViewHolder>{

    private List<Value> list = new ArrayList<Value>();
    private TextView precoOriginal;
    private TextView precoAtual;


    @Override
    public DetalheViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.detalhe_layout, viewGroup, false);

        if (view.getLayoutParams ().width == RecyclerView.LayoutParams.MATCH_PARENT)
            view.getLayoutParams ().width = viewGroup.getWidth();

        return new DetalheViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetalheViewHolder holder, int position) {

        final Value value = list.get(position);
        Picasso.with(holder.itemView.getContext()).load("http:" + value.getGallery().get(0).getItems().get(0).getLarge())
                .error(android.R.drawable.stat_notify_error)
                .placeholder(android.R.drawable.ic_popup_sync)
                .into(holder.getImageDetProduct());

        holder.getNameProduct().setText(value.getName());
        holder.getDescricao().setText(value.getDescription());
        precoAtual.setText(value.getPrice().getActual_price());
        precoOriginal.setText(value.getPrice().getOriginal_price());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public List<Value> getList() {
        return list;
    }

    public void setPrecoOriginal(TextView precoOriginal) {
        this.precoOriginal = precoOriginal;
    }

    public void setPrecoAtual(TextView precoAtual) {
        this.precoAtual = precoAtual;
    }
}
