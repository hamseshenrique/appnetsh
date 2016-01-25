package br.com.netshoes.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.netshoes.appnetsh.R;

/**
 * Created by hamseshenrique on 25/01/16.
 */
public class DetalheViewHolder extends RecyclerView.ViewHolder{

    private ImageView imageDetProduct;
    private TextView nameProduct;
    private TextView descricao;
    private ImageView zoomImage;
    private LinearLayout linearDetalhe;

    public DetalheViewHolder(View itemView){
        super(itemView);

        this.imageDetProduct = (ImageView) itemView.findViewById(R.id.imageDetProduct);
        this.nameProduct = (TextView) itemView.findViewById(R.id.nameProduct);
        this.descricao = (TextView) itemView.findViewById(R.id.descricao);
        this.zoomImage = (ImageView) itemView.findViewById(R.id.zoomImage);
        this.linearDetalhe = (LinearLayout) itemView.findViewById(R.id.linearDetalhe);
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

    public ImageView getZoomImage() {
        return zoomImage;
    }

    public void setZoomImage(ImageView zoomImage) {
        this.zoomImage = zoomImage;
    }

    public LinearLayout getLinearDetalhe() {
        return linearDetalhe;
    }

    public void setLinearDetalhe(LinearLayout linearDetalhe) {
        this.linearDetalhe = linearDetalhe;
    }
}
