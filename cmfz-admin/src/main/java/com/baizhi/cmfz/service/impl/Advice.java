package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.OperationDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Operation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * Created by 姚亚博 on 2018/7/9.
 */
@Aspect
public class Advice {

    @Autowired
    private OperationDao od;

    @Pointcut("execution(* com.baizhi.cmfz.service.impl.*.modify*(..))||execution(* com.baizhi.cmfz.service.impl.*.add*(..))||execution(* com.baizhi.cmfz.service.impl.*.remove*(..))")
    public void po(){}

    /*@Around("po()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("---前置消息----");
        String result;
        Object obj = null;
        try{
            obj = pjp.proceed();
            result="success";
        }catch (Exception e){
            result="false";
        }

        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("111"+method.toString());
        System.out.println("aaaa"+method.getGenericParameterTypes().toString());

        Operation operation = new Operation();

        String ID = UUID.randomUUID().toString().replace("-","");
        operation.setOperationId(ID);

        Date date = new Date();
        operation.setOperationTime(date);

        String methodStr = method.toString();
        int index = methodStr.lastIndexOf(".");
        String resource = methodStr.substring(index+1,methodStr.length()-1);
        operation.setOperationResource(resource);

        String methodName = method.getName();
        operation.setOperationAction(methodName);

        Object[] args = pjp.getArgs();
        operation.setOperationMassage(args[0].toString());

//        Manager manager = (Manager) session.getAttribute("manage");
//        operation.setManager(manager);

        operation.setOperationResult(result);

        System.out.println("operation"+operation);

        od.insert(operation);

        return obj;
    }*/
}
