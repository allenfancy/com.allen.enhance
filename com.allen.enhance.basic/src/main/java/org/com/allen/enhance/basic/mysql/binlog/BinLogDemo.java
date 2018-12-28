package org.com.allen.enhance.basic.mysql.binlog;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.github.shyiko.mysql.binlog.BinaryLogFileReader;
import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.EventData;
import com.github.shyiko.mysql.binlog.event.UpdateRowsEventData;
import com.github.shyiko.mysql.binlog.event.deserialization.ChecksumType;
import com.github.shyiko.mysql.binlog.event.deserialization.EventDeserializer;

/**
 * @author allen.wu
 * @since 2018-09-03 23:12
 */
public class BinLogDemo {

    public static void main(String[] args) throws IOException {
        String filePath="/Users/allen/Documents/tools/mysqlmaster/log/mysql-bin.000013";
        File binlogFile = new File(filePath);
        EventDeserializer eventDeserializer = new EventDeserializer();
        eventDeserializer.setChecksumType(ChecksumType.CRC32);
        BinaryLogFileReader reader = new BinaryLogFileReader(binlogFile, eventDeserializer);
        try {
            for (Event event; (event = reader.readEvent()) != null; ) {
                EventData data = event.getData();
                System.out.println(data);
                if(data instanceof  UpdateRowsEventData) {
                    UpdateRowsEventData updateRowsEventData = (UpdateRowsEventData) data;
                    List<Map.Entry<Serializable[], Serializable[]>> rows = updateRowsEventData.getRows();
                    for (Map.Entry<Serializable[], Serializable[]> row : rows) {
                        System.out.println(Arrays.toString(row.getKey()) + "   " + Arrays.toString(row.getValue()));
                    }
                }
            }
        } finally {
            reader.close();
        }
    }
}
