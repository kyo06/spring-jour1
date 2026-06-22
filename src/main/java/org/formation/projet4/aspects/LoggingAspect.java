package org.formation.projet4.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Pointcut réutilisable (plus propre que répéter l'expression)
    @Pointcut("execution(* org.formation.projet4.services.*.set*ById(..))")
    public void serviceMethods() {}

    @Before("serviceMethods()")
    public void beforeMethod(JoinPoint jp) {
        System.out.println("[BEFORE] Méthode : " + jp.getSignature().getName());
        System.out.println("Arguments : ");
        for (Object arg : jp.getArgs()) {
            System.out.println(" - " + arg);
        }
    }

    @After("serviceMethods()")
    public void afterMethod(JoinPoint jp) {
        System.out.println("[AFTER] Fin de la méthode : " + jp.getSignature().getName());
    }

    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void afterSuccess(JoinPoint jp, Object result) {
        System.out.println("[AFTER RETURNING] Méthode : " + jp.getSignature().getName());
        System.out.println("Résultat : " + result);
    }

    @AfterThrowing(pointcut = "serviceMethods()", throwing = "ex")
    public void afterError(JoinPoint jp, Exception ex) {
        System.out.println("[AFTER THROWING] Méthode : " + jp.getSignature().getName());
        System.out.println("Erreur : " + ex.getMessage());
    }

    @Around("serviceMethods()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        long start = System.currentTimeMillis();

        String methodName = pjp.getSignature().getName();

        System.out.println("[AROUND - BEFORE] Méthode : " + methodName);
        System.out.println("Arguments : " + (Object) pjp.getArgs());

        Object result;

        try {
            // exécution réelle de la méthode
            result = pjp.proceed();

            long duration = System.currentTimeMillis() - start;

            System.out.println("[AROUND - SUCCESS] Méthode : " + methodName);
            System.out.println("Résultat : " + result);
            System.out.println("Temps d'exécution : " + duration + " ms");

            return result;

        } catch (Throwable ex) {

            long duration = System.currentTimeMillis() - start;

            System.out.println("[AROUND - ERROR] Méthode : " + methodName);
            System.out.println("Temps avant erreur : " + duration + " ms");

            throw ex; // IMPORTANT : ne pas avaler l'exception
        } finally {
            System.out.println("[AROUND - FIN] Méthode : " + methodName);
        }
    }

}
