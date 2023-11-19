package br.edu.ifnmg.gestaoprocessos.data.applicant;

import br.edu.ifnmg.gestaoprocessos.domain.applicant.ApplicantEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.ifnmg.gestaoprocessos.data.base.GenericDao;

@Stateless
public class ApplicantDao extends GenericDao implements ApplicantDaoLocal {

    @Override
    public void save(ApplicantEntity applicant) {
       super.saveOrUpdate(applicant);
    }
    
}
