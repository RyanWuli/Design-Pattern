## 设计模式相关的代码内容
- singleton 单例模式
- strategy 策略模式
- factory 工厂模式
    ----- factorymethod 工厂方法
    ----- abstractfactory 抽象方法
- chainofresponsibility 责任链模式 （cor）
- observer 观察者模式
- composite 组合模式
- flyweight 享元模式（池化就是用的享元模式，线程池等）
- proxy 代理模式
- iterator 遍历模式
- visitor 访问者（在结构不变的情况下动态改变对于内部元素的动作）
- builder 构建者模式（构建复杂对象）
- adapter 接口转换器（适配器）（也叫 wrapper）- java.io/jdbc-odbc bridge/ASM transformer
    ----- 通常的 WindowAdapter，KeyAdapter 反而不是 adapter 模式，只是实现了接口的抽象类，这样的话用的时候不用把所有的方法重写，只需要写需要的就行
- bridge 双维度扩展
    ----- 分离抽象与具体
    ----- 用聚合的方式（桥）连接抽象与具体
- command 封装命令
    ----- 别名：Action / Transaction
    ----- 结合 cor 实现 undo
- prototype 原型模式
- memento 备忘模式 见 tankwar 项目
- templatemethod 模板方法模式（钩子方法）
    ----- tankwar 中的 paint 方法
    ----- tankwar 中的 WindowsListener （windowsClosing()/windowsXXX）
    ----- ASM (ClassVisitor)
- state （状态模式，根据状态决定行为）
- interpreter （解释器，解释脚本语言）