package xml

import groovy.xml.MarkupBuilder

def sw=new StringWriter()
def xmlBuilder=new MarkupBuilder(sw)//生成xml数据的核心类
//我们的数据封装类
def langObject=new Langs()

xmlBuilder.lang(type:langObject.type,
        count:langObject.count,
        mainstream:langObject.mainstream){//这个lang是固定的 不能用变量

    langObject.languages.each {
        lang->language(flavor:lang.flavor,version:lang.version,lang.value)
    }
}
println sw