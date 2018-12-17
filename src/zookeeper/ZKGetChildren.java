package zookeeper;

import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * ZKGetChildren
 *
 * @author Isen
 * @description
 * @date 2018/7/27 11:54
 **/
public class ZKGetChildren {

    static {
        BasicConfigurator.configure();
    }

    private static ZooKeeper zk;
    private static ZooKeeperConnection conn;

    // Method to check existence of znode and its status, if znode is available.
    public static Stat znode_exists(String path) throws
            KeeperException, InterruptedException {
        return zk.exists(path, true);
    }

    public static void main(String[] args) throws InterruptedException, KeeperException {
        String path = "/MyFirstZnode"; // Assign path to the znode

        try {
            conn = new ZooKeeperConnection();
            zk = conn.connect("localhost");
            Stat stat = znode_exists(path); // Stat checks the path

            if (stat != null) {

                //“getChildren" method- get all the children of znode.It has two
                //args, path and watch
                List<String> children = zk.getChildren(path, false);
                for (int i = 0; i < children.size(); i++) {
                    System.out.println(children.get(i)); //Print children's
                }
            } else {
                System.out.println("Node does not exists");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
