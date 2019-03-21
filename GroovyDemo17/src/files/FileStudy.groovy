package files

//读取GroovyDemo17.iml文件
def file = new File('../../GroovyDemo17.iml')
//读取文件每一行的内容
file.eachLine {
    line->println(line)
}
//获取文件全部内容 其实内部还是输出输入流那一套
def content = file.getText()
println content

//返回所有文件每一行的内容的集合
def resultList = file.readLines()
println resultList.toListString()

//读取文件的某一部分  这里读取100个字节
def reader = file.withReader { reader ->//这个reader就是我们java中的reader
    char[] buffer = new char[100]
    reader.read(buffer)
    return buffer
}
println reader


//file.withWriter  跟file.withReader 用法一样，也是传入闭包，参数是writer字节流
//def writer=file.withWriter {
//    writer->writer.write(reader)
//}

//拷贝文件
copy('../../GroovyDemo17.iml','../../GroovyDemo17.im2')
def copy(String sourcePath, String destinationPath) {
    try {
        def desFile = new File(destinationPath)
        if (!desFile.exists()) {
            desFile.createNewFile()
        }
        //开始拷贝 通过reader的reader.readLines()获取所有的集合
        new File(sourcePath).withReader { reader -> //获取的reader是 Reader，所以withXXX就是获取文件的这个类型的对象
            def lines = reader.readLines()
            desFile.withWriter { writer ->
                lines.each { line ->
                    writer.write(line+"\r\n")
                }
            }
        }
    } catch (Exception e) {

    }
}


def person=new Person(name:'Tom',age:26)
saveObject(person,'../../persion.bin')
def person2=(Person)readObject('../../persion.bin')
println "name:${person2.name},age:${person2.age}"

//保存对象到文件中
def saveObject(Object object,String path){
    try {
        def desFile = new File(path)
        if (!desFile.exists()) {
            desFile.createNewFile()
        }

        //获取的out是 ObjectOutputStream，所以withXXX就是获取文件的这个类型的对象
        desFile.withObjectOutputStream { out->//ObjectOutputStream 类型的
           out.writeObject(object)
        }
    }catch(Exception e){
         e.printStackTrace()
    }
}
//从文件中读取对象
def  readObject(String path){
    def object=null
    try{
        def sourceFile = new File(path)
        if (!sourceFile.exists()){
            return null
        }
        sourceFile.withObjectInputStream {inputStream->
            object=inputStream.readObject()
        }
        return object
    }catch(Exception e){
        e.printStackTrace()
    }
}

