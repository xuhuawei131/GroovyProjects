package study

String str='the 2 and 3 is 5'
//each的便利
println str.each {//each方法的返回值 还是我们字符串本身
//    String item->println item.multiply(2)//从新命名参数名 未teim   multiply将字符扩充
    String item->println item//从新命名参数名 未teim   multiply将字符扩充
}

//find来查找符合条件的第一个
def findValue=str.find{
    //必须返回一个boolean值
    String item->item.isNumber()
}
println findValue


//findall找到字符中所有符合条件的，然后放到一个集合中
def list=str.findAll{//返回的是一个list集合
    String item-> item.isNumber()
}
println list.toListString()


//any方法，表示字符串中 只要有一个字符满足条件，那么这方法就返回true，否则false
def result=str.any{
    String item->item.isNumber()
}
println result


//every方法  必须每个字符都符合条件 才返回true，否则为false
def result1=str.every {
    String item->item.isNumber()
}
println result1




//将我们字符串中的每一个元素，都应用于我们的闭包，闭包会产生一个新的结果，然后结果添加到ArrayList中返回

def result2=str.collect {String item->item.toUpperCase()}//将我们字符串中每一个字符都转成大写
println result2.toListString()