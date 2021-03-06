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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * 日志生成
 * Created by 姚亚博 on 2018/7/9.
 */
@Aspect
public class Advice {

    @Pointcut("execution(* com.baizhi.cmfz.service.impl.*.modify*(..))||execution(* com.baizhi.cmfz.service.impl.*.add*(..))||execution(* com.baizhi.cmfz.service.impl.*.remove*(..))")
    public void po(){}

    @Around("po()")
    public Object around(ProceedingJoinPoint pjp){
        String result="false";
        Object obj = null;
        try{
            obj = pjp.proceed();
            result="success";
        }catch (Throwable e){
        }

        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();

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
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        Manager manager = (Manager) session.getAttribute("manager");
        operation.setManager(manager);

        operation.setOperationResult(result);

//        System.out.println("aaaaaa"+operation);

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        OperationDao od = (OperationDao) applicationContext.getBean("operationDao");

        od.insert(operation);

        return obj;
    }
}
