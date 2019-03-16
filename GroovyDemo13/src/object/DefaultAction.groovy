package object

trait DefaultAction {
    //必须通过abstract进行修饰
    abstract void eat()

    void paly(){
        println 'i can play'
    }
}