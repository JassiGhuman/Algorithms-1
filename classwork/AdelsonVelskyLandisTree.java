//package classwork;
//
//import java.util.ArrayList;
//
//class Node {
//    Node left;
//    Node right;
//    Node parent;
//    int height;
//    int value;
//
//    Node(int key) {
//        left   = null;
//        right  = null;
//        parent = null;
//        value  = key;
//        height = 0;
//    }
//}
//
//class AdelsonVelskyLandisTree {
//
//    Node root;
//
//    AdelsonVelskyLandisTree() {
//        root = null;
//    }
//
//    // Returns height of the node.
//    int height(Node head) {
//
//        if (head == null) {
//            return -1;
//        }
//
//        return head.height;
//    }
//
//    void updateHeight(Node head) {
//
//        if (head != null) {
//            head.height = Math.max(height(head.left), height(head.right)) + 1;
//            updateHeight(head.parent);
//        }
//    }
//
//    void updateHeightChild(Node head) {
//
//        if (head != null) {
//            if (head.left  != null) updateHeightChild(head.left);
//            if (head.right != null) updateHeightChild(head.right);
//            head.height = Math.max(height(head.left), height(head.right)) + 1;
//        }
//    }
//    // Returns balance factor of the node.
//    int balance(Node head) {
//
//        if (head == null) {
//            return 0;
//        }
//
//        return height(head.left) - height(head.right);
//    }
//
//    // Return "needle" node if present.
//    // Return null if ""needle not present.
//    Node search(Node haystack, int needle) {
//
//        if (haystack != null) {
//            if (needle == haystack.value) {
//                return haystack;
//            }
//            else if (needle < haystack.value) {
//                return search(haystack.left, needle);
//            }
//            else if (needle > haystack.value) {
//                return search(haystack.right, needle);
//            }
//        }
//
//        return null;
//    }
//
//    ArrayList<Integer> preOrder(Node head) {
//
//        ArrayList<Integer> output = new ArrayList<Integer>();
//
//        if (head != null) {
//            output.add(head.value);
//            preOrder(head.left, output);
//            preOrder(head.right, output);
//        }
//
//        return output;
//    }
//
//    void preOrder (Node head, ArrayList<Integer> output) {
//
//        if (head != null) {
//            output.add(head.value);
//            preOrder(head.left, output);
//            preOrder(head.right, output);
//        }
//    }
//
//    ArrayList<Integer> inOrder(Node head) {
//
//        ArrayList<Integer> output = new ArrayList<Integer>();
//
//        if (head != null) {
//            inOrder(head.left, output);
//            output.add(head.value);
//            inOrder(head.right, output);
//        }
//
//        return output;
//    }
//
//    void inOrder (Node head, ArrayList<Integer> output) {
//
//        if (head != null) {
//            inOrder(head.left, output);
//            output.add(head.value);
//            inOrder(head.right, output);
//        }
//    }
//
//    ArrayList<Integer> postOrder(Node head) {
//
//        ArrayList<Integer> output = new ArrayList<Integer>();
//
//        if (head != null) {
//            postOrder(head.left, output);
//            postOrder(head.right, output);
//            output.add(head.value);
//        }
//
//        return output;
//    }
//
//    void postOrder (Node head, ArrayList<Integer> output) {
//
//        if (head != null) {
//            postOrder(head.left, output);
//            postOrder(head.right, output);
//            output.add(head.value);
//        }
//    }
//
//    //       z                                            y
//    //     /   \                                        /   \
//    //   t1     y            Left Rotate(z)          z         x
//    //        /   \      - - - - - - - - - - ->    /   \     /   \
//    //       t2    x                              t1   t2  t3    t4
//    //           /   \
//    //          t3   t4
//    //
//    Node leftRotate (Node z) {
//
//        Node y = z.right;
//        Node t2 = y.left;
//        Node headParent = z.parent;
//
//        if (root == z) root = y;
//
//        y.left    = z;
//        z.parent  = y;
//        z.right   = t2;
//        if (t2 != null) t2.parent = z;
//        y.parent  = headParent;
//        if (headParent != null) {
//            if      (headParent.left  == z) headParent.left  = y;
//            else if (headParent.right == z) headParent.right = y;
//        }
//
//        z.height = Math.max(height(z.left), height(z.right)) + 1;
//        y.height = Math.max(height(y.left), height(y.right)) + 1;
//
//        return y;
//    }
//
//    //           z                                        y
//    //         /   \                                    /   \
//    //        y     t4       Right Rotate(z)         x         z
//    //     /   \          - - - - - - - - - - ->   /   \     /   \
//    //    x    t3                                 t1   t2  t3    t4
//    //  /   \
//    // t1   t2
//    //
//    Node rightRotate (Node z) {
//
//        Node y  = z.left;
//        Node t3 = y.right;
//        Node headParent = z.parent;
//
//        if (root == z) root = y;
//
//        y.right   = z;
//        z.parent  = y;
//        z.left    = t3;
//        if (t3 != null) t3.parent = z;
//        y.parent  = headParent;
//        if (headParent != null) {
//            if      (headParent.left  == z) headParent.left  = y;
//            else if (headParent.right == z) headParent.right = y;
//        }
//
//        z.height = Math.max(height(z.left), height(z.right)) + 1;
//        y.height = Math.max(height(y.left), height(y.right)) + 1;
//
//        return y;
//    }
//
//    void insert(Node head, int key) {
//
//        insert(head, key, null);
//    }
//
//    Node insert(Node head, int key, Node headParent) {
//
//        if (head == null) {
//            Node output = new Node(key);
//            output.parent = headParent;
//            if (root == null) root = output;
//            return output;
//        }
//
//        if (key < head.value) {
//            head.left = insert(head.left, key, head);
//        }
//        else if (key > head.value) {
//            head.right = insert(head.right, key, head);
//        }
//        // Duplicate keys not allowed.
//        else {
//            return head;
//        }
//
//        head.height = Math.max(height(head.left), height(head.right)) + 1;
//
//        int headBalance = balance(head);
//
//        // Left Left Case.
//        if (headBalance > 1 && key < head.left.value) {
//            return rightRotate(head);
//        }
//
//        // Right Right Case.
//        if (headBalance < -1 && key > head.right.value) {
//            return leftRotate(head);
//        }
//
//        // Left Right Case.
//        if (headBalance > 1 && key > head.left.value) {
//            head.left = leftRotate(head.left);
//            return rightRotate(head);
//        }
//
//        // Right Left Case.
//        if (headBalance < -1 && key < head.right.value) {
//            head.right = rightRotate(head.right);
//            return leftRotate(head);
//        }
//
//        // Returns the root pointer.
//        return head;
//    }
//
//    Node minValueNode(Node head)
//    {
//        Node min = head;
//
//        while (min.left != null)
//        min = min.left;
//
//        return min;
//    }
//
//    Node delete(Node head, int trashValue) {
//
//        if (head == null) return head;
//
//        Node trash = search(head, trashValue);
//
//        if (trash != null) {
//            if ((trash.left == null) || (trash.right == null)) {
//                Node temp = null;
//
//                if      (trash.left  == null) temp = trash.right;
//                else if (trash.right == null) temp = trash.left;
//
//                if (temp ==  null) {
//                    Node tempParent = trash.parent;
//                    if (trash == root) {
//                        root = null;
//                    }
//                    if (trash == head) {
//                        return null;
//                    }
//                    else if (trash.parent.left  == trash) trash.parent.left  = temp;
//                    else if (trash.parent.right == trash) trash.parent.right = temp;
//                    updateHeight(tempParent);
//                }
//                else if (trash == root) {
//                    root = temp;
//                    updateHeightChild(root);
//                    return root;
//                }
//                else if (trash.parent.left == trash) {
//                    temp.parent = trash.parent;
//                    if (trash == root) root = temp;
//                    else trash.parent.left = temp;
//                    // head = temp;
//                    updateHeight(temp);
//                }
//                else if (trash.parent.right == trash) {
//                    temp.parent = trash.parent;
//                    if (trash == root) root = temp;
//                    else trash.parent.right = temp;
//                    // head = temp;
//                    updateHeight(temp);
//                }
//            }
//            else {
//                Node temp = minValueNode(trash.right);
//                trash.value = temp.value;
//
//                if (temp.left == null && temp.right == null) {
//                    if (temp.parent.left == temp) {
//                        temp.parent.left = null;
//                    }
//                    else if (temp.parent.right == temp){
//                        temp.parent.right = null;
//                    }
//                }
//                else if (temp.right != null) {
//                    if (temp.parent.left == temp) {
//                        temp.parent.left = temp.left;
//                    }
//                    else if (temp.parent.right == temp) {
//                        temp.parent.right = temp.right;
//                    }
//                }
//
//                updateHeight(temp);
//            }
//        }
//
//        head.height = Math.max(height(head.left), height(head.right)) + 1;
//
//        int headBalance = balance(head);
//
//        // Left Left Case.
//        if (headBalance > 1 && balance(head.left) >= 0) {
//            return rightRotate(head);
//        }
//
//        // Right Right Case.
//        if (headBalance < -1 && balance(head.right) <= 0) {
//            return leftRotate(head);
//        }
//
//        // Left Right Case.
//        if (headBalance > 1 && balance(head.left) < 0) {
//            head.left = leftRotate(head.left);
//            return rightRotate(head);
//        }
//
//        // Right Left Case.
//        if (headBalance < -1 && balance(head.right) > 0) {
//            head.right = rightRotate(head.right);
//            return leftRotate(head);
//        }
//
//        return head;
//    }
//}
