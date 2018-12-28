package org.com.allen.enhance.basic.mockito;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


/**
 * @author allen.wu
 * @since 2018-12-18 17:28
 */
public class VerifyActionTest {

    @Test
    public void testVerify() {
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.clear();
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void testStub() {
        LinkedList mockedList = mock(LinkedList.class);
        // 测试桩
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        System.out.println(mockedList.get(0));
        //System.out.println(mockedList.get(1));
        System.out.println(mockedList.get(999));

        verify(mockedList).get(0);
    }

    @Test
    public void testParamMatchers() {
        List mockedList = mock(List.class);
        when(mockedList.get(anyInt())).thenReturn("element");
        // 输出element
        System.out.println(mockedList.get(999));

        //you can also verify using an argument matcher
        // 你也可以验证参数匹配器
        verify(mockedList).get(anyInt());
    }
}
