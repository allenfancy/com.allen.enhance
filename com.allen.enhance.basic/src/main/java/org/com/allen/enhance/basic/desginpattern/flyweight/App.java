package org.com.allen.enhance.basic.desginpattern.flyweight;

/**
 * @author allen.wu
 * @since 2018-09-14 00:59
 * 享元模式：
 * 即池化技术的重要实现方式.
 * 享元模式的定义有俩个要求：
 * 1、细粒度的对象
 * 2、共享的对象
 *
 * 细粒度的对象，不可表面地使用对象数量越多且性质越接近，这样的信息分为俩个部分：内部状态(intrinsic)和外部状态(extrinsic)
 *
 * 内部状态：是对象可以共享出来的信息。
 * 外部状态：对象得以依赖的标记，它们可以作为一个对象的动态附加信息，不可以共享状态
 */
public class App {
}
