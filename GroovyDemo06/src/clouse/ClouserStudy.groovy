package clouse

def clouser={println 'Hello Groovy'}
//调用闭包
clouser.call()
//或者像方法一样调用
clouser()

def clouser1={String name->println "Hello ${name}"}//参数用箭头隔开
clouser1.call('Java')
def paramName='Kotlin'
clouser1(paramName)//使用变量名进行传参

def clouser2={String name,int age->println "Hello ${name},age is $age"}//参数用箭头隔开
clouser2("xuhuawei",30)

def clouser3={println "Hello ${it}"}//闭包都有一个参数 叫it 他是默认参数
clouser3("World")


def clouser4={ String name->
    return  "Hello ${name}"}
def result=clouser4("Ketty")
println(result)


def clouser5={ String name->
      println "Hello ${name}"}
 result=clouser5("Ketty")
println(result)