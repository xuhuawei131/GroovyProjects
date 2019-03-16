package demo
/**
 * 整个demo的入口
 */
class Entry {
    public static void main(String[] args) {
        println '应用程序正在启动'
        //初始化 注册我们全局的metaClass方法
        ApplicationManager.init()
        println '应用程序初始化完成'
        //使用我们metaClass进行扩展的方法
        def person=PersonManager.createPerson('renzhiqaing',50)
        println "the name is ${person.name},and the age is ${person.age}"
    }
}
