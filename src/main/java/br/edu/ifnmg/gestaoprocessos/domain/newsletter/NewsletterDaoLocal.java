package br.edu.ifnmg.gestaoprocessos.domain.newsletter;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseDaoLocal;

public interface NewsletterDaoLocal extends BaseDaoLocal {

    void save(NewsletterEntity newsletterEntity);

}
