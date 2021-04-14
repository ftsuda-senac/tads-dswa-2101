/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senad.tads.dsw.exemplosspring.validadores;

import br.senad.tads.dsw.exemplosspring.DadosPessoais;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author ftsuda
 */
public class RepetirSenhaValidator implements ConstraintValidator<RepetirSenha, DadosPessoais> {

    @Override
    public void initialize(RepetirSenha constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValid(DadosPessoais dados, ConstraintValidatorContext cvc) {
        String senha = dados.getSenha();
        String repetirSenha = dados.getRepetirSenha();
        return senha.equals(repetirSenha);
    }

}
