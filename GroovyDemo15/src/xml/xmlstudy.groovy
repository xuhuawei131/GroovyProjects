package xml

final String xml = """
<response version-api="2.0">
      <value>
        <books id="1" classification="android">
           <book available="20" id="1">
           <title>疯狂Android讲义</title>
           <author id="1">李刚</author>
          </book>
         <book available="14" id="2">
          <title>第一行代码</title>
          <author id="2">郭林</author>
         </book>
        <book available="13" id="3">
         <title>Android开发艺术探索</title>
         <author id="3">任玉钢</author>
        </book>
     
  </books>
  
  <books id="2" classification="web">
           <book available="10" id="1">
           <title>Vue入门到精通</title>
           <author id="4">李刚</author>
          </book>
  </books>
 </value>
</response>
 """

//开始解析xml
def xmlsluper = new XmlSlurper()
def resultResponse = xmlsluper.parseText(xml)//生成的对象是我们xml的根节点
println resultResponse.value.books[0].book[0].title.text()
//获取我们第二个books节点第一个book的available属性值
println resultResponse.value.books[1].book[0].@available

//遍历节点 搜集所有作者是李刚的书籍的名称
def list = []
resultResponse.value.books.each {
    books ->
        //开始对book进行遍历
        books.book.each {
            book ->
                def author = book.author.text()
                if (author.equals("李刚")) {
                    list.add(book.title.text())
                }
        }
}
println list.toListString()


//深度遍历
def titles = resultResponse.depthFirst().findAll {
    book ->
        return book.author.text() == "李刚"
}
println "深度遍历结果：${titles.toListString()}"


// '**' 可以代替depthFirst
def titles2 = resultResponse.'**'.findAll {
    book ->
        return book.author.text() == "李刚"
}
println "深度遍历结果2：${titles.toListString()}"


//广度遍历 把所有书籍中id为2的输出    '*' 代表广度遍历
def titles3 = resultResponse.value.books.children().findAll {
    node ->
        //找到节点名称叫book 并且id为2的book
        node.name() == "book" && node.@id == '2'
}.collect {//collect 相当于一个map进行转化的作用  这里是把所有的note的list中的每一项（也就是book）转化为 book的title
    node -> return node.title.text()
}

println "广度遍历结果：${titles3.toListString()}"


