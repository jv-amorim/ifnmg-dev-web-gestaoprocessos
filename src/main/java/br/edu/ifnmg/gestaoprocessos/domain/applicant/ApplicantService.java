package br.edu.ifnmg.gestaoprocessos.domain.applicant;

import br.edu.ifnmg.gestaoprocessos.domain.applicant.dtos.ReqCreateApplicant;
import br.edu.ifnmg.gestaoprocessos.domain.applicant.dtos.ResCreateApplicant;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserEntity;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserServiceLocal;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Singleton
@Transactional
public class ApplicantService implements ApplicantServiceLocal {
    
    @Inject ApplicantDaoLocal applicantDao;
    @Inject UserServiceLocal userService;

    @Override
    public ResCreateApplicant create(ReqCreateApplicant req) throws Exception {
        validateReqCreateApplicant(req);
        
        UserEntity user = userService.create(req);
        
        ApplicantEntity applicant = new ApplicantEntity();
        applicant.setCpf(req.getCpf());
        applicant.setBirthdate(req.getBirthDate());
        applicant.setEmailVerified(false);
        applicant.setUser(user);
        
        applicantDao.save(applicant);
        
        ResCreateApplicant res = new ResCreateApplicant();
        res.setApplicantId(applicant.getId());
        return res;
    }

    private void validateReqCreateApplicant(ReqCreateApplicant req) throws Exception {
        // TODO - Validate birth of date.
        // TODO - Validate if exists user with same CPF.
    }
    
}
