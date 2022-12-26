package org.mycompany.repository;

import org.mycompany.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICoursRepository extends JpaRepository<Cours, Integer>{

}
