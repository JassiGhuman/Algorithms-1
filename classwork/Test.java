//package classwork;
//
//class Test {
//    public static void main(String[] args){
//        AdelsonVelskyLandisTree avlTree = new AdelsonVelskyLandisTree();
//
//        avlTree.insert(avlTree.root, 40);
//        avlTree.insert(avlTree.root, 10);
//        avlTree.insert(avlTree.root, 20);
//        avlTree.insert(avlTree.root, 25);
//        avlTree.insert(avlTree.root, 30);
//        avlTree.insert(avlTree.root, 50);
//
//        // The constructed AVL Tree would be
//        //      30
//        //     /  \
//        //   20   40
//        //  /  \     \
//        // 10  25    50
//
//        System.out.print("Preorder traversal of constructed tree is : ");
//        System.out.println(avlTree.preOrder(avlTree.root));
//        // System.out.println("Root: " + avlTree.root.value);
//        // System.out.print("Inorder  traversal of constructed tree is : ");
//        // System.out.println(avlTree.inOrder(avlTree.root));
//
//        // System.out.println(avlTree.root.parent);
//        // System.out.println(avlTree.root.left.parent.value);
//        // System.out.println(avlTree.root.left.left.parent.value);
//        // System.out.println(avlTree.root.left.right.parent.value);
//        // System.out.println(avlTree.root.right.parent.value);
//        // System.out.println(avlTree.root.right.left.parent.value);
//        // System.out.println(avlTree.root.right.right.parent.value);
//
//
//        avlTree.root = avlTree.delete(avlTree.root, 40);
//        avlTree.root = avlTree.delete(avlTree.root, 50);
//        avlTree.root = avlTree.delete(avlTree.root, 20);
//        System.out.print("Preorder traversal of tree is : ");
//        System.out.println(avlTree.preOrder(avlTree.root));
//        // System.out.print("Inorder  traversal of tree is : ");
//        // System.out.println(avlTree.inOrder(avlTree.root));
//
//        // avlTree.root = avlTree.delete(avlTree.root, 50);
//        // System.out.print("Preorder traversal of tree is : ");
//        // System.out.println(avlTree.preOrder(avlTree.root));
//        // System.out.print("Inorder  traversal of tree is : ");
//        // System.out.println(avlTree.inOrder(avlTree.root));
//
//        // avlTree.root = avlTree.delete(avlTree.root, 25);
//        // System.out.print("Preorder traversal of tree is : ");
//        // System.out.println(avlTree.preOrder(avlTree.root));
//        // System.out.print("Inorder  traversal of tree is : ");
//        // System.out.println(avlTree.inOrder(avlTree.root));
//    }
//}
