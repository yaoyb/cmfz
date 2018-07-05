import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.service.MenuService;
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

        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

//        ManagerDao md = (ManagerDao) ac.getBean("managerDao");
//        System.out.println(md.selectOne("zs"));

//        ManagerService ms = (ManagerService) ac.getBean("managerServiceImpl");
//        System.out.println(ms.queryOne("zs","12"));

//        MenuDao md = (MenuDao) ac.getBean("menuDao");
//        System.out.println(md.selectAllFirst());
//        System.out.println(md.selectSecond("100"));

//        MenuService ms = (MenuService) ac.getBean("menuServiceImpl");
//        System.out.println(ms.querySecond("101"));
//        System.out.println(ms.queryAllFirst());
    }
}
