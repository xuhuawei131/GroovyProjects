package object

//定义对象的 方法跟java是一样的
def person=new Person()
//为类中的属性指定一个初始值
def person1=new Person(name:'xuhuawei',age:25)
//也可以仅仅指定一个
def person2=new Person(name:'xiaoming')//如果不指定，那么integer默认值是null 因为是对象integer

println "the name is ${person1.name},the age is ${person1.age}"
println "the name is ${person2.name},the age is ${person2.age}"

//Groovy中点操作符 其实调用的是get或者set方法
println "the name is ${person.getName()},the age is ${person.getAge()}"
//调用方法
person2.increaseAge(10)