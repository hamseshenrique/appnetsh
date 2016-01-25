package br.com.netshoes.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.netshoes.appnetsh.R;

/**
 * Created by hamseshenrique on 25/01/16.
 */
public class DetalheViewHolder extends RecyclerView.ViewHolder{

    private ImageView imageDetProduct;
    private TextView nameProduct;
    private TextView descricao;

    public DetalheViewHolder(View itemView){
        super(itemView);

        this.imageDetProduct = (ImageView) itemView.findViewById(R.id.imageDetProduct);
        this.nameProduct = (TextView) itemView.findViewById(R.id.nameProduct);
        this.descricao = (TextView) itemView.findViewById(R.id.descricao);
    }

    public ImageView getImageDetProduct() {
        return imageDetProduct;
    }

    public void setImageDetProduct(ImageView imageDetProduct) {
        this.imageDetProduct = imageDetProduct;
    }

    public TextView getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(TextView nameProduct) {
        this.nameProduct = nameProduct;
    }

    public TextView getDescricao() {
        return descricao;
    }

    public void setDescricao(TextView descricao) {
        this.descricao = descricao;
    }
}
