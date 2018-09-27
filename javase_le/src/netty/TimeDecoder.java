package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/**
 * @author Isen
 * @date 2018/8/10 10:21
 */
public class TimeDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) { // (2)
        if (in.readableBytes() < 4) {
            return;
        }

//        out.add(in.readBytes(4));
        out.add(new UnixTime(in.readUnsignedInt()));
    }
}

//public class TimeDecoder extends ReplayingDecoder<Void> {
//    @Override
//    protected void decode(
//            ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
//        out.add(in.readBytes(4));
//    }
//}
