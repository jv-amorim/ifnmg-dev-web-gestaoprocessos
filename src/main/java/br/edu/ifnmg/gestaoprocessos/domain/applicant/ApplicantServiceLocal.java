package br.edu.ifnmg.gestaoprocessos.domain.applicant;

import br.edu.ifnmg.gestaoprocessos.domain.applicant.dtos.ReqCreateApplicant;
import br.edu.ifnmg.gestaoprocessos.domain.applicant.dtos.ResCreateApplicant;

public interface ApplicantServiceLocal {

    ResCreateApplicant create(ReqCreateApplicant req) throws Exception;

}
