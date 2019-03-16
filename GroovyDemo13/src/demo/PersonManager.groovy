package demo

import object.Person

/**
 * Person类的管理器
 */
class PersonManager {
    //我们在这里去使用我们扩展的全局的Person方法
    static Person createPerson(String name,int age){
        return Person.createPerson(name,age)
    }
}
