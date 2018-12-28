package org.com.allen.enhance.designpattern.action.chain;

/**
 * @author allen.wu
 * @since 2018-12-20 00:00
 */
public class SonHandler extends Handler {


    public SonHandler() {
        super(SONE_LEVEL_REQ);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("-----------母亲向儿子请求-----------");
        System.out.println(women.getRequest());
        System.out.println("儿子回答是同意:同意 \n");
    }
}
