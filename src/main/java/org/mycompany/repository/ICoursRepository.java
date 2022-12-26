package org.mycompany.repository;

import java.util.List;

import org.mycompany.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface ICoursRepository extends JpaRepository<Cours, Integer>{
	
	@Query(value = "select ENSEIGNANT from Cours_Projet", nativeQuery = true)
	List<Cours> listeEnseignant();

}
