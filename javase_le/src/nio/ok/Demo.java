package nio.ok;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SinkChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Isen
 * @date 2018/8/9 14:28
 */

public class Demo {

    private final String FILE_PATH = "D:\\IdeaProjects\\JavaSE_le\\javase_le\\out\\production\\JavaSE_le\\data\\nio-data.txt";
    private FileChannel fileChannel = null;

    private ServerSocketChannel channel;

    @Before
    public void init() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(FILE_PATH, "rw");
        fileChannel = randomAccessFile.getChannel();
    }

    @Test
    public void testChannel() throws IOException {
//        String path = Demo.class.getResource("/").toString();
//        RandomAccessFile randomAccessFile = new RandomAccessFile(path + "data/nio-data.txt", "rw");
//        RandomAccessFile randomAccessFile = new RandomAccessFile(FILE_PATH, "rw");
//        FileChannel fileChannel = randomAccessFile.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        int byteRead = fileChannel.read(byteBuffer);
        while (byteRead != -1) {
            System.out.println("Read" + byteRead);
            byteBuffer.flip();

            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }

            byteBuffer.clear();
            byteRead = fileChannel.read(byteBuffer);
        }
        fileChannel.close();
    }

    @Test
    public void testBuff() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile(FILE_PATH, "rw");
        FileChannel inChannel = aFile.getChannel();

        //create buffer with capacity of 48 bytes
        ByteBuffer buf = ByteBuffer.allocate(48);

        //read into buffer.
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            //make buffer ready for read
            buf.flip();

            while (buf.hasRemaining()) {
                // read 1 byte at a time
                System.out.print((char) buf.get());
            }

            //make buffer ready for writing
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }

    @Test
    public void testScatter() throws IOException {
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);

        ByteBuffer[] bufferArray = {header, body};

        fileChannel.read(bufferArray);
    }

    @Test
    public void testGather() throws IOException {
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);

        //write data into buffers
        ByteBuffer[] bufferArray = {header, body};

        fileChannel.write(bufferArray);
    }

    @Test
    public void testTransFrom() throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();

        toChannel.transferFrom(fromChannel, position, count);
    }

    @Test
    public void testTransTo() throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();

        fromChannel.transferTo(position, count, toChannel);
    }

    @Test
    public void testSelect() throws IOException {
        Selector selector = Selector.open();

        channel.configureBlocking(false);

        SelectionKey key = channel.register(selector, SelectionKey.OP_READ);


        while(true) {

            int readyChannels = selector.select();

            if(readyChannels == 0){
                continue;
            }


            Set<SelectionKey> selectedKeys = selector.selectedKeys();

            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

            while(keyIterator.hasNext()) {

                key = keyIterator.next();

                if(key.isAcceptable()) {
                    // a connection was accepted by a ServerSocketChannel.

                } else if (key.isConnectable()) {
                    // a connection was established with a remote server.

                } else if (key.isReadable()) {
                    // a channel is ready for reading

                } else if (key.isWritable()) {
                    // a channel is ready for writing
                }

                keyIterator.remove();
            }
        }
    }

    @Test
    public void testPipe() throws IOException {
        Pipe pipe = Pipe.open();
        new Thread(() -> {
            SinkChannel sinkChannel = pipe.sink();
            String newData = "New String to write to file..." + System.currentTimeMillis();

            ByteBuffer buf = ByteBuffer.allocate(48);
            buf.clear();
            buf.put(newData.getBytes());

            buf.flip();

            while(buf.hasRemaining()) {
                try {
                    sinkChannel.write(buf);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(() -> {
            Pipe.SourceChannel sourceChannel = pipe.source();
            ByteBuffer buf = ByteBuffer.allocate(48);
            buf.clear();
            int bytesRead;
            try {
                bytesRead = sourceChannel.read(buf);
                while(bytesRead != -1){
                    buf.flip();
                    while (buf.hasRemaining()) {
                        System.out.print((char) buf.get());
                    }

                    buf.clear();
                    bytesRead = sourceChannel.read(buf);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                sourceChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
