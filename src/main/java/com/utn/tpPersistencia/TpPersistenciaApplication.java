package com.utn.tpPersistencia;

import com.utn.tpPersistencia.entidades.*;
import com.utn.tpPersistencia.enums.Estado;
import com.utn.tpPersistencia.enums.FormaPago;
import com.utn.tpPersistencia.enums.TipoEnvio;
import com.utn.tpPersistencia.enums.TipoProducto;
import com.utn.tpPersistencia.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;

@SpringBootApplication
public class TpPersistenciaApplication {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	DetallePedidoRepository detallePedidoRepository;

	@Autowired
	DomicilioRepository domicilioRepository;

	@Autowired
	FacturaRepository facturaRepository;

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ProductoRepository productoRepository;

	@Autowired
	RubroRepository rubroRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(TpPersistenciaApplication.class, args);
		System.out.println("hola");
	}

	@Bean
	CommandLineRunner init(ClienteRepository clienteRepository, DetallePedidoRepository detallePedidoRepository, DomicilioRepository domicilioRepository, FacturaRepository facturaRepository, PedidoRepository pedidoRepository, ProductoRepository productoRepository, RubroRepository rubroRepository, UsuarioRepository usuarioRepository){
		return args -> {


			    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
			    SimpleDateFormat formatoHora = new SimpleDateFormat("dd-MM-yyyy hh:mm");



			    Factura factura1 = new Factura();
				factura1.setFecha(formato.parse("14-08-2023"));
				factura1.setNumero(9487);
				factura1.setFormaPago(FormaPago.EFECTIVO);
				factura1.setDescuento(0);
				factura1.setTotal(38372);



				Factura factura2 = new Factura();
				factura2.setFecha(formato.parse("22-10-2023"));
				factura2.setNumero(2738);
				factura2.setFormaPago(FormaPago.TARJETA_DEBITO);
				factura2.setDescuento(50);
				factura2.setTotal(29382);


				Factura factura3 = new Factura();
				factura3.setFecha(formato.parse("05-11-2023"));
				factura3.setNumero(6748);
				factura3.setFormaPago(FormaPago.MERCADOPAGO);
				factura3.setDescuento(10);
				factura3.setTotal(3849);


				Producto producto1 = new Producto();
				producto1.setTipoProducto(TipoProducto.MANUFACTURADO);
				producto1.setTiempoEstimadoCocina(30);
				producto1.setDenominacion("Milanesa para 3 personas");
				producto1.setPrecioVenta(8000.00);
				producto1.setPrecioCompra(4000.00);
				producto1.setStockActual(7);
				producto1.setStockMinimo(3);
				producto1.setUnidadMedida("CM");
				producto1.setFoto("PATH");
				producto1.setReceta("Lorem ipsum");


				Producto producto2 = new Producto();
				producto2.setTipoProducto(TipoProducto.MANUFACTURADO);
				producto2.setTiempoEstimadoCocina(20);
				producto2.setDenominacion("Chesse Burger");
				producto2.setPrecioVenta(3000.00);
				producto2.setPrecioCompra(1500.00);
				producto2.setStockActual(15);
				producto2.setStockMinimo(6);
				producto2.setUnidadMedida("CM");
				producto2.setFoto("PATH2");
				producto2.setReceta("Queso chedar, cebolla, barbacoa");


				Producto producto3 = new Producto();
				producto3.setTipoProducto(TipoProducto.INSUMO);
				producto3.setTiempoEstimadoCocina(5);
				producto3.setDenominacion("Café Espresso");
				producto3.setPrecioVenta(1200.00);
				producto3.setPrecioCompra(750.00);
				producto3.setStockActual(50);
				producto3.setStockMinimo(10);
				producto3.setUnidadMedida("ml");
				producto3.setFoto("PATH3");
				producto3.setReceta("Café molido, agua caliente");


				Producto producto4 = new Producto();
				producto4.setTipoProducto(TipoProducto.MANUFACTURADO);
				producto4.setTiempoEstimadoCocina(25);
				producto4.setDenominacion("Lomo");
				producto4.setPrecioVenta(3500.00);
				producto4.setPrecioCompra(1600.00);
				producto4.setStockActual(13);
				producto4.setStockMinimo(4);
				producto4.setUnidadMedida("CM");
				producto4.setFoto("PATH4");
				producto4.setReceta("Bife, Lecuga, Tomate, Huevo frito");


				Rubro rubro1 = new Rubro();
				rubro1.setDenominacion("Comida");
				rubro1.getProductos().add(producto1);
				rubro1.getProductos().add(producto2);
				rubro1.getProductos().add(producto4);


				Rubro rubro2 = new Rubro();
				rubro2.setDenominacion("Cafeteria");
				rubro2.getProductos().add(producto3);


				DetallePedido detallePedido1 = new DetallePedido();
				detallePedido1.setCantidad(3);
				detallePedido1.setProducto(producto1);
				detallePedido1.setSubtotal(126.25);


				DetallePedido detallePedido2 = new DetallePedido();
				detallePedido2.setCantidad(2);
				detallePedido2.setProducto(producto2);
				detallePedido2.setSubtotal(351.58);


				DetallePedido detallePedido3 = new DetallePedido();
				detallePedido3.setCantidad(3);
				detallePedido3.setProducto(producto3);
				detallePedido3.setSubtotal(3595.58);


				DetallePedido detallePedido4 = new DetallePedido();
				detallePedido4.setCantidad(1);
				detallePedido4.setProducto(producto4);
				detallePedido4.setSubtotal(6589.14);


				DetallePedido detallePedido5 = new DetallePedido();
				detallePedido5.setCantidad(5);
				detallePedido5.setProducto(producto1);
				detallePedido5.setSubtotal(9588.20);


				Pedido pedido1 = new Pedido();
				pedido1.setFecha(formato.parse("02-09-2023"));
				pedido1.setEstado(Estado.ENTREGADO);
				pedido1.setHoraEstimadaEntrega(formatoHora.parse("02-09-2023 14:15"));
				pedido1.setTipoEnvio(TipoEnvio.DELIVERY);
				pedido1.setFactura(factura1);
				pedido1.getDetallePedidos().add(detallePedido1);
				pedido1.getDetallePedidos().add(detallePedido2);


				Pedido pedido2 = new Pedido();
				pedido2.setFecha(formato.parse("07-09-2023"));
				pedido2.setEstado(Estado.PREPARADO);
				pedido2.setHoraEstimadaEntrega(formatoHora.parse("07-09-2023 22:15"));
				pedido2.setTipoEnvio(TipoEnvio.RETIRA);
				pedido2.setFactura(factura2);
				pedido2.getDetallePedidos().add(detallePedido3);


				Pedido pedido3 = new Pedido();
				pedido3.setFecha(formato.parse("09-09-2023"));
				pedido3.setEstado(Estado.PREPARADO);
				pedido3.setHoraEstimadaEntrega(formatoHora.parse("09-09-2023 10:15"));
				pedido3.setTipoEnvio(TipoEnvio.DELIVERY);
				pedido3.setFactura(factura3);
				pedido3.getDetallePedidos().add(detallePedido4);
				pedido3.getDetallePedidos().add(detallePedido5);


				Usuario usuario1 = new Usuario();
				usuario1.setNombre("Javier");
				usuario1.setPassword("Javi0492");
				usuario1.setRol("01-USER");
				usuario1.getPedidos().add(pedido1);


				Usuario usuario2 = new Usuario();
				usuario2.setNombre("Monica");
				usuario2.setPassword("Moni94829");
				usuario2.setRol("02-ADMIN");
				usuario2.getPedidos().add(pedido2);



				Usuario usuario3 = new Usuario();
				usuario3.setNombre("Rodrigo");
				usuario3.setPassword("Rodri983");
				usuario3.setRol("01-USER");
				usuario3.getPedidos().add(pedido3);

				productoRepository.save(producto1);
				productoRepository.save(producto2);
				productoRepository.save(producto3);
				productoRepository.save(producto4);

				rubroRepository.save(rubro1);
				rubroRepository.save(rubro2);

				usuarioRepository.save(usuario1);
				usuarioRepository.save(usuario2);
				usuarioRepository.save(usuario3);

				pedidoRepository.save(pedido1);
				pedidoRepository.save(pedido2);
				pedidoRepository.save(pedido3);

				facturaRepository.save(factura1);
				facturaRepository.save(factura2);
				facturaRepository.save(factura3);

				detallePedidoRepository.save(detallePedido1);
				detallePedidoRepository.save(detallePedido2);
				detallePedidoRepository.save(detallePedido3);
				detallePedidoRepository.save(detallePedido4);
				detallePedidoRepository.save(detallePedido5);

		};

	}
}
