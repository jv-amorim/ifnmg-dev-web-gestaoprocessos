package br.edu.ifnmg.gestaoprocessos.data.applicant;

import javax.ejb.Stateless;

import br.edu.ifnmg.gestaoprocessos.data.base.GenericDao;
import br.edu.ifnmg.gestaoprocessos.domain.applicant.ApplicantEntity;
import br.edu.ifnmg.gestaoprocessos.domain.applicant.ApplicantProcessEntity;

@Stateless
public class ApplicantProcessDao extends GenericDao implements ApplicantProcessDaoLocal{

	@Override
	public void save(ApplicantProcessEntity applicantProcessEntity) {
		super.saveOrUpdate(applicantProcessEntity);
	}
	
}
