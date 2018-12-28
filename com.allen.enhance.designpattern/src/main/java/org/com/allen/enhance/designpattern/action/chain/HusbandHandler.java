package org.com.allen.enhance.designpattern.action.chain;

/**
 * @author allen.wu
 * @since 2018-12-20 00:00
 */
public class HusbandHandler extends Handler {


    public HusbandHandler() {
        super(HUSBAND_LEVEL_REQ);
    }

    @Override
    protected void response(IWomen women) {
        System.out.println("-----------妻子向丈夫请求-----------");
        System.out.println(women.getRequest());
        System.out.println("丈夫回答是同意:同意 \n");
    }
}
