package org.com.allen.enhance.designpattern.action.chain;

/**
 * @author allen.wu
 * @since 2018-12-19 23:49
 */
public class Women implements IWomen {

    private int type = 0;

    private String request;

    public Women(int type, String request) {
        this.type = type;
        switch (this.type) {
            case 1:
                this.request = "女儿的请求是:" + request;
                break;
            case 2:
                this.request = "女儿的请求是:" + request;
                break;
            case 3:
                this.request = "女儿的请求是:" + request;
                break;
            default:
                this.request = "request 非法";
                break;

        }
        this.request = request;
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public String getRequest() {
        return this.request;
    }
}
