package hd.backend.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component  //자동으로 스프링빈을 등록
@Aspect
public class TimeTraceAop {
//    @Around("execution(*hd.backend..*(..))") //모든 메소드
    @Around("execution(* hd.backend.service..*(..))")//service method에 걸음
    public Object execute(ProceedingJoinPoint joinPoint) throws  Throwable{
        long start = System.currentTimeMillis();
        pln("Start: "+start);
        try{
            Object result = joinPoint.proceed();
            return result;
        }finally {
            long end = System.currentTimeMillis();
            long timeMs = end - start;
            pln("##걸린시간: "+joinPoint.toString()+ ""+timeMs+"ms");
        }
    }
    void pln(String str){
        System.out.println(str);
    }
}
