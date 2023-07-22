package com.example.shop.loger;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class LoggerImpl {
    private static final Logger logger = LogManager.getLogger(LoggerImpl.class);;

    @Around("@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String name =  joinPoint.getSignature().getName();
        logger.info("Вызван метод :" + name);
 Object     returnedByMethod  =    joinPoint.proceed();
        logger.info("Метод завершен");

return returnedByMethod;
    }

}
