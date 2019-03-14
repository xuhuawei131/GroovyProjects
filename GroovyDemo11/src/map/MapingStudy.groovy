package map

def colors=["red":"fff000","green":"00ff00","blue":'000fff']
//获取map中的值
def value=colors.get("red")
def value2=colors["blue"]
def vlaues=colors.green

//向map中添加元素
colors.yellow="ffff00"//如果map中有对应的key，那么就更新，如果没有那么就增加
colors["white"]="ffffff"
colors.put("black","000000")
println "white:${colors.white},yellow:${colors["yellow"]},black:${colors.get("black")}"

//批量增加元素
colors.complex=[a:1,b:2]
println "all map:${colors.toMapString()}"

colors.remove('black')
colors.removeAll {
    return  it.key=='white'
}
println colors.toMapString()

println colors.getClass()

def colors2=["red":"fff000","green":"00ff00","blue":'000fff'] as HashSet
println colors2.getClass()