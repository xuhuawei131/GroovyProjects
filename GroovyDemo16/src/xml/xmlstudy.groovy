package xml

import groovy.xml.MarkupBuilder


/**
 <langs type=‘current’  count=‘3’ mainstream=‘true’>
 <language flavor=’static’ version=‘1.5’ > java</language>
 <language flavor=’dynamic’ version=‘1.6’ > Groovy</language>
 <language flavor=’dynamic’ version=‘1.9’ > javascript</language>
 </langs>

 */
def sw=new StringWriter()
def xmlBuilder=new MarkupBuilder(sw)//生成xml数据的核心类
//根节点创建成功
def result=xmlBuilder.langs(type:'',count:3,mainstream:true){
    //第一个
    language(flavor:'static',version:'1.5','java')//属性是映射形式设置，最后一个值是 xml的值
    //第二个
    language(flavor:'dynamic',version:'1.6',){
        age(16)
    }
    //第三个
    language(flavor:'dynamic',version:'1.9',){
        age(18)
    }
}
println  sw
