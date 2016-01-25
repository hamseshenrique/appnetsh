package br.com.netshoes.appnetsh;

import android.view.LayoutInflater;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.netshoes.adapter.ProdutoAdapter;
import br.com.netshoes.dto.Product;
import br.com.netshoes.dto.RetornoDTO;
import br.com.netshoes.dto.Value;
import br.com.netshoes.observer.NetShoesObservable;
import br.com.netshoes.observer.ProductObserver;

/**
 * Created by hamseshenrique on 20/01/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class,sdk = 19,
        manifest = "app/src/main/AndroidManifest.xml",
        packageName = "br.com.netshoes.appnetsh")
public class NetShoesTest {

    @Test
    public void produtoTest() throws IOException {

        RetornoDTO retornoDTO = new RetornoDTO();
        Value value = new Value();
        Product product = new Product();

        product.setUrl("teste");

        List<Product> list = new ArrayList<Product>();
        list.add(product);
        value.setProducts(list);
        retornoDTO.setValue(value);

        final ProdutoAdapter produtoAdapter = new ProdutoAdapter();
        final ProductObserver productObserver = new ProductObserver(produtoAdapter);
        final NetShoesObservable netShoesObservable = new NetShoesObservable();
        netShoesObservable.addObserver(productObserver);

        netShoesObservable.setRetornoDTO(retornoDTO);

        assert(produtoAdapter.getItemCount()==1);
    }
}
