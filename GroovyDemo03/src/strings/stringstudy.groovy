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
println(result.class)
String echo(String message){
    return message
}