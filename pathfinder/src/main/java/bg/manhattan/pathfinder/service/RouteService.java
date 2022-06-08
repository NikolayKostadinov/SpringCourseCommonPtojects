package bg.manhattan.pathfinder.service;

import bg.manhattan.pathfinder.model.Route;
import bg.manhattan.pathfinder.repository.RouteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RouteService {
    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Route getMostCommented() {

        return this.routeRepository
                .findMostCommented();
//                .orElseThrow(() -> new IllegalStateException("Route not found"))
//                .get(0);
    }
}
