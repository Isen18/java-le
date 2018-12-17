package netty.echo2.server;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.nio.charset.Charset;


public class EchoInHandler1 extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        System.out.println("in1");
        // 通知执行下一个InboundHandler
//        ctx.write(msg);

        ctx.writeAndFlush(msg);

        ctx.writeAndFlush(Unpooled.copiedBuffer("我会发出吗？".getBytes(Charset.forName("UTF-8"))));
        ctx.fireChannelRead(Unpooled.copiedBuffer("我NEN发出吗？".getBytes(Charset.forName("UTF-8"))));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();//刷新后才将数据发出到SocketChannel
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
