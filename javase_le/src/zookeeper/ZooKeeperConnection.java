package zookeeper;

// import java classes

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

// import zookeeper classes

/**
 * ZooKeeperConnection
 *
 * @author Isen
 * @description
 * @date 2018/7/27 11:31
 **/
public class ZooKeeperConnection {
    // declare zookeeper instance to access ZooKeeper ensemble
    private ZooKeeper zoo;
    final CountDownLatch connectedSignal = new CountDownLatch(1);

    // Method to connect zookeeper ensemble.
    public ZooKeeper connect(String host) throws IOException,InterruptedException {

        zoo = new ZooKeeper(host,5000,new Watcher() {
            //实现“监视器”界面的对象。ZooKeeper集合通过监视器对象返回连接状态。
            //ZooKeeper集合通过监视器回调来回复连接状态。一旦客户端与ZooKeeper集合连接，监视器回调就会被调用
            @Override
            public void process(WatchedEvent we) {

                if (we.getState() == KeeperState.SyncConnected) {
                    connectedSignal.countDown();
                }
            }
        });

        connectedSignal.await();
        return zoo;
    }

    // Method to disconnect from zookeeper server
    public void close() throws InterruptedException {
        zoo.close();
    }
}
