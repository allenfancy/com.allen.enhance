package org.com.allen.enhance.designpattern.action.chain;

/**
 * @author allen.wu
 * @since 2018-12-20 00:00
 */
public class FatherHandler extends Handler {


    public FatherHandler() {
        super(FATHER_LEVEL_REQ);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("-----------女儿向父亲请求-----------");
        System.out.println(women.getRequest());
        System.out.println("父亲回答是同意:同意 \n");
    }
}
