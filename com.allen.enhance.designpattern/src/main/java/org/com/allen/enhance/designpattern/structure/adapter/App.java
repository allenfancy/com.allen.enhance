package org.com.allen.enhance.designpattern.structure.adapter;

/**
 * @author allen.wu
 * @since 2018-11-11 10:23
 *
 * 适配器模式：将一个类的接口变换成客户端所期待的另外一个接口，从而使得原本因为接口不匹配而无法在一起工作的俩个类能够在一起工作;
 *
 * Target目标对象：该角色定义把其他类转换为何种接口,即我们期望的接口;
 * Adaptee源角色：你想把谁转换成目标角色，这个"谁"就是源角色，它是已经存在的、运行良好的类或者对象，经过适配器角色包装，它会变换成一个新的角色
 * Adapter配置器：适配器的核心角色，其他俩个角色都应存在角色，而适配器角色是需要新建立的，它的指责比较单一；把源接口转换为目标角色，怎么转换?通过继承或者关联的方式
 *
 * Client ----------> Target
 *                      ^
 *                      |
 *                      |
 *  Adaptee <------  Adapter
 *
 */
public class App {
}
