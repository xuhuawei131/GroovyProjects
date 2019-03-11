package logic

def x=1.23//大数据类型 float都是 大数据类型
def result
switch (x){
    case 'foo':
        result='found foo'
        break
    case 'bar':
        result='bar'
        break
    case [1.23,5,6,'inlist']://匹配list
//    case [4,5,6,'inlist']://匹配list
        result='list'
        break
    case 12..30:
        result='rang'//范围
        break
    case Integer://是否是整形 相当于 instanceOf语句
        result="integer"
        break
    case BigDecimal://大数据类型
        result='big decimal'
        break
    default:
        result='default'
        break

}
println result

switch (x.class){//x的类型就行匹配 相当于是instanceOf
    case 'foo':
        result='found foo'
        break
    case 'bar':
        result='bar'
        break
    case [4,5,6,'inlist']://匹配list
        result='list'
        break
    case 12..30:
        result='rang'//范围
        break
    case Integer://是否是整形 相当于 instanceOf语句
        result="integer"
        break
    case BigDecimal://大数据类型
        result='big decimal'
        break
    default:
        result='default'
        break

}
println result


def sum=0
//对范围进行循环
for (i in  0..9){
    sum+=i
}
println(sum)

sum=0
//对list进行循环
for (i in [1,2,3,4,5,6,7,8,9]){
    sum+=i
}
println(sum)

sum=0
//对map进行循环
for (i in ['dayong':1,'dajun':2,'daqiang':3]){
    sum+=i.value//i.key 是key
}
println(sum)