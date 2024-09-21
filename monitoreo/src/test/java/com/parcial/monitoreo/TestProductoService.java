package com.parcial.monitoreo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import com.parcial.monitoreo.producto.*;
import com.parcial.monitoreo.log.Log;
import com.parcial.monitoreo.advertencia.Advertencia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@SpringBootTest
class TestProductoService {

    private ProductoService productoService;
    private Log logAgent;
    private Advertencia advertenciaAgent;

    @BeforeEach
    void setUp() {
        logAgent = Mockito.mock(Log.class);
        advertenciaAgent = Mockito.mock(Advertencia.class);
        productoService = new ProductoService(logAgent, advertenciaAgent);
    }

    @Test
    void test_should_AddProduct() {
        Producto producto = new Producto("Xbox One S", 299.99, 10, "Videojuegos");
        assertTrue(productoService.addProduct(producto));
        assertFalse(productoService.addProduct(producto)); // Debe fallar porque ya existe
    }

    @Test
    void test_should_UpdateStock() {
        Producto producto = new Producto("Xbox One S", 299.99, 10, "Videojuegos");
        productoService.addProduct(producto);

        productoService.updateStock("Xbox One S", 15);
        assertEquals(15, producto.getCantidad());

        // Verificar que se llama al agente de log
        Mockito.verify(logAgent).notifyStockChange(producto);
    }

    @Test
    void test_should_UpdateStock_LowStockAlert() {
        Producto producto = new Producto("Xbox One S", 299.99, 10, "Videojuegos");
        productoService.addProduct(producto);

        productoService.updateStock("Xbox One S", 3);

        // Verificar que se llama al agente de advertencia
        Mockito.verify(advertenciaAgent).notifyLowStock(producto);
    }

    @Test
    void test_should_UpdateStock_ProductNotFound() {
        assertThrows(ProductoNotFoundException.class, () -> {
            productoService.updateStock("Producto Inexistente", 10);
        });
    }

    @Test
    void test_should_GetAllProducts() {
        Producto producto1 = new Producto("Xbox One S", 299.99, 10, "Videojuegos");
        Producto producto2 = new Producto("PS5", 499.99, 5, "Videojuegos");

        productoService.addProduct(producto1);
        productoService.addProduct(producto2);

        assertEquals(2, productoService.getAllProducts().size());
    }
}
