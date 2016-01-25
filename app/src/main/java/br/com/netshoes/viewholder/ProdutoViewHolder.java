package br.com.netshoes.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.netshoes.appnetsh.R;

/**
 * Created by hamseshenrique on 22/01/16.
 */
public class ProdutoViewHolder extends RecyclerView.ViewHolder{

    private ImageView imageProduto;
    private TextView textProduto;
    private TextView textPreco;
    private TextView textOriginalPreco;

    public ProdutoViewHolder(View itemView) {
        super(itemView);

        imageProduto = (ImageView) itemView.findViewById(R.id.imageProduct);
        textProduto = (TextView) itemView.findViewById(R.id.textProduct);
        textPreco = (TextView) itemView.findViewById(R.id.textPreco);
        textOriginalPreco = (TextView) itemView.findViewById(R.id.textOriginalPreco);
    }

    public ImageView getImageProduto() {
        return imageProduto;
    }

    public void setImageProduto(ImageView imageProduto) {
        this.imageProduto = imageProduto;
    }

    public TextView getTextProduto() {
        return textProduto;
    }

    public void setTextProduto(TextView textProduto) {
        this.textProduto = textProduto;
    }

    public TextView getTextPreco() {
        return textPreco;
    }

    public void setTextPreco(TextView textPreco) {
        this.textPreco = textPreco;
    }

    public TextView getTextOriginalPreco() {
        return textOriginalPreco;
    }

    public void setTextOriginalPreco(TextView textOriginalPreco) {
        this.textOriginalPreco = textOriginalPreco;
    }
}
