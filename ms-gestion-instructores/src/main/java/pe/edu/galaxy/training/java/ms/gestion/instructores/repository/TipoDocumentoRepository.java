package pe.edu.galaxy.training.java.ms.gestion.instructores.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.galaxy.training.java.ms.gestion.instructores.entity.TipoDocumentoEntity;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoEntity, Integer> {
	@Query("select p from TipoDocumentoEntity p where p.estado='1'")//JPQL
	List<TipoDocumentoEntity> getAllCustom();
	

}
