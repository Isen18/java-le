package zookeeper;

import org.apache.log4j.BasicConfigurator;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

/**
 * ZKSetData
 *
 * @author Isen
 * @description
 * @date 2018/7/27 11:52
 **/
public class ZKSetData {

    static {
        BasicConfigurator.configure();
    }

    private static ZooKeeper zk;
    private static ZooKeeperConnection conn;

    // Method to update the data in a znode. Similar to getData but without watcher.
    public static void update(String path, byte[] data) throws
            KeeperException, InterruptedException {
        zk.setData(path, data, zk.exists(path, true).getVersion());
    }

    public static void main(String[] args) throws InterruptedException, KeeperException {
        String path = "/MyFirstZnode222";
        byte[] data = "Success".getBytes(); //Assign data which is to be updated.

        try {
            conn = new ZooKeeperConnection();
            zk = conn.connect("localhost");
            update(path, data); // Update znode data to the specified path
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
