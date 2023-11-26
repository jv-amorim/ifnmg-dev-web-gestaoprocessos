package br.edu.ifnmg.gestaoprocessos.domain.user;

import br.edu.ifnmg.gestaoprocessos.domain.user.dtos.ReqCreateUser;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.transaction.Transactional;

@Singleton
@Transactional
public class UserService implements UserServiceLocal {

    @Inject
    private UserDaoLocal userDao;
    @Inject
    private Pbkdf2PasswordHash passwordHasher;

    private Boolean isHasherInitialized = false;

    @Override
    public String generatePasswordHash(String password) {
        if (!isHasherInitialized) {
            Map<String, String> parameters = new HashMap<>();
            parameters.put("Pbkdf2PasswordHash.Iterations", "3071");
            parameters.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA512");
            parameters.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");
            passwordHasher.initialize(parameters);
            isHasherInitialized = true;
        }
        return passwordHasher.generate(password.toCharArray());
    }

    @Override
    public UserEntity create(ReqCreateUser req) throws Exception {
        validateReqCreateUser(req);

        UserEntity user = new UserEntity();
        user.setRole(UserRole.APPLICANT);
        user.setName(req.getName().trim());
        user.setEmail(req.getEmail().trim());
        user.setPasswordHash(generatePasswordHash(req.getPassword()));

        userDao.save(user);

        return user;
    }

    private void validateReqCreateUser(ReqCreateUser req) throws Exception {
        if (req == null) {
            throw new Exception("Nenhum dado informado.");
        }
        if (req.getName().trim().split("\\s+").length < 2) {
            throw new Exception("É necessário informar o nome e sobrenome.");
        }
        if (!req.getPassword().equals(req.getPasswordConfirmation())) {
            throw new Exception("A senha e a confirmação não correspondem.");
        }

        // TODO - Validate if exists user with same email.
    }

    @Override
    public UserEntity createEditor(ReqCreateUser req) throws Exception {
        validateReqCreateUser(req);

        throw new UnsupportedOperationException("Not supported yet.");
    }

}
