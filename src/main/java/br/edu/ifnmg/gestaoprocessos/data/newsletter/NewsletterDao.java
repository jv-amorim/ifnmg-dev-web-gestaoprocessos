package br.edu.ifnmg.gestaoprocessos.data.newsletter;

import br.edu.ifnmg.gestaoprocessos.data.base.BaseDao;
import br.edu.ifnmg.gestaoprocessos.domain.newsletter.NewsletterDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.newsletter.NewsletterEntity;
import javax.ejb.Stateless;

@Stateless
public class NewsletterDao extends BaseDao implements NewsletterDaoLocal {

    @Override
    public void save(NewsletterEntity newsletterEntity) {
        super.saveOrUpdate(newsletterEntity);
    }

}
