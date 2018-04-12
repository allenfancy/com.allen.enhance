package org.com.allen.enhance.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.FirstKeyOnlyFilter;
import org.apache.hadoop.hbase.filter.InclusiveStopFilter;
import org.apache.hadoop.hbase.filter.KeyOnlyFilter;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.util.Bytes;
import org.com.allen.enhance.hbase.constants.Constants;
import org.com.allen.enhance.hbase.model.LoginIp;
import org.com.allen.enhance.hbase.model.LoginIpComparator;

import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        /*
         * createTable(); Integer mid = 123456789; for (int i = 1; i <= 100; i++) { putValue(mid,
         * System.currentTimeMillis() / 1000,
         * LoginIp.builder().mid(mid).server(i).type(i).loginIp((long) i)
         * .timestamp(System.currentTimeMillis() / 1000).build()); try { TimeUnit.SECONDS.sleep(1);
         * } catch (InterruptedException e) { e.printStackTrace(); } }
         */
        String start = "123456789_1511366458";
        String stop = "123456789_1511366938";
        // CAN BE USE
        scanValueByRowKey(start, stop);
        System.out.println("scanValueByRowKey => end");
        getValueByRowFilter("123456789");
        System.out.println("getValueByRowFilter => end");
        getValueByPrexFilter("123456789");
        System.out.println("getValueByPrexFilter => end");
        getFirstKeyOnlyFilter();
        System.out.println("getFirstKeyOnlyFilter => end");
        // CAN BE USE
        getValueByColumnInfo("123456789");
        System.out.println("getValueByColumnInfo => end");
    }

    private static Connection connection() throws IOException {
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "127.0.0.1");
        config.set("hbase.zookeeper.property.clientPort", "2181");
        return ConnectionFactory.createConnection(config);
    }

    public static void createTable() {
        Connection connection = null;
        Admin admin = null;
        try {
            connection = connection();
            admin = connection.getAdmin();
            if (!admin.isTableAvailable(TableName.valueOf(Constants.TABLE_NAME))) {
                HTableDescriptor hTableDescriptor =
                        new HTableDescriptor(TableName.valueOf(Constants.TABLE_NAME));
                hTableDescriptor.addFamily(new HColumnDescriptor(Constants.COLUMN_MID));
                hTableDescriptor.addFamily(new HColumnDescriptor(Constants.COLUMN_LOGINIP));
                hTableDescriptor.addFamily(new HColumnDescriptor(Constants.COLUMN_SERVER));
                hTableDescriptor.addFamily(new HColumnDescriptor(Constants.COLUMN_TYPE));
                hTableDescriptor.addFamily(new HColumnDescriptor(Constants.COLUMN_TIMESTAMP));
                admin.createTable(hTableDescriptor);
                return;
            }
            System.out.println("Table is Exist!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (admin != null) {
                    admin.close();
                }
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void putValue(Integer mid, Long timestamp, LoginIp loginIp) {
        Connection connection = null;
        try {
            connection = connection();
            String rowKey = mid + "_" + timestamp;
            Table table = connection.getTable(TableName.valueOf(Constants.TABLE_NAME));
            Put put = new Put(rowKey.getBytes());
            put.addColumn(Constants.COLUMN_MID.getBytes(), null,
                    String.valueOf(loginIp.getMid()).getBytes());
            put.addColumn(Constants.COLUMN_LOGINIP.getBytes(), null,
                    String.valueOf(loginIp.getLoginIp()).getBytes());
            put.addColumn(Constants.COLUMN_SERVER.getBytes(), null,
                    String.valueOf(loginIp.getServer()).getBytes());
            put.addColumn(Constants.COLUMN_TYPE.getBytes(), null,
                    String.valueOf(loginIp.getType()).getBytes());
            put.addColumn(Constants.COLUMN_TIMESTAMP.getBytes(), null,
                    String.valueOf(loginIp.getTimestamp()).getBytes());
            table.put(put);
            table.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null && !connection.isClosed()) {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * RowFilter 进行过滤
     *
     * @throws IOException
     */
    public static void scanValueByRowKey(String start, String end) {
        Connection connection = null;
        try {
            connection = connection();
            Table table = connection.getTable(TableName.valueOf(Constants.TABLE_NAME.getBytes()));
            Scan scan = new Scan();
            scan.setStartRow(Bytes.toBytes(start));
            scan.setStopRow(Bytes.toBytes(end));
            ResultScanner rs = table.getScanner(scan);
            System.out.println("======== 华丽的分割线 ========");
            printV3(rs);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null && !connection.isClosed()) {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * RowFilter 进行过滤
     *
     * @throws IOException
     */
    public static void getValueByRowFilter(String mid) {
        Connection connection = null;
        try {
            connection = connection();
            Table table = connection.getTable(TableName.valueOf(Constants.TABLE_NAME.getBytes()));
            Scan scan = new Scan();
            RowFilter rowFilter =
                    new RowFilter(CompareOp.EQUAL, new BinaryComparator(Bytes.toBytes(mid)));
            scan.setFilter(rowFilter);
            ResultScanner rs = table.getScanner(scan);
            print(rs);
        } catch (Exception e) {
        } finally {
            if (connection != null && !connection.isClosed()) {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @throws IOException
     * @PrexFilter 前缀信息
     */
    public static void getValueByPrexFilter(String mid) {
        Connection connection = null;
        try {
            connection = connection();
            Table table = connection.getTable(TableName.valueOf(Constants.TABLE_NAME.getBytes()));
            Scan scan = new Scan();
            PrefixFilter prefixFilter = new PrefixFilter(Bytes.toBytes(mid));
            scan.setFilter(prefixFilter);
            ResultScanner rs = table.getScanner(scan);
            printV3(rs);
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (connection != null && !connection.isClosed()) {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @throws IOException
     */
    public static void getValueKeyOnlyFilter() throws IOException {
        Connection connection = null;
        try {
            connection = connection();
            Table table = connection.getTable(TableName.valueOf(Constants.TABLE_NAME.getBytes()));
            Scan scan = new Scan();
            KeyOnlyFilter prefixFilter = new KeyOnlyFilter();
            scan.setFilter(prefixFilter);
            ResultScanner rs = table.getScanner(scan);
            printV3(rs);
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (connection != null && !connection.isClosed()) {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @throws IOException
     * @Desc InclusiveStopFilter
     */
    public static void getInclusiveStopFilter(String inclusive) throws IOException {
        Connection connection = null;
        try {
            connection = connection();
            Table table = connection.getTable(TableName.valueOf(Constants.TABLE_NAME.getBytes()));
            Scan scan = new Scan();
            InclusiveStopFilter inclusiveStopFilter =
                    new InclusiveStopFilter(Bytes.toBytes(inclusive));
            scan.setFilter(inclusiveStopFilter);
            ResultScanner rs = table.getScanner(scan);
            print(rs);
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (connection != null && !connection.isClosed()) {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * @throws IOException
     * @DESC FirstKeyOnlyFilter
     */
    public static void getFirstKeyOnlyFilter() {
        Connection connection = null;
        try {
            connection = connection();
            Table table = connection.getTable(TableName.valueOf(Constants.TABLE_NAME.getBytes()));
            Scan scan = new Scan();
            FirstKeyOnlyFilter firstKeyOnlyFilter = new FirstKeyOnlyFilter();
            scan.setFilter(firstKeyOnlyFilter);
            ResultScanner rs = table.getScanner(scan);
            printV2(rs);
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (connection != null && !connection.isClosed()) {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @throws IOException
     * @Desc
     */
    public static void getValueFilter() {
        Connection connection = null;
        try {
            connection = connection();
            Table table = connection.getTable(TableName.valueOf(Constants.TABLE_NAME.getBytes()));
            Scan scan = new Scan();
            FirstKeyOnlyFilter firstKeyOnlyFilter = new FirstKeyOnlyFilter();
            scan.setFilter(firstKeyOnlyFilter);
            ResultScanner rs = table.getScanner(scan);
            printV3(rs);
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (connection != null && !connection.isClosed()) {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @throws IOException
     * @Desc
     */
    public static void getValueByColumnInfo(String mid) {
        Connection connection = null;
        try {
            connection = connection();
            Table table = connection.getTable(TableName.valueOf(Constants.TABLE_NAME.getBytes()));
            Scan scan = new Scan();
            SingleColumnValueFilter scvf =
                    new SingleColumnValueFilter(Bytes.toBytes(Constants.COLUMN_MID), null,
                            CompareOp.EQUAL, new SubstringComparator(mid));
            scvf.setFilterIfMissing(true);
            scvf.setLatestVersionOnly(true);
            scan.setFilter(scvf);
            ResultScanner rs = table.getScanner(scan);
            printV3(rs);
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (connection != null && !connection.isClosed()) {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static void print(ResultScanner rs) {
        List<LoginIp> lists = Lists.newArrayList();
        rs.forEach(result -> {
            System.out.println(result);
        });
        // Collections.sort(lists, new LoginIpComparator());
        for (LoginIp ip : lists) {
            System.out.println(ip);
        }
        rs.close();
    }

    private static void printV2(ResultScanner rs) {
        List<LoginIp> lists = Lists.newArrayList();
        rs.forEach(result -> {
            System.out.println(result);
        });
        Collections.sort(lists, new LoginIpComparator());
        for (LoginIp ip : lists) {
            System.out.println(ip);
        }
        rs.close();
    }

    private static void printV3(ResultScanner rs) {
        List<LoginIp> lists = Lists.newArrayList();
        for (Result r : rs) {
            LoginIp ip = LoginIp.builder().build();
            for (int i = 0; i < r.rawCells().length; i++) {
                Cell kv = r.rawCells()[i];
                String family = Bytes.toString(CellUtil.cloneFamily(kv));
                switch (family) {
                    case "mid":
                        ip.setMid(Integer.parseInt(Bytes.toString(CellUtil.cloneValue(kv))));
                        break;
                    case "loginIp":
                        ip.setLoginIp(Long.parseLong(Bytes.toString(CellUtil.cloneValue(kv))));
                        break;
                    case "server":
                        ip.setServer(Integer.parseInt(Bytes.toString(CellUtil.cloneValue(kv))));
                        break;
                    case "type":
                        ip.setType(Integer.parseInt(Bytes.toString(CellUtil.cloneValue(kv))));
                        break;
                    case "timestamp":
                        ip.setTimestamp(Long.parseLong(Bytes.toString(CellUtil.cloneValue(kv))));
                        break;
                    default:
                        break;
                }
            }
            lists.add(ip);
        }
        lists.forEach(ip -> {
            System.out.println(ip);
        });
    }
}
