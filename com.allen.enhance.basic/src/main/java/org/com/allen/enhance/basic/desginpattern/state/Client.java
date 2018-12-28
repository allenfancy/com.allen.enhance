package org.com.allen.enhance.basic.desginpattern.state;

/**
 * @author allen.wu
 * @since 2018-09-14 00:42
 *
 * 当一个对象内在状态改变时允许其改变行为，这个对象看起来想改变了其类.
 * <p>
 *     状态模式的核心是封装，状态的变化引起行为的变更，从外部看起来就好像这个对象对应的类发生了改变一样。通用的模型如下：
 *     Context  ->  State
 *                    ^
 *                    |
 *                ConcreteState
 *     Context: 定义客户端需要的接口，并负责具体状态的切换
 *
 *
 * </p>
 * 状态模式相对来说比较复杂，它提供了一种对物质运动的另一个观察视角，通过状态变化使得行为变化，就类似于水的变化一样.
 *
 * <a>
 *     一、状态模式的优点：
 *      1、结构清晰
 *      2、遵循设计原则
 *      3、封装性非常好
 * </a>
 *
 * <ul>
 *     状态模式：允许一个对象在其内部状态改变时改变它的行为。对象看起来似乎修改了它的类
 *     在大多数情况下，一个对象的行为取决于一个或者多个动态变化的属性，这样的属性叫做状态，这样的对象叫做有状态的(stateful)对象，这样的对象是从事先定义好了一些列值中取出
 *     当这样一个的对象与外部事件产生互动时，其内部状态就会改变，从而使得系统的行为产生变化
 * </ul>
 * 适用性:
 * <li>
 *  1.一个对象的行为取决于它的状态，并且它必须在运行时刻根据状态改变他的行为
 *  2.代码中包含大量与对象状态有关的条件语句:
 *      一个操中包含有庞大的分支条件语句，且这些分支依赖于该对象的状态.
 * </li>
 *
 * 通用类图
 *
 *      Componet
 *        ^
 *        |
 *        |
 * ConcreateComponet
 */
public class Client {

    public static void main(String[] args) {
        Context context = new Context();
        context.setLifeState(new ClosingState());
        // 会先执行ClosingState的open()进行状态切换.
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
