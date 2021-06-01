package com.zxw;

import static org.junit.Assert.assertTrue;

import com.zxw.singleton.Mgr;
import com.zxw.singleton.Mgr02;
import com.zxw.singleton.Mgr03;
import com.zxw.singleton.Mgr08;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void singletonTest() {
        Mgr mgr = Mgr.getInstance();
        Mgr m = Mgr.getInstance();
        System.out.println(mgr == m); // 单例模式每次都是同一个实例

        Mgr02 mgr2 = Mgr02.getInstance();
        Mgr02 mgr22 = Mgr02.getInstance();
        System.out.println(mgr2 == mgr22);

        Mgr03 mgr3 = Mgr03.getInstance();
        Mgr03 mgr32 = Mgr03.getInstance();
        System.out.println(mgr3 == mgr32);

        Mgr08.INSTANCE.test();

    }

    /**
     * 电脑设备的核心数量
     */
    @Test
    public void testCpu() {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(">>>>>>>>>>>>>>>>>>>> 电脑可用线程核心数量：" + i);
    }
}
