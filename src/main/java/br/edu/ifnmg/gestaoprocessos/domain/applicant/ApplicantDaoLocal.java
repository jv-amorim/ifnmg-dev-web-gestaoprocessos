package br.edu.ifnmg.gestaoprocessos.domain.applicant;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseDaoLocal;
import java.util.List;

public interface ApplicantDaoLocal extends BaseDaoLocal {

    void save(ApplicantEntity applicant);

    List<ApplicantEntity> listAll();

}
