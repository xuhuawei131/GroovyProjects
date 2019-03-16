package json

import groovy.json.JsonOutput
import groovy.json.JsonSlurper

//对象转化为json字符串
def list=[new Person(name:'xhw',age:25),new Person(name:'mjf',age:25),new Person(name:'xwt',age:1)]
def result=JsonOutput.toJson(list)
println JsonOutput.prettyPrint(result)

//json字符串转化为对象 我们还是可以使用习惯的fastjson以及gson等第三方库，但是建议使用groovy方式解析
def jsonSlpuer=new JsonSlurper()
byte [] data;
jsonSlpuer.parse(data)//他可以传很多参数 根据需要去传递
jsonSlpuer.parseText("")//解析json字符串

def response=getNetWorkData("http://yuexibo.top/yxbApp/home_data.json")
println response.data.head.name

//请求网络数据
def getNetWorkData(String url){
    def connection=new URL(url).openConnection()
    connection.setRequestMethod("GET")
    connection.connect()
    def response=connection.content.text

    //将json字符串转化为实体对象
    def jsonSlpuer=new JsonSlurper()
    return  jsonSlpuer.parseText(response)//他可以传很多参数 根据需要去传递
}
