package br.edu.ifnmg.gestaoprocessos.data.applicant;

import br.edu.ifnmg.gestaoprocessos.data.base.BaseDao;
import br.edu.ifnmg.gestaoprocessos.domain.applicant.ApplicantDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.applicant.ApplicantEntity;
import javax.ejb.Stateless;

@Stateless
public class ApplicantDao extends BaseDao implements ApplicantDaoLocal {

    @Override
    public void save(ApplicantEntity applicant) {
        super.saveOrUpdate(applicant);
    }

}
