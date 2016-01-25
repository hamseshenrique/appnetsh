package br.com.netshoes.componentes;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by hamseshenrique on 24/01/16.
 */
public abstract class InfiniteScrollListener extends RecyclerView.OnScrollListener {

    private boolean loading = false;
    private GridLayoutManager gridLayoutManager;

    public abstract void loadMore();

    public InfiniteScrollListener(final GridLayoutManager gridLayoutManager){
        this.gridLayoutManager = gridLayoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int totalItem = gridLayoutManager.getItemCount();
        int lastVisibleItem = gridLayoutManager.findLastVisibleItemPosition();

        if (!loading && lastVisibleItem == totalItem - 1) {
            loadMore();
        }
    }
}
