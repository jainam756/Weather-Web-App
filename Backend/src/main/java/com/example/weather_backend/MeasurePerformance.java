package com.example.weather_backend;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MeasurePerformance {

    @Pointcut("execution(* com.example.weather_backend.ExternalWeatherService.fetchWeatherData(..))")
    public void monitor() { }

    @Around("monitor()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Data fetched in : " + elapsedTime + " milliseconds.");
        return output;
    }
}

