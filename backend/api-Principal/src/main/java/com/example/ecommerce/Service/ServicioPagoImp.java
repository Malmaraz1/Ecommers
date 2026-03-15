package com.example.ecommerce.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Model.ItemCarrito;
import com.example.ecommerce.Model.ItemPedido;
import com.example.ecommerce.Model.Pedido;
import com.example.ecommerce.Repository.RepositorioPedido;
import com.example.ecommerce.Service.ServiceImp.ServicioPago;
import com.example.ecommerce.exceptions.NotFoundException;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

@Service
public class ServicioPagoImp implements ServicioPago {

    @Autowired
    RepositorioPedido repositorioPedido;
    @Autowired
    ServidorConversorDeMonedasImp servidorConversorDeMonedasImp;
    
    @Value("${app.frontend.url}")
    private String frontendUrl;

    @Override
    public String realizarPago(Pedido pedido) throws StripeException {

        Pedido pedidoDb = repositorioPedido.findById(pedido.getId()).orElseThrow(
                () -> new NotFoundException("No se encontro el pedido con id " + pedido.getId()));

        List<SessionCreateParams.LineItem> lineItems = new ArrayList<>();

        for (ItemPedido item : pedidoDb.getItems_pedido()) {

            lineItems.add(

                    SessionCreateParams.LineItem.builder()
                            .setQuantity((long) item.getCantidad()) // La cantidad de ese producto
                            .setPriceData(
                                    SessionCreateParams.LineItem.PriceData.builder()
                                            .setCurrency("brl") // O la moneda que calculamos antes
                                            .setUnitAmount(Math.round(item.getProducto().getPrecio() * 100
                                                    * servidorConversorDeMonedasImp.getExchangeRate()))

                                            .setProductData(
                                                    SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                            .setName(item.getProducto().getNombre())
                                                            .build())
                                            .build())
                            .build());
        }

        // 3. Pasamos toda la lista al builder principal
        SessionCreateParams params = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl(frontendUrl + "/success")
                .setCancelUrl(frontendUrl + "/cancel")
                .addAllLineItem(lineItems)
                .build();

        Session session = Session.create(params);
        return session.getUrl();

    }

    @Override
    public void cancelarPago(Pedido pedido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelarPago'");
    }

}
