package com.demo.binary.tree;

public class NodeTest {

    public static void main(String[] args) {

    }

    /**
     * 前序遍历
     * @param node
     */
    public static void preOrder(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.getData());
        preOrder(node.getLeftNode());
        preOrder(node.getRightNode());
    }


    /**
     * 中序遍历
     * @param node
     */
    public static void inOrder(Node node){
        if (node == null){
            return;
        }
        inOrder(node.getLeftNode());
        System.out.println(node.getData());
        preOrder(node.getRightNode());
    }

    /**
     * 后续遍历
     * @param node
     */
    public static void postOrder(Node node){
        if (node == null){
            return;
        }
        postOrder(node.getLeftNode());
        postOrder(node.getRightNode());
        System.out.println(node.getData());
    }

}
