import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.service.impl.ManagerServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 姚亚博 on 2018/7/4.
 */
public class test {

    @Test
    public void aaa(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
       /* ManagerService managerService = (ManagerService) applicationContext.getBean("managerServiceImpl");
        Manager manager = managerService.queryManagerByName("吴","123456");
        System.out.println(manager);*/
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        ManagerDao md = (ManagerDao) ac.getBean("managerDao");
//        System.out.println(md.selectOne("1000"));

        ManagerService ms = (ManagerService) ac.getBean("managerServiceImpl");
        System.out.println(ms.queryOne("zs","12"));
    }
}
