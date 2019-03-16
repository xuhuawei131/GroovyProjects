package object

def person=new Person(name:'xhw',age: 25)
println person.cry()//调用一个不存在的方法

//将后面的metaClass设置为全局可用的
ExpandoMetaClass.enableGlobally()

//为类动态的添加一个属性
Person.metaClass.sex='male'
def person1=new Person(name:'mjf',age:18)
println person1.sex

//动态属性赋值
person1.sex='female'
println person1.sex

//动态添加方法
Person.metaClass.sexUpperCase={//动态添加方法 使用闭包进行赋值
    ->sex.toUpperCase()
}
def person2=new Person(name:'xhw',age:26)
println person2.sexUpperCase()

//为类动态的添加静态的方法
Person.metaClass.static.createPerson={
    String name,int age->new Person(name:name,age:age)
}
//使用这个静态的方法
def person3=Person.createPerson('renzhiqiang',30)
println "${person3.name} and ${person3.age} "