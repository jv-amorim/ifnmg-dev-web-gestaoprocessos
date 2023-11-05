package br.edu.ifnmg.gestaoprocessos.data.applicant;

import br.edu.ifnmg.gestaoprocessos.domain.applicant.ApplicantEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.edu.ifnmg.gestaoprocessos.domain.applicant.ApplicantDaoLocal;

@Stateless
public class ApplicantDao implements ApplicantDaoLocal {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(ApplicantEntity applicant) {
        if (applicant.getId() == null) {
            entityManager.persist(applicant);
        } else {
            applicant.refreshUpdatedAt();
            entityManager.merge(applicant);
        }
    }
    
}
