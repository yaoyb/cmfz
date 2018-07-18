import com.baizhi.cmfz.dao.*;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.service.MasterService;
import com.baizhi.cmfz.service.MenuService;
import com.baizhi.cmfz.service.PictureService;
import com.baizhi.cmfz.service.impl.ManagerServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by 姚亚博 on 2018/7/4.
 */
public class test {

    @Test
    public void aa(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

//        OperationDao od = (OperationDao) ac.getBean("operationDao");
//        System.out.println(od.selectAll(1,1));

//        Master m = new Master("200","aa","ss","dd");
//        MasterService ms = (MasterService) ac.getBean("masterServiceImpl");
//        System.out.println(ms.add(m));

//        ManagerDao md = (ManagerDao) ac.getBean("managerDao");
//        System.out.println(md.selectOne("zs"));

//        ManagerService ms = (ManagerService) ac.getBean("managerServiceImpl");
//        System.out.println(ms.queryOne("zs","123"));

//        MenuDao md = (MenuDao) ac.getBean("menuDao");
//        System.out.println(md.selectAllFirst());
//        System.out.println(md.selectSecond("100"));

//        MenuService ms = (MenuService) ac.getBean("menuServiceImpl");
//        System.out.println(ms.querySecond("100"));
//        System.out.println(ms.queryAllFirst());

//        PictureDao pd = (PictureDao) ac.getBean("pictureDao");
//        Picture p = new Picture("1010");
//        p.setPicture_description("1111");
//        System.out.println(pd.delete("1010"));
//        System.out.println(pd.selectAll(0,2));

//        PictureService ps = (PictureService) ac.getBean("pictureServiceImpl");
//        System.out.println(ps.queryAll(1,1));

//        Picture p = new Picture("200","aaa",new Date(),"aaa","aaa");
//        System.out.println(ps.add(p));
//        p.setPictureStatus("aaa");
//        System.out.println(ps.modify(p));

//        MasterDao md = (MasterDao) ac.getBean("masterDao");
//        Master m = new Master("11","aa","ww","ww");
//        System.out.println(md.updata(m));
//        System.out.println(md.selectByName(0,2,"%爱%"));
//        System.out.println(md.selectAll(0,2));

        MasterService ms = (MasterService) ac.getBean("masterServiceImpl");
        System.out.println(ms.add(new Master("a9999","a","a","a")));
//        System.out.println(ms.queryAll(1,2));
//        System.out.println(ms.queryByName(1,2,"%国%"));


    }
}
