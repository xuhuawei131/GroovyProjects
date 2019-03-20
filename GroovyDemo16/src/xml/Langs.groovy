package xml

//对应xml中的lang节点
class Langs {
    String type = 'current'
    int count = 3
    boolean mainstream = true
    def languages = [new Language(flavor: 'static', version: 1.5, value: 'java'),
                    new Language(flavor: 'dynamic', version: 1.6, value: 'Groovy'),
                    new Language(flavor: 'dynamic', version: 1.9, value: 'javascript')
    ]

}

//langs 还有子节点language， 所以我们要生成对应的language类，来对应language节点，与我们json实体对应是一样的
//每深入一个节点 就要定义一个新的类，与这个节点匹配

class Language {//对应xml中的language节点
    String flavor
    String version
    String value
}