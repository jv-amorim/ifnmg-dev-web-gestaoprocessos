package br.edu.ifnmg.gestaoprocessos.data.applicant;

import br.edu.ifnmg.gestaoprocessos.domain.applicant.ApplicantEntity;
import br.edu.ifnmg.gestaoprocessos.domain.applicant.NewsletterEntity;

public interface NewsletterDaoLocal {

	void save(NewsletterEntity newsletterEntity);
	
}
