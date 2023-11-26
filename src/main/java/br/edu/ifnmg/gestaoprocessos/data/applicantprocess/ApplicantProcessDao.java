package br.edu.ifnmg.gestaoprocessos.data.applicantprocess;

import br.edu.ifnmg.gestaoprocessos.data.base.BaseDao;
import br.edu.ifnmg.gestaoprocessos.domain.applicantprocess.ApplicantProcessDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.applicantprocess.ApplicantProcessEntity;
import javax.ejb.Stateless;

public class ApplicantProcessDao extends BaseDao implements ApplicantProcessDaoLocal {

    @Override
    public void save(ApplicantProcessEntity applicantProcessEntity) {
        super.saveOrUpdate(applicantProcessEntity);
    }

}
