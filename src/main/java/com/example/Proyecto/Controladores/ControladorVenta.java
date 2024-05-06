package com.example.Proyecto.Controladores;

import com.example.Proyecto.Clases.Carrito;
import com.example.Proyecto.Clases.Cliente;
import com.example.Proyecto.Clases.MedioPago;
import com.example.Proyecto.Clases.Producto;
import com.example.Proyecto.Clases.Venta;
import com.example.Proyecto.Clases.VentaDetalle;
import com.example.Proyecto.Interfaces.IClienteService;
import com.example.Proyecto.Interfaces.InterMedioPagoService;
import com.example.Proyecto.Interfaces.InterProductoService;
import com.example.Proyecto.Interfaces.InterVentaDetalleService;
import com.example.Proyecto.Interfaces.InterVentaService;

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
    ArrayList<Venta> misVentas = new ArrayList<>();

    String carpeta = "Venta/";

    @Autowired
    private InterVentaService service; // Para poder usar los metodos

    @Autowired
    private InterProductoService service_p; // Para poder usar los metodos de Producto Interface

    @Autowired
    InterMedioPagoService service_mp;

    @Autowired
    InterVentaDetalleService service_vd;

    @Autowired
    IClienteService service_cli;

    @PostMapping("/registrar") // localhost/registrarVenta
    public String RegistrarVenta(@RequestParam("user") String user,
            @RequestParam("clave") String pass,
            @RequestParam("mediopago_id") MedioPago mediopago_id,
            @RequestParam("fec") String fec,
            Model model) throws ParseException {

        List<Cliente> listC = service_cli.Listar();
        Cliente ventasCli = new Cliente();

        for (int i = 0; i < listC.size(); i++) {
            if (listC.get(i).getUsername().equals(user)) {
                if (listC.get(i).clave.equals(pass)) {
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
        Venta v = new Venta();

        // c.setId(codigo);
        v.setFecha(fecha);
        v.setCliente(ventasCli);
        v.setMediopago(mediopago_id);
        v.setTotalVenta(totalVenta);

        service.Guardar(v);

        int id_venta = service.UltimoIdVenta();
        Venta vv = new Venta();
        vv.setId(id_venta);

        // Registrar la venta detalle
        for (int i = 0; i < carritoLista.size(); i++) {
            int id_prod = carritoLista.get(i).getIdProducto();
            Producto p = new Producto();
            p.setId(id_prod);

            String descripcion = carritoLista.get(i).getDescripcion();
            Double precio = carritoLista.get(i).getPrecio();
            Double cantidad = carritoLista.get(i).getCantidad();
            Double total = carritoLista.get(i).getTotal();

            VentaDetalle vd = new VentaDetalle();
            vd.setVenta(vv);
            vd.setProducto(p);
            vd.setDescripcion(descripcion);
            vd.setCantidad(cantidad);
            vd.setPrecio(precio);
            vd.setTotal(total);

            service_vd.Guardar(vd);
        }

        // Vaciar el carrito
        carritoLista.clear();

        return "Venta/reporteVenta";
    }

    @PostMapping("/agregar")
    public String agregarCarrito(@RequestParam("id") int producto_id,
            @RequestParam("cant") double cantidad,
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

        return listarCarrito(model);
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
        return carpeta + "listaVenta"; // listaCliente.html
    }

    @GetMapping("/listarCarrito")
    public String listarCarrito(Model model) {
        model.addAttribute("Carrito", carritoLista);
        model.addAttribute("MedioPago", service_mp.Listar());
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
        List<Venta> lc = service.Buscar(desc);
        model.addAttribute("Venta", lc);
        return carpeta + "listaVenta";
    }

    @GetMapping("/editar")
    public String editarVenta(@RequestParam("cod") int codigo,
            Model model) {
        Optional<Venta> prod = service.ConsultarId(codigo);
        model.addAttribute("Venta", prod);
        return carpeta + "editarVenta";
    }
    @GetMapping("/listarDetalle")
    public String listarVentaDetalle(@RequestParam("cod") int codigo,Model model) {
        List<VentaDetalle> vd = service_vd.BuscarPorIdVenta(codigo);

         model.addAttribute("Venta", misVentas);
        model.addAttribute("VentaDetalle", vd);
        return carpeta + "reporteVenta"; // listaVenta.html
    }

    @PostMapping("/misVentas")
    public String listarmisVenta(@RequestParam("user") String user,
            @RequestParam("clave") String pass, Model model) {

        misVentas.clear();
        List<Cliente> listC = service_cli.Listar();
        List<Venta> listV = service.Listar();
        Cliente ventasCli = new Cliente();

        for (int i = 0; i < listC.size(); i++) {
            if (listC.get(i).getUsername().equals(user)) {
                if (listC.get(i).clave.equals(pass)) {
                    ventasCli = listC.get(i);
                }
            }
        }

        for (int i = 0; i < listV.size(); i++) {
            if (listV.get(i).getCliente().getId() == ventasCli.getId()) {
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
