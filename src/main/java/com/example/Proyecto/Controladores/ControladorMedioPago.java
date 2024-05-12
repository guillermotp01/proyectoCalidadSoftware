/*package com.example.Proyecto.Controladores;

import com.example.Proyecto.Clases.MedioPago;
import com.example.Proyecto.Interfaces.InterMedioPagoService;
//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/mediopago/")
@Controller
public class ControladorMedioPago {

    //ArrayList<MedioPago> listaCli = new ArrayList();
    String carpeta = "MedioPago/";

    @Autowired
    private InterMedioPagoService service; //Para poder usar los metodos

    @GetMapping("/nuevo") //localhost/nuevo
    public String nuevoMedioPago() {
        return carpeta + "nuevoMedioPago"; //nuevoMedioPago.html
    }

    @PostMapping("/registrar") //localhost/registrar
    public String RegistrarMedioPago(@RequestParam("nom") String nombre, //@RequestParam("cod") int codigo,
            Model model) {
        //Aqui sera el proceso para registrar
        MedioPago mp = new MedioPago();

        //c.setId(codigo);
        mp.setNombre(nombre);

        service.Guardar(mp);

        return listarMedioPago(model);
    }

    @GetMapping("/listar")
    public String listarMedioPago(Model model) {
        //model.addAttribute("MedioPago", listaCli);
        model.addAttribute("MedioPago", service.Listar());
        return carpeta + "listaMedioPago"; //listaMedioPago.html
    }

    @GetMapping("/eliminar")
    public String eliminarMedioPago(@RequestParam("cod") int codigo,
            Model model) {
        /*
        for (int i = 0; i < listaCli.size(); i++) {
            int c = listaCli.get(i).getId();
            if (c == codigo) {
                listaCli.remove(i);
            }
        }

        service.Eliminar(codigo);
        return listarMedioPago(model);
    }

    @GetMapping("/editar")
    public String editarMedioPago(@RequestParam("cod") int codigo,
            Model model) {
        /*
        MedioPago cli = new MedioPago();
        for (int i = 0; i < listaCli.size(); i++) {
            int c = listaCli.get(i).getId();
            if (c == codigo) {
                String nom = listaCli.get(i).getNombre();
                String ape = listaCli.get(i).getApellido();
                String dni = listaCli.get(i).getDni();
                String cel = listaCli.get(i).getCelular();
                String email = listaCli.get(i).getEmail();
                String dir = listaCli.get(i).getDireccion();

                cli.setId(codigo);
                cli.setNombre(nom);
                cli.setApellido(ape);
                cli.setDni(dni);
                cli.setCelular(cel);
                cli.setEmail(email);
                cli.setDireccion(dir);
            }
        }

        Optional<MedioPago> cli = service.ConsultarId(codigo);
        model.addAttribute("MedioPago", cli);
        return carpeta + "editarMedioPago";
    }

    @PostMapping("/actualizar")
    public String actualizarMedioPago(@RequestParam("id") int codigo,
            @RequestParam("nombre") String nombre,
            Model model) {

        for (int i = 0; i < listaCli.size(); i++) {
            int c = listaCli.get(i).getId();
            if (c == codigo) {
                listaCli.get(i).setNombre(nombre);
                listaCli.get(i).setApellido(apellido);
                listaCli.get(i).setDni(dni);
                listaCli.get(i).setCelular(celular);
                listaCli.get(i).setEmail(email);
                listaCli.get(i).setDireccion(direccion);
            }
        }
         
        MedioPago mp = new MedioPago();

        mp.setId(codigo);
        mp.setNombre(nombre);

        service.Guardar(mp); //cuando se envia el ID -> Actualizar

        return listarMedioPago(model);
    }

    @PostMapping("/buscar")
    public String buscarMedioPago(@RequestParam("desc") String desc,
            Model model) {
        List<MedioPago> lc = service.Buscar(desc);
        model.addAttribute("MedioPago", lc);
        return carpeta + "listaMedioPago";
        /*
        ArrayList<MedioPago> lc = new ArrayList();

        for (int i = 0; i < listaCli.size(); i++) {
            if (String.valueOf(listaCli.get(i).getId()).equals(desc)
                    || listaCli.get(i).getNombre().equals(desc)
                    || listaCli.get(i).getApellido().equals(desc)
                    || listaCli.get(i).getDni().equals(desc)
                    || listaCli.get(i).getCelular().equals(desc)
                    || listaCli.get(i).getEmail().equals(desc)
                    || listaCli.get(i).getDireccion().equals(desc)) {
                
                int cod = listaCli.get(i).getId();
                String nom = listaCli.get(i).getNombre();
                String ape = listaCli.get(i).getApellido();
                String dni = listaCli.get(i).getDni();
                String cel = listaCli.get(i).getCelular();
                String email = listaCli.get(i).getEmail();
                String dir = listaCli.get(i).getDireccion();

                MedioPago cli = new MedioPago();
                cli.setId(cod);
                cli.setNombre(nom);
                cli.setApellido(ape);
                cli.setDni(dni);
                cli.setCelular(cel);
                cli.setEmail(email);
                cli.setDireccion(dir);

                lc.add(cli);
            }
        }
    
    }
}
*/