package org.com.allen.enhance.basic.desginpattern.decoration;

/**
 * 具体的实现
 */
public class FouthGradeSchoolReport extends SchoolReport {

    @Override
    public void report() {
        System.out.println("尊敬的XXXX家长:");
        System.out.println(" ....... ");
        System.out.println(" 语文62， 数学65， 体育98， 自然 63");
        System.out.println(" ........ ...... ");
        System.out.println("                  家长签名:");
    }

    @Override
    public void sign(String name) {
        System.out.println("家长签名是: " + name);
    }
}
