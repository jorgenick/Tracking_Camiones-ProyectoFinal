package ar.edu.unju.fi.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.fi.tracking.model.Vehiculo;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long>{

	@Query
	public List<Vehiculo> obtenerVehiculos();
//	@Query("from Vehiculo e order by e.nombre desc")

}
