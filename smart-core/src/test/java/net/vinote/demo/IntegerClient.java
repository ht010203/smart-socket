package net.vinote.demo;

import org.smartboot.socket.transport.AioQuickClient;

/**
 * Created by zhengjunwei on 2017/7/12.
 */
public class IntegerClient {
    public static void main(String[] args) throws Exception {
        IntegerClientProcessor processor=new IntegerClientProcessor();
        AioQuickClient aioQuickClient=new AioQuickClient()
                .connect("localhost",8888)
                .setProtocol(new IntegerProtocol())
                .setProcessor(processor);
        aioQuickClient.start();
        processor.getSession().write(1);
        Thread.sleep(1000);
        aioQuickClient.shutdown();

    }
}
