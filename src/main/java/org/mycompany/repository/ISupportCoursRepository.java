package org.mycompany.repository;

import org.mycompany.model.SupportCours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupportCoursRepository extends JpaRepository<SupportCours, Integer> {

}
