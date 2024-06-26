package com.example.Proyecto.Controladores;

import com.example.Proyecto.Clases.Carrito;
import com.example.Proyecto.Clases.Producto;
import com.example.Proyecto.Clases.Usuario;
import com.example.Proyecto.Interfaces.InterMedioPagoService;
import com.example.Proyecto.Clases.Pedido;
import com.example.Proyecto.Clases.DetallePedido;
import com.example.Proyecto.Clases.MetodoPago;
import com.example.Proyecto.Servicios.ProductoService;
import com.example.Proyecto.Servicios.UsuarioService;
import com.example.Proyecto.Servicios.VentaDetalleService;
import com.example.Proyecto.Servicios.VentaService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/venta/")
@Controller
public class ControladorVenta {

    ArrayList<Carrito> carritoLista = new ArrayList<>();
    ArrayList<Pedido> misVentas = new ArrayList<>();

    String carpeta = "Venta/";

    @Autowired
    private VentaService service; // Para poder usar los metodos

    @Autowired
    private ProductoService service_p; // Para poder usar los metodos de Producto Interface

    @Autowired
    InterMedioPagoService service_mp;

    @Autowired
    VentaDetalleService service_vd;

    @Autowired
    UsuarioService service_cli;

    @PostMapping("/registrar") // localhost/registrarVenta
    public String RegistrarVenta(@RequestParam("user") String user,
            @RequestParam("clave") String pass,
            @RequestParam("mediopago_id") MetodoPago mediopago_id,
            @RequestParam("fec") String fec,
            Model model) throws ParseException {

        List<Usuario> listC = service_cli.Listar();
        Usuario ventasCli = new Usuario();

        for (int i = 0; i < listC.size(); i++) {
            if (listC.get(i).getUsername().equals(user)) {
                if (listC.get(i).getClave().equals(pass)) {
                    ventasCli = listC.get(i);
                }
            }
        }

        // Separacion de fecha
        String[] parts = fec.split("T");
        String part1 = parts[0];
        String part2 = parts[1];
        String fec_ = part1 + " " + part2 + ":00";

        SimpleDateFormat formateadorfecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date fecha = formateadorfecha.parse(fec_);

        // Obtener el TotalVenta
        Double totalVenta = 0.0;
        for (int i = 0; i < carritoLista.size(); i++) {
            totalVenta += carritoLista.get(i).getTotal();
        }

        // Aqui sera el proceso para registrar
        Pedido v = new Pedido();

        // c.setId(codigo);
        v.setFecha(fecha);
        v.setUsuario(ventasCli);
        v.setMetodoPago(mediopago_id);
        v.setTotal(totalVenta);

        service.Guardar(v);

        int id_venta = service.UltimoIdVenta();
        Pedido vv = new Pedido();
        vv.setId_pedido(id_venta);

        // Registrar la venta detalle
        for (int i = 0; i < carritoLista.size(); i++) {
            int id_prod = carritoLista.get(i).getIdProducto();
            Producto p = new Producto();
            p.setId_producto(id_prod);

            Double precio = carritoLista.get(i).getPrecio();
            int cantidad = carritoLista.get(i).getCantidad();
            Double total = carritoLista.get(i).getTotal();

            DetallePedido vd = new DetallePedido();
            vd.setPedido(vv);
            vd.setProducto(p);
            vd.setCantidad(cantidad);
            vd.setPrecio_unitario(precio);
            vd.setPrecio_total(total);

            service_vd.Guardar(vd);
        }

        // Vaciar el carrito
        carritoLista.clear();

        return "Venta/reporteVenta";
    }

    @PostMapping("/agregar")
    public String agregarCarrito(@RequestParam("id") int producto_id,
            @RequestParam("cant") int cantidad,
            Model model) {
        Optional<Producto> producto = service_p.ConsultarId(producto_id);
    
        String nombre = producto.get().getNombre();
        String descripcion = producto.get().getDescripcion();
        double precio = producto.get().getPrecio();
        double total = cantidad * precio;
    
        // AGREGAMOS AL CARRITO
        Carrito carrito = new Carrito();
    
        carrito.setIdProducto(producto_id);
        carrito.setProducto(nombre);
        carrito.setDescripcion(descripcion);
        carrito.setPrecio(precio);
        carrito.setCantidad(cantidad);
        carrito.setTotal(total);
    
        carritoLista.add(carrito);
    
        // Redirigir a listarCarrito para mostrar el contenido actualizado del carrito
        return "redirect:/venta/listarCarrito";
    }
    

    @GetMapping("/eliminarcarrito")
    public String eliminarCarrito(@RequestParam("cod") int codigo,
            Model model) {
        carritoLista.remove(codigo - 1);
        return listarCarrito(model);
    }

    @GetMapping("/listar")
    public String listarVenta(Model model) {
        model.addAttribute("Venta", service.Listar());
        return "/Venta/listaVenta"; // listaCliente.html
    }

    @GetMapping("/listarCarrito")
    public String listarCarrito(Model model) {
        model.addAttribute("Carrito", carritoLista);
        model.addAttribute("MetodoPago", service_mp.Listar());
        model.addAttribute("Cliente", service_cli.Listar());
        return carpeta + "carritoCompra"; // carritoCompra.html
    }

    @GetMapping("/eliminar")
    public String eliminarVenta(@RequestParam("cod") int codigo,
            Model model) {
        service.Eliminar(codigo);
        return listarVenta(model);
    }

    @PostMapping("/buscar")
    public String buscarVenta(@RequestParam("desc") String desc,
            Model model) {
        List<Pedido> lc = service.Buscar(desc);
        model.addAttribute("Venta", lc);
        return carpeta + "listaVenta";
    }

    @GetMapping("/editar")
    public String editarVenta(@RequestParam("cod") int codigo,
            Model model) {
        Optional<Pedido> prod = service.ConsultarId(codigo);
        model.addAttribute("Venta", prod);
        return carpeta + "editarVenta";
    }
    @GetMapping("/listarDetalle")
    public String listarVentaDetalle(@RequestParam("cod") int codigo,Model model) {
        List<DetallePedido> vd = service_vd.BuscarPorIdVenta(codigo);

        model.addAttribute("Venta", misVentas);
        model.addAttribute("VentaDetalle", vd);
        return carpeta + "reporteVenta"; // listaVenta.html
    }

    @PostMapping("/misVentas")
    public String listarmisVenta(@RequestParam("user") String user,
            @RequestParam("clave") String pass, Model model) {

        misVentas.clear();
        List<Usuario> listC = service_cli.Listar();
        List<Pedido> listV = service.Listar();
        Usuario ventasCli = new Usuario();

        for (int i = 0; i < listC.size(); i++) {
            if (listC.get(i).getUsername().equals(user)) {
                if (listC.get(i).getClave().equals(pass)) {
                    ventasCli = listC.get(i);
                }
            }
        }

        for (int i = 0; i < listV.size(); i++) {
            if (listV.get(i).getUsuario().getId_usuario() == ventasCli.getId_usuario()) {
                misVentas.add(listV.get(i));
            }
        }

        model.addAttribute("Venta", misVentas);
        return carpeta + "reporteVenta"; // listaCliente.html
    }
    
    @GetMapping("/reporte") // localhost/cliente/nuevo
    public String verReporte() {
        return carpeta + "reporteVenta"; // nuevoCliente.html
    }

}
