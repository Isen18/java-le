package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author Isen
 * @date 2018/8/10 10:35
 */
public class TimeEncoder extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) {
        UnixTime m = (UnixTime) msg;
        ByteBuf encoded = ctx.alloc().buffer(4);
        encoded.writeInt((int)m.value());
        ctx.write(encoded, promise);
    }
}

//public class TimeEncoder extends MessageToByteEncoder<UnixTime> {
//
//    @Override
//    protected void encode(ChannelHandlerContext ctx, UnixTime msg, ByteBuf out) {
//        out.writeInt((int)msg.value());
//    }
//}