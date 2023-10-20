package demo.project.pd.workshop.demostatement.repository;


import demo.project.pd.workshop.demostatement.model.OfficeCab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeCabRepository extends JpaRepository<OfficeCab,Long> {



}
