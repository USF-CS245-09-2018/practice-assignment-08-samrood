public class LinkedList implements List {

    private Node head = null;
    private int size = 0;

    public class Node{
        public Object obj;
        public Node next;

        public Node(){
            this.obj = 0;
            this.next = null;
        }

        public Node(Object obj){
            this.obj = obj;
            this.next = null;
        }

        public Node getNext(){
            return next;
        }

        public void setNext(Node next){
            this.next = next;
        }

    }

    public Node getNode(int pos){
        Node node = head;
        for(int i = 0; i < pos; i++){
            node = node.getNext();
        }
        return node;
    }

    public void add(Object obj)  {
        Node insert = new Node(obj);
        insert.setNext(head);
        head = insert;
        ++size;
    }


    public void add(int pos, Object obj) throws Exception {
        if(pos<0 || pos > size+1){
            try{
                throw new Exception("not in range");
            }
            catch (Exception e){

            }
        }
        Node node = new Node();
        node.obj = obj;
        if(pos == 0){
            node.next = head;
            head = node;
        }
        Node previous = find(pos-1);
        node.next = previous.next;
        previous.next = node;
        ++size;
    }


    public Object get(int pos) throws Exception {
        if(pos<0 || pos > size+1){
            try{
                throw new Exception("not in range");
            }
            catch (Exception e){

            }
        }
        Node curr = getNode(pos);
        return curr.obj;
    }


    public Object remove(int pos) throws Exception {
        if(pos<0 || pos > size+1){
            try{
                throw new Exception("not in range");
            }
            catch (Exception e){

            }
        }
        if(pos == 0){
            Node node = head;
            head = head.next;
            --size;
            return node.obj;
        }
        Node previous = find(pos -1);
        Node curr = previous.next;
        previous.next = curr.next;
        --size;
        return curr.obj;
    }


    public int size() {
        return size;
    }


    private Node find(int pos){
        Node node = head;
        for(int i = 0; i<pos && node.next!= null; i++){
            node = node.next;
        }
        return node;
    }
}
