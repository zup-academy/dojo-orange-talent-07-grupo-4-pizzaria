package br.com.zup.edu.pizzaria.shared.validators;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UniqueValueValidator implements ConstraintValidator<UniqueValue,String> {
    private String atribute;
    private String className;
    private final EntityManager manager;

    public UniqueValueValidator(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        atribute=constraintAnnotation.domainAtribute();
        className=constraintAnnotation.domainClass().getSimpleName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        String jpql="SELECT r FROM "+className+" r WHERE r."+atribute+" =:value";

        Query possivelRegistroUnico = manager.createQuery(jpql);

        possivelRegistroUnico.setParameter("value",value);

        return possivelRegistroUnico.getResultList().isEmpty();
    }
}
