package cc.secondbrain.demo.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Log4j2
@Aspect
@Component
public class TimeLogAspect {

    @Around("logTime() || controller()")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        long startMillis = System.currentTimeMillis();
        Object proceed = pjp.proceed();
        long executionTime = System.currentTimeMillis() - startMillis;
        log.info(String.format("Completed %s in %d ms", pjp.getSignature().toShortString(), executionTime));
        return proceed;
    }

    @Pointcut("@annotation(cc.secondbrain.demo.annotation.TimeLog)")
    public void logTime() {
    }

    @Pointcut("execution(* cc.secondbrain.demo.controller.*.*(..))")
    public void controller() {
    }

}
