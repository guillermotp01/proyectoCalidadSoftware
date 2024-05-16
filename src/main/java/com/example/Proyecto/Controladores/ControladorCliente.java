package com.example.Proyecto.Controladores;


//import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Proyecto.Clases.Producto;
import com.example.Proyecto.Clases.Usuario;
import com.example.Proyecto.Servicios.UsuarioService;

@RequestMapping("/usuario")
@Controller
public class ControladorCliente {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
	public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		usuarioService.Guardar(usuario);
		return "/menuPrincipal";
	}

    @GetMapping("/listar")
	public String listarUsuarios(Model modelo) {
		modelo.addAttribute("usuarios", usuarioService.Listar());
		return "/Empleado/adminUsuarios"; 
	}

    
    /* 
    @PostMapping("/registrar") 
    public String RegistrarCliente(
            @RequestParam("nom") String nom,
            @RequestParam("ape") String ape,
            @RequestParam("dni") String dni,
            @RequestParam("cel") String cel,
            @RequestParam("correo") String cor,
            @RequestParam("user") String user,
            @RequestParam("clave") String con,
            @RequestParam("dir") String dir,
            Model model) 
    {
        //Aqui va el proceso de registrar
        Cliente c = new Cliente();
        //c.setId(cod);
        c.setNombre(nom);
        c.setApellido(ape);
        c.setDni(dni);
        c.setCelular(cel);
        c.setCorreo(cor);
        c.setUsername(user);
        c.setClave(con);
        c.setDireccion(dir);
        
        //lista.add(c);
        service.Guardar(c);
        
        return "Venta/reporteVenta";
    }

    @GetMapping("/listar") //localhost/
    public String ListarCliente(Model model) 
    {
        //model.addAttribute("clientes", lista);
        model.addAttribute("Cliente", service.Listar());
        return carpeta+"listaCliente"; //listaCliente.html
    }
    
    @GetMapping("/eliminar") //localhost/eliminar
    public String EliminarCliente(@RequestParam("cod") int cod, Model model)
    {
        
        service.Eliminar(cod);
        return ListarCliente(model);
    }
    
    @GetMapping("/editar") //localhost/editar
    public String EditarCliente(@RequestParam("cod") int cod, Model model)
    {       
        Optional<Cliente> cli =service.ConsultarId(cod);
        model.addAttribute("cliente", cli);
        return carpeta+"editarCliente"; //editarCliente.html
    }
    
    @PostMapping("/actualizar") //localhost/actualizar
    public String ActualizarCliente(Model model){
        service.Guardar();//Cuando se envia el ID -> Actualizar
        return ListarCliente(model);
    }


    @PostMapping("/buscar") //localhost/buscar
    public String BuscarCliente(@RequestParam("desc") String desc,
                                Model model)
    {
        ArrayList<Cliente> lc = new ArrayList();

        model.addAttribute("clientes", lc);
        return carpeta+"listaCliente"; //listaCliente.html
    }
    */
}
