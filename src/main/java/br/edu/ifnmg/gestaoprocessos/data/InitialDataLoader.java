package br.edu.ifnmg.gestaoprocessos.data;

import br.edu.ifnmg.gestaoprocessos.domain.applicant.ApplicantDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.applicant.ApplicantEntity;
import br.edu.ifnmg.gestaoprocessos.domain.selectionprocess.SelectionProcessDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.selectionprocess.SelectionProcessEntity;
import br.edu.ifnmg.gestaoprocessos.domain.selectionprocess.SelectionProcessStatus;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserEntity;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserRole;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserServiceLocal;
import java.time.LocalDate;
import java.time.Month;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class InitialDataLoader {

    @Inject
    private UserDaoLocal userDao;
    @Inject
    private ApplicantDaoLocal applicantDao;
    @Inject
    private SelectionProcessDaoLocal processDao;
    @Inject
    private UserServiceLocal userService;

    @PostConstruct
    public void execute() {
        //<editor-fold defaultstate="collapsed" desc="User">
        UserEntity user1 = new UserEntity();
        user1.setRole(UserRole.ADMIN);
        user1.setName("Admin");
        user1.setEmail("admin@ifnmg.edu.br");
        user1.setPasswordHash(userService.generatePasswordHash("admin123"));

        UserEntity user2 = new UserEntity();
        user2.setRole(UserRole.EDITOR);
        user2.setName("João Amorim");
        user2.setEmail("jvpa1@aluno.ifnmg.edu.br");
        user2.setPasswordHash(userService.generatePasswordHash("joao123"));

        UserEntity user3 = new UserEntity();
        user3.setRole(UserRole.EDITOR);
        user3.setName("Diego Magalhães");
        user3.setEmail("dgmb1@aluno.ifnmg.edu.br");
        user3.setPasswordHash(userService.generatePasswordHash("diego123"));

        UserEntity user4 = new UserEntity();
        user4.setRole(UserRole.APPLICANT);
        user4.setName("Ana Zaira");
        user4.setEmail("anazaira@mail.com");
        user4.setPasswordHash(userService.generatePasswordHash("ana123"));

        UserEntity user5 = new UserEntity();
        user5.setRole(UserRole.APPLICANT);
        user5.setName("Beatriz Yana");
        user5.setEmail("beatrizyana@mail.com");
        user5.setPasswordHash(userService.generatePasswordHash("beatriz123"));

        userDao.save(user1);
        userDao.save(user2);
        userDao.save(user3);
        userDao.save(user4);
        userDao.save(user5);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Applicant">
        ApplicantEntity applicant1 = new ApplicantEntity();
        applicant1.setCpf("12345678910");
        applicant1.setBirthdate(LocalDate.of(2001, Month.JANUARY, 1));
        applicant1.setEmailVerified(false);
        applicant1.setNewsletterOptIn(false);
        applicant1.setUser(user4);

        ApplicantEntity applicant2 = new ApplicantEntity();
        applicant2.setCpf("01987654321");
        applicant2.setBirthdate(LocalDate.of(2002, Month.DECEMBER, 31));
        applicant2.setEmailVerified(true);
        applicant2.setNewsletterOptIn(true);
        applicant2.setUser(user5);

        applicantDao.save(applicant1);
        applicantDao.save(applicant2);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Selection Process">
        SelectionProcessEntity process1 = new SelectionProcessEntity();
        process1.setName("Processo Seletivo 2022/1");
        process1.setStatus(SelectionProcessStatus.CLOSED);
        process1.setOpenAt(LocalDate.of(2022, Month.FEBRUARY, 1));
        process1.setClosedAt(LocalDate.of(2022, Month.JUNE, 1));

        SelectionProcessEntity process2 = new SelectionProcessEntity();
        process2.setName("Processo Seletivo 2022/2");
        process2.setStatus(SelectionProcessStatus.CLOSED);
        process2.setOpenAt(LocalDate.of(2022, Month.OCTOBER, 1));
        process2.setClosedAt(LocalDate.of(2022, Month.DECEMBER, 1));

        SelectionProcessEntity process3 = new SelectionProcessEntity();
        process3.setName("Processo Seletivo 2023/1");
        process3.setStatus(SelectionProcessStatus.OPEN);
        process3.setOpenAt(LocalDate.of(2023, Month.APRIL, 1));
        process3.setClosedAt(null);

        processDao.save(process1);
        processDao.save(process2);
        processDao.save(process3);
        //</editor-fold>
    }

}
