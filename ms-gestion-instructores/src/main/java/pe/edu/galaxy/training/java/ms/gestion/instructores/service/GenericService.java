package pe.edu.galaxy.training.java.ms.gestion.instructores.service;

import java.util.List;
import java.util.Optional;

import pe.edu.galaxy.training.java.ms.gestion.instructores.service.exception.ServiceException;

//aqui vas a crear los metodos parametrizados de tipo T
public interface GenericService<T> {

	List<T> findLike(T t) throws ServiceException;
	
	Optional<T> findById(T t) throws ServiceException;//esto me trae un obejto
	
	T save(T t) throws ServiceException;//insert,update,delet... lo que pasa es que se esta 
	//que hace el borrado logico(estado de 1 a 0)
	//cuand trabajas en Jpa puedes hacer un borrado logico
	
}
