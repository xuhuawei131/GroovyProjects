package demo

import object.Person

/**
 * 模拟一个应用的管理类
 */
class ApplicationManager {
    /**
     * 在这里注册我们的metaClass的全局拓展
     */
    static void init(){
        ExpandoMetaClass.enableGlobally()
        //为第三方类添加方法
        Person.metaClass.static.createPerson={
            String name,int age->
                return new Person(name:name,age:age)
        }
    }
}
