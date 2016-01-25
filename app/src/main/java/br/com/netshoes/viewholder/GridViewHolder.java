package br.com.netshoes.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import br.com.netshoes.appnetsh.R;


/**
 * Created by hamseshenrique on 25/01/16.
 */
public class GridViewHolder extends RecyclerView.ViewHolder{

    private ImageView imageView;

    public GridViewHolder(View itemView) {
        super(itemView);
        this.imageView = (ImageView) itemView.findViewById(R.id.imageDetProduct);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
