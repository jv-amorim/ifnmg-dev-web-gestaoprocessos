package br.edu.ifnmg.gestaoprocessos.data.applicant;

import br.edu.ifnmg.gestaoprocessos.data.base.BaseDao;
import br.edu.ifnmg.gestaoprocessos.domain.applicant.ApplicantDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.applicant.ApplicantEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class ApplicantDao extends BaseDao implements ApplicantDaoLocal {

    @Override
    public void save(ApplicantEntity applicant) {
        super.saveOrUpdate(applicant);
    }

    @Override
    public List<ApplicantEntity> listAll() {
        Query query = entityManager.createQuery("SELECT a FROM Applicant a");
        return query.getResultList();
    }

}
