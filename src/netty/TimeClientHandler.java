package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.util.Date;

/**
 * @author Isen
 * @date 2018/8/10 0:49
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {
    private ByteBuf buf;

//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        ByteBuf m = (ByteBuf) msg;
//        try {
//            long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
//            System.out.println(new Date(currentTimeMillis));
//            ctx.close();
//        } finally {
//            m.release();
//        }
//    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        buf = ctx.alloc().buffer(4);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        buf.release();
        buf = null;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        ByteBuf m = (ByteBuf) msg;
//        buf.writeBytes(m);
//        m.release();
//
//        if (buf.readableBytes() >= 4) {
//            long currentTimeMillis = (buf.readUnsignedInt() - 2208988800L) * 1000L;
//            System.out.println("okokok" + new Date(currentTimeMillis));
//            ctx.close();
//        }

        UnixTime m = (UnixTime) msg;
        System.out.println(m);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
