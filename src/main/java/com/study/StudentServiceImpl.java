package com.study;

import com.study.com.entity.StudentVO;
import com.study.com.entity.Teacher;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.*;

@Component
@WebService(serviceName = "StudentSer", endpointInterface= "com.study.StudentService")
public class StudentServiceImpl implements StudentService{

    @WebMethod
    public List<StudentVO> students() {
        final ArrayList list = new ArrayList();
        list.add(new StudentVO(1,"宝强",88,new Date()));
        list.add(new StudentVO(1,"丫丫",29,new Date()));
        list.add(new StudentVO(1,"丫丫好美,好想*************丫丫",88,new Date(),99));
        return list;
    }

    @WebMethod
    public StudentVO studentxiaoming() {
        final StudentVO t = new StudentVO(1, "小明", 29, new Date(), 99);
        final ArrayList list = new ArrayList();
        list.add(new Teacher("张老师","数学",1));
        list.add(new Teacher("王老师","语文",2));
        t.setTeachers(list);
        return t;
    }

    @WebMethod
    public StudentVO student(String sNo) {
        return new StudentVO(Integer.parseInt(sNo),"丫丫好美",29, new Date(),99);
    }

    @Override
    public Map<String, Teacher> mapdemo() {
        Map map = new HashMap();
        map.put("meiguo", new Teacher("陈老师","语文",2));
        map.put("meiguo2", new Teacher("王老师","语文",2));
        return map;
    }
    @Override
    public Map<String, Object> mapdemo2() {
        Map map = new HashMap();
        map.put("meiguo", new Teacher("陈老师","语文",2));
        map.put("meiguo2", new Teacher("王老师","语文",2));
        map.put("riben",new StudentVO(1, "新恒结衣", 29, new Date(), 99));
        map.put("riben2",new StudentVO(1, "波多野结衣", 29, new Date(), 99));
        map.put("riben3",new StudentVO(1, "佟丽娅", 29, new Date(), 99));
        map.put("riben4",new StudentVO(1, "斯嘉丽.约翰逊", 29, new Date(), 99));
        return map;
    }
    @Override
    public HashMap jsondemo() {
        HashMap map = new HashMap();
        map.put("riben",new StudentVO(1, "新恒结衣", 29, new Date(), 99));
        map.put("riben2",new StudentVO(1, "波多野结衣", 29, new Date(), 99));
        final ArrayList list = new ArrayList();
        list.add(new Teacher("宝强","演员",2));
        list.add(new Teacher("陈思成","导演",2));
        list.add(new Teacher("魏大勋","编剧",2));
        map.put("riben3",new StudentVO(1, "佟丽娅", 29, new Date(), 99,list));
        return map;
    }
}
