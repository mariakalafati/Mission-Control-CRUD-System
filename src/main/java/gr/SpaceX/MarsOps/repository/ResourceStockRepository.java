package gr.SpaceX.MarsOps.repository;

import gr.SpaceX.MarsOps.model.ResourceStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceStockRepository extends JpaRepository<ResourceStock, Long> {
}
