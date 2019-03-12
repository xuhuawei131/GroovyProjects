package datastruct

def list=new ArrayList()//java定义方法
def list1=[1,2,3,4,5]//groovy 的列表  看起来像数组 但是他是ArrayList
println list1.class
println list1.size()

//定义一个数组
def array=[1,2,3,4,5] as int[]
println array.class
//另一种方法
int[] array1=[123456]

//列表的排序
def sortList=[6,-3,9,2,7,1,5]
Collections.sort(sortList)//自然排序 就是由大到小的排序
println(sortList)

//自定义我们排序规则 我们写一个闭包定义规则
//我们的规则是 绝对值比较大的 返回值为1  小的返回值为-1
Comparator mc={a,b->a==b?0:Math.abs(a)>Math.abs(b)?1:-1}
Collections.sort(sortList,mc)
println(sortList)


//使用集合中的sort方法进行排序
sortList.sort()
sortList.sort{//通过闭包进行自定义排序
    a,b->a==b?0:Math.abs(a)>Math.abs(b)?1:-1
}
println(sortList)

//我们给字符数组进行排序
def sortStringList=['abc','z','hello','groovy','java']
//我们通过字符串的长度进行排序 我们这里使用 隐世参数it
sortStringList.sort{it->return it.size()}
println sortStringList


def findList=[-3,9,2,6,-7,1,5]
int result=findList.find {return it%2==0}//查找第一个偶数
println result

def resultList=findList.findAll {return it%2!=0}//返回所有列表的奇数
println resultList.toListString()


def anyResult=findList.any {it%2!=0}//是否有奇数
println anyResult

def everyResult=findList.every {it%2==0}//是否都是偶数
println everyResult


//最大值和最小值
def minValue=findList.min()
println minValue
minValue =findList.min{return Math.abs(it)}//绝对值的最小值
println "abs min=${minValue}"

def maxValue=findList.max()
println maxValue
minValue =findList.min{return Math.abs(it)}//绝对值的最小值
println "abs max=${maxValue}"

//count 统计数目
findList.count {return it%2==0}//查看列表中有多少偶数