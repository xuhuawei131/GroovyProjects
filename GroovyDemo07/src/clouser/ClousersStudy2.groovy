package clouser

int x=fab2(5)
println(x )

println(cal(101))

//求指定number的阶乘的方法
int fab(int number){
    int result=1
    1.upto(number,{num->result *=num})
   return  result
}
//使用downto 进行求阶乘
int fab2(int number){
    int result=1
    number.downto(1){
        num->result*=num
    }
    return result
}
//使用times方法进行求相加的和
int cal(int number){
    int result=0
    number.times {
        num->result+=num
    }
    result
}