package br.edu.ifnmg.gestaoprocessos.domain.applicantprocess;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseDaoLocal;

public interface ApplicantProcessDaoLocal extends BaseDaoLocal {

    void save(ApplicantProcessEntity applicantProcessEntity);

}
