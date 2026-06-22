package org.formation.projet4.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    // Pointcut réutilisable (plus propre que répéter l'expression)
    @Pointcut("execution(* org.formation.projet4.services.*.get*ById(..))")
    public void serviceMethods() {}

    @Around("serviceMethods()")
    public Object checkRole(ProceedingJoinPoint pjp) throws Throwable {
        return pjp.proceed();
    }

}

