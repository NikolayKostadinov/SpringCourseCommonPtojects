package bg.manhattan.pathfinder.web;

import bg.manhattan.pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private final RouteService routeService;

    public HomeController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("mostCommented", this.routeService.getMostCommented());
        return "index";
    }

    @GetMapping("about")
    public String about() {
        return "about";
    }
}
