package range
//定义一个1到10的范围
def range=1..10
println range.toListString()

def value=range[0]//获得第一个数据
println "index 0 values=${value}"
//是否包含10
println range.contains(10)
//起始值
println range.from
//终点值
println range.to

//遍历第一种方法 each
range.each {
    println it
}
//遍历第二种方法 for
for (it in range){
    println it
}

def result=getResult(75)
println result

def getResult(Number number){
    def result
    switch (number){
        case 0..<60://   ..< 表示不包含右侧值
            result='不及格'
            break
        case 60..<70:
            result='及格'
            break
        case 70..<80:
            result='良好'
            break
        case 80..100:
            result='优秀'
            break
    }
    return result
}

