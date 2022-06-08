package bg.manhattan.pathfinder.repository;

import bg.manhattan.pathfinder.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    @Query("SELECT r " +
            "FROM Route r " +
            "WHERE size(r.comments) = (SELECT max(size(r1.comments)) FROM Route r1)")
    Route findMostCommented();
}
