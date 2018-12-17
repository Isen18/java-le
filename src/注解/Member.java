package 注解;

import 注解.annotation.*;

/**
 * Member
 * 数据库表Member对应实例类bean
 * @author Isen
 * @description
 * @date 2018/8/1 17:22
 **/
@DBTable(name = "Member")
public class Member {

    @SQLString(name = "ID",value = 50, constraint = @Constraints(primaryKey = true))
    private String id;

    @SQLString(name = "NAME" , value = 30)
    private String name;

    @SQLInteger(name = "AGE")
    private int age;

    @SQLString(name = "DESCRIPTION" ,value = 150 , constraint = @Constraints(allowNull = true))
    private String description;
}
