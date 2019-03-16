package object
/**
 * Class默认都是public，
 * 包括方法和变量默认都是public
 * 继承自GroovyObject类
 */
class Person implements Action{
    String name//变量默认也是public
    Integer age//int 和Integer是一样的
    def increaseAge(Integer years){//方法默认也是public，返回值使用def 进行定义的话，表示这个返回值就是Object类型
        this.name+=years
    }
    @Override
    void eat() {

    }
    @Override
    void drink() {

    }
    @Override
    void play() {

    }

    @Override
    Object invokeMethod(String name, Object args) {
        return "invokeMethod the method is ${name},the params is ${args}"
    }

    def methodMissing(String name, def args) {
        return "methodMissing the method is ${name},the params is ${args}"
    }
}
