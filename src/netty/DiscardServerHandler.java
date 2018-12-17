package netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 处理服务端 channel
 *
 * @author Isen
 * @date 2018/8/10 0:03
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        super.channelRead(ctx, msg);

        // 默默地丢弃收到的数据
//        ((ByteBuf) msg).release();

//        ByteBuf in = (ByteBuf) msg;
//        try {
//            while (in.isReadable()) {
//                System.out.print((char) in.readByte());
//                System.out.flush();
//            }
//        } finally {
//            ReferenceCountUtil.release(msg);
//        }

        ctx.write(msg);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        super.exceptionCaught(ctx, cause);

        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}
