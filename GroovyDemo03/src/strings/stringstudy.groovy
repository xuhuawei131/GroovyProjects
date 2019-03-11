package strings

import org.codehaus.groovy.runtime.GStringImpl

//def name ='a single string'
//println(name.class)
//
//def name1 ='a single \' a \' string'
//println name1

def threeStr1='''three single string'''
def threeStr2='''three 
single 
string'''
//println(threeStr1)
//println(threeStr1.class)
//println(threeStr2)

def doubleName="this is a common String"
//println(doubleName.class)

def name="XuHuawei"
def sayHello="Hello ${name}"//或者$name也可以
//println(sayHello)

//println(sayHello.class)

def sum="the sum of 2 and 3 equals ${2+3}"
//println(sum)

def result=echo(sum)
//println(result.class)
String echo(String message){
    return message
}
/*=================================字符串的方法====================================*/
//字符串填充
def str="groovy"
println str.center(8,"*")
println str.center(8)//默认是填充空格
println str.padLeft(8,"*")//填充在已有字符串的左边，padRight正好相反

//字符串比较
def str2="Hello"
println str.compareTo(str2)//使用方法比较
println str>str2 //使用操作符比较 ；除了数字可以进行比较之外，字符串我们也可以比较

//字符串索引 获取字符串中某个字符
println str.getAt(0)
println str[0]//使用类似于数组下标的方式
println str[0..1]//除了单个下标 还可以使用范围

//字符串减法
println str.minus(str2)//从str字符串中 减去str2相同的部分  由于他们没有相同的 所以原样输出str

def str3="Groovy Hello"
println str3.minus(str2)//从str3字符串中 减去str2相同的部分  减去相同的部分Hello 所以还剩下Groovy


//other 没有什么相关的了
println str.reverse()//字符串倒序
println(str.capitalize())//首字母大写 内部其实是找到第一个字母 变成大写之后返回新的字符串
println str.isNumber() //字符串是否是数字类型的
println str.toLong() //转化成Long类型 进行类型转换
