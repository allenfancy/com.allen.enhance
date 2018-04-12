package org.com.allen.enhance.basic.datastruct;

import lombok.Data;

@Data
public class Node {

    private int iData;
    private double dData;
    private Node leftChild;
    private Node rightChild;

}
