package ar.edu.unju.fi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TrackingCamionesProyectoFinalApplicationTests {
	
	/*
	@Autowired
	ITripulanteRepository tripulanteRepository;
	
	@Autowired
	IVehiculoRepository vehiculoRepository;
	
	@Autowired
	ILocalidadService localidadService;
	
	@Autowired
	IRegistroTrackingRepository registroTrackingRepository;
	
	*/
	
	@Test
	void contextLoads() {
		
		/*
		Tripulante tripulante1 = new Tripulante();
		Tripulante tripulante2 = new Tripulante();
		
		tripulante1.setDocumento("41654188");
		tripulante1.setNombres("Juan");
		tripulante1.setApellido("Perez");
		tripulante1.setNacionalidad("Argentina");
		
		tripulante2.setDocumento("41654188");
		tripulante2.setNombres("Lucas");
		tripulante2.setApellido("Perez");
		tripulante2.setNacionalidad("Argentina");
		
		tripulanteRepository.save(tripulante1);
		tripulanteRepository.save(tripulante2);
		
		//List<Tripulante> tripulantes = new ArrayList<Tripulante>();
		Iterable<Tripulante> iteratorTripulantes = tripulanteRepository.findAll();
		
		List<Tripulante> tripulantes = new ArrayList<Tripulante>();
		//while ( iteratorTripulantes.h);
		
		iteratorTripulantes.forEach(tripulantes::add);
		
		//tripulantes.add(tripulanteRepository.findAll());
		//tripulantes.add(tripulante2);
		
		Vehiculo vehiculo = new Vehiculo();
		
		vehiculo.setColor("Azul");
		vehiculo.setMarca("Mercedes Benz");
		vehiculo.setModelo("2006");
		vehiculo.setNumeroChasis("1234567890");
		vehiculo.setNumeroMotor("1234567890123");
		vehiculo.setPatente("WJD 123");
		vehiculo.setTipo("Camion");
		vehiculo.setTitular("Juan de Montreal");
		
		vehiculoRepository.save(vehiculo);
		
		Iterable<Vehiculo> iterableVehiculo = vehiculoRepository.findAll();
		
		Vehiculo vehiculoNuevo = new Vehiculo();
		
		vehiculoNuevo = iterableVehiculo.iterator().next();
		
		Iterable<Localidad> localidades = localidadService.listarLocalidades();
		
		Localidad localidad = new Localidad();
		
		localidad = localidades.iterator().next();
		
		RegistroTracking registro1 = new RegistroTracking();
		
		registro1.setDetalleLugarRegistro("-------------------------------");
		registro1.setFechaHora(LocalDateTime.of(2020, 04, 23, 12, 30, 12));
		registro1.setTripulantes(tripulantes);
		registro1.setVehiculo(vehiculoNuevo);
		registro1.setLocalidad(localidad);
		
		registroTrackingRepository.save(registro1);
		
		Iterable<RegistroTracking> regist  = registroTrackingRepository.findAll();
		
		RegistroTracking registro = new RegistroTracking();
		
		registro = regist.iterator().next();
		
		System.out.println(registro); */
		
	}

}
