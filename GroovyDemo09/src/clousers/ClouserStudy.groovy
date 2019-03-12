package clousers

def scruptClouser={
    println "scriptClouser this:${this}"//闭包定义处的类
    println "scriptClouser owner:${owner}"//代表闭包定义处的类或者对象；
    println "scriptClouser delegate:${delegate}" //任意一个对象 默认是owner
}
//scruptClouser.call()


//定义一个内部类 因为外部类是ClouserStudy这个类
class Person{
    def static classClourser={
        println "scriptClouser this:${this}"//会指向定义闭包的类
        println "scriptClouser owner:${owner}"//代表闭包定义处的类或者嵌套的闭包的对象；
        println "scriptClouser delegate:${delegate}"
    }
    def static  say(){
        def  classClourser={
            println "methodClouser this:${this}"//闭包定义处的类
            println "methodClouser owner:${owner}"//代表闭包定义处的类或者对象；
            println "methodClouser delegate:${delegate}"
        }
        classClourser.call()
    }
}
//Person.classClourser.call()
//Person.say()


//我们这次去掉static静态修饰
class Person1{
    def  classClourser={
        println "scriptClouser this:${this}"//会指向定义闭包的类
        println "scriptClouser owner:${owner}"//代表闭包定义处的类或者嵌套的闭包的对象；
        println "scriptClouser delegate:${delegate}"
    }
    def   say(){
        def  classClourser={
            println "methodClouser this:${this}"//闭包定义处的类
            println "methodClouser owner:${owner}"//代表闭包定义处的类或者对象；
            println "methodClouser delegate:${delegate}"
        }
        classClourser.call()
    }
}

Person1 person1=new Person1()
//person1.classClourser.call()
//person1.say()


//定义嵌套闭包
def nestClouser={
    def innerClouser={
        println "innerClouser this:"+this//会指向定义闭包的类
        println "innerClouser owner"+owner//代表闭包定义处的类或者嵌套的闭包的对象；
        println "innerClouser delegate:"+delegate
    }
//    innerClouser.delegate=person1//
    innerClouser.call()
}
//nestClouser.call()

//闭包的委托策略
class Student{
    String name
    def pretty={"My Name is ${name}"}
    String toString(){
        pretty.call()
    }
}
class Teacher{
    String name1
}

def stu=new Student(name:"Xuhuawei")//由于类中有一个属性叫做name 所以可以在构造方法中直接赋值
def tea=new Teacher(name1:"Majinfeng")

stu.pretty.delegate=tea
//stu.pretty.resolveStrategy=Closure.DELEGATE_FIRST
stu.pretty.resolveStrategy=Closure.DELEGATE_ONLY
println stu.toString()