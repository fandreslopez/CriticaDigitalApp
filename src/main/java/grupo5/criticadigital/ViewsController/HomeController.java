package grupo5.criticadigital.ViewsController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //Indica que es un controlador que maneja vistas de Spring MVC
public class HomeController {

    // Se usa para indicar la ruta y el tipo de solicitud
    @GetMapping("")
    public String mostrarHome(){
        return "home";
    }

}
