
def students=[
        1:[number:'0001',name:'Bob',score:55,sex:'male'],
        2:[number:'0002',name:'Johnny',score:62,sex:'female'],
        3:[number:'0003',name:'Claire',score:73,sex:'female'],
        4:[number:'0004',name:'Amy',score:66,sex:'male']
]

//遍历
students.each {
    def student->
        println "the key is ${student.key}, the value is${student.value.toMapString()}"
}
//带索引的遍历
students.eachWithIndex{def entry, int i ->
    println "the key is ${entry.key}, the value is ${entry.value.toMapString()}，index=${i}"

}
//不使用Entry了，而直接使用key-value的方式
students.each {key,value->
    println "the key is ${key}, the value is${value.toMapString()}"
}
//使用key-value方式，这回事用withIndex 带索引的
students.eachWithIndex{ key,value , int i ->
    println "the key is ${key}, the value is ${value.toMapString()}，index=${i}"
}


//map的查找  分数大于60分的
def entry =students.find{
    def student->return student.value.score>=60
}
println(entry)

//map的查找findAll  分数大于60分的所有的人信息
def result =students.findAll{
    def student->return student.value.score>=60
}
println(result.toMapString())

//count 数量 查找分数大于60并且是male性别的数目
def count=students.count {def student->
    return student.value.score>=60&&student.value.sex=='male'
}
println count


//打印出所有及格学生的名字
def names=students.findAll {def student->
    student.value.score>=60}
.collect {//使用collect进行过滤 相当于转化
    return it.value.name
}
println names


//分组  根据学生的分数是否及格进行分组
def group=students.groupBy {
    def student->
        return student.value.score>=60?'及格':'不及格'
}
println group.toMapString()


//排序 sort方法
def sort=students.sort {def student1,def student2->
    Number score1=student1.value.score
    Number score2=student2.value.score
    return  score1==score2?0:score1<score2?-1:1
}
println sort.toMapString()