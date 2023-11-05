package br.edu.ifnmg.gestaoprocessos.domain.applicant.dtos;

import br.edu.ifnmg.gestaoprocessos.domain.user.dtos.ReqCreateUser;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ReqCreateApplicant extends ReqCreateUser {
    
    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;
    
    @NotNull
    private LocalDate birthDate; 

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    //</editor-fold>
    
}
