package br.edu.ifnmg.gestaoprocessos.data.applicant;

import javax.ejb.Stateless;

import br.edu.ifnmg.gestaoprocessos.data.base.GenericDao;
import br.edu.ifnmg.gestaoprocessos.domain.applicant.NewsletterEntity;

@Stateless
public class NewsletterDao extends GenericDao implements NewsletterDaoLocal{

	@Override
	public void save(NewsletterEntity newsletterEntity) {
		super.saveOrUpdate(newsletterEntity);
	}	


}
