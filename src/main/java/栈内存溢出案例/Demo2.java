package 栈内存溢出案例;

/**
 * <p>
 * 功能描述: 演示工具类（非自己写的类，也会出现栈内存溢出的问题）
 * 由于两个类的循环引用导致的json解析时导致的栈内存溢出
 * </p>
 *
 * @author Hanxuewei
 * @since 2025/10/3
 */
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

class Emp {
    private String name;
    // 一个员工属于一个部门
    private Dept dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}

class Dept {
    private String name;
    // 一个部门可以有多个员工
    private List<Emp> emps;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }
}

/**
 * json 数据转换
 */
public class Demo2 {

    public static void main(String[] args) throws JsonProcessingException {
        Dept d = new Dept();
        d.setName("Market");

        Emp e1 = new Emp();
        e1.setName("Zhang");
        e1.setDept(d);

        Emp e2 = new Emp();
        e2.setName("Li");
        e2.setDept(d);

        d.setEmps(Arrays.asList(e1, e2));

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(d));
    }
}
