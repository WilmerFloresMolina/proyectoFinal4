package projecto_final;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class HuffTree {

    // fields
    private int size = 0;
    private HuffNode root = new HuffNode();
    private PriorityQueue<HuffNode> huffQueue = new PriorityQueue();
    public ArrayList<String> pathTable = new ArrayList();
    public ArrayList<Character> valueTable = new ArrayList();

    // constructor
    public HuffTree(int[] freq, char[] code) {
        // get the counts
        this.size = freq.length;

        // throw exception if arrays are different sizes
        if (freq.length != code.length) {
            throw new UnsupportedOperationException("Error: Character and code length mismatch.");
        }

        // build huffQueue from frequencies given
        for (int i = 0; i < this.size; i++) {
            huffQueue.offer(new HuffNode(code[i], freq[i], null, null, null));
        }

        // build huffman tree from queue
        createTree();

        // build code table from huffman tree
        createTable(this.root, "");
    }

    private void createTree() {
        // while elements remain in huffQueue, add to tree
        while (huffQueue.size() > 1) {
            // pop off two minimum elements in huffQueue
            HuffNode tempL = huffQueue.poll();
            HuffNode tempR = huffQueue.poll();

            // create root for two minimum elements and build tree
            HuffNode parent = new HuffNode(0, tempL.weight + tempR.weight, tempL, tempR, null);
            tempL.parent = parent;
            tempR.parent = parent;

            // add new tree back in huffQueue
            huffQueue.offer(parent);
            this.size++;
        }

        // set HuffTree root to remaining element in huffQueue
        this.root = huffQueue.peek();
    }

    private void createTable(HuffNode curr, String str) {
        // if iterator is null, return
        if (curr == null) {
            return;
        }

        // else if leaf, display path and value
        if (curr.leftTree == null && curr.rightTree == null) {
            char tempChar;
            if (curr.value == 32) {
                tempChar = ' ';
            }

            if (curr.value == 10) {
                tempChar = 'n';
            } else {
                tempChar = (char) curr.value;
            }
            // add value and path to code tables
            this.valueTable.add(tempChar);
            this.pathTable.add(str);
        }

        // add 0 if before moving to left child
        str += "0";
        // recursively call in pre-order
        createTable(curr.leftTree, str);

        // adjust path and add 1 before moving to right child
        str = str.substring(0, str.length() - 1);
        str += "1";
        createTable(curr.rightTree, str);
    }

    String tacks = "";

    public void getTree(HuffNode curr) {
        // if iterator is null, return
        if (curr == null) {
            return;
        }

        // else if leaf, display level, weight, and value
        if (curr.leftTree == null && curr.rightTree == null) {
            // case statements to handle displaying space and newline
            switch (curr.value) {
                case 32:
                    System.out.println(tacks + curr.weight + ": sp");
                    break;
                case 10:
                    System.out.println(tacks + curr.weight + ": nl");
                    break;
                default:
                    System.out.println(tacks + curr.weight + ": " + (char) curr.value);
                    break;
            }
        } // else display level and weight
        else {
            System.out.println(tacks + curr.weight);
        }

        // increment level marker
        tacks += "- ";
        // recursively call in pre-order
        getTree(curr.leftTree);
        getTree(curr.rightTree);
        // decrement level marker
        tacks = tacks.substring(0, tacks.length() - 2);
    }

    public int getSize() {
        return this.size;
    }

    public String encode(String input) {
        // create empty string to hold code
        String str = "";

        // iterate through given string
        for (int x = 0; x < input.length(); x++) {
            // iterate through code tables
            for (int i = 0; i < valueTable.size(); i++) {
                // if char in string matches code in table, add path to string
                if (valueTable.get(i) == input.charAt(x)) {
                    str += pathTable.get(i);
                }
            }
        }
        return str;
    }
    public String decode(String bits) {
        // create empty string to hold decoded message
        String decodedStr = "";

        // iterate through bits
        for (int i = 0; i < bits.length(); i++) {
            if (!getChar(bits.substring(0, i + 1)).equals("")) {
                decodedStr += getChar(bits.substring(0, i + 1));
                bits = bits.substring(i + 1);
                i = 0;
            }
        }
        return decodedStr;
    }

    public String Decode(String bits) {
        String decode = "";
        String frase = "";

        for (int i = 0; i < bits.length(); i++) {
            decode = decode + bits.charAt(i);
            //a
            if ("01111110".equals(decode)) {
                decode = "";
                frase = frase + "a";
            }
            //b
            if ("01111111".equals(decode)) {
                decode = "";
                frase = frase + "b";
            }
            //c
            if ("0111110".equals(decode)) {
                decode = "";
                frase = frase + "c";
            }
            //d
            if ("1111110".equals(decode)) {
                decode = "";
                frase = frase + "d";
            }
            //e
            if ("1111111".equals(decode)) {
                decode = "";
                frase = frase + "e";
            }
            //f
            if ("011110".equals(decode)) {
                decode = "";
                frase = frase + "f";
            }
            //g
            if ("110100".equals(decode)) {
                decode = "";
                frase = frase + "g";
            }
            //h
            if ("110101".equals(decode)) {
                decode = "";
                frase = frase + "h";
            }
            //i
            if ("111110".equals(decode)) {
                decode = "";
                frase = frase + "i";
            }
            //j
            if ("00110".equals(decode)) {
                decode = "";
                frase = frase + "j";
            }
            //k
            if ("00111".equals(decode)) {
                decode = "";
                frase = frase + "k";
            }
            //l
            if ("01110".equals(decode)) {
                decode = "";
                frase = frase + "l";
            }
            //m
            if ("10110".equals(decode)) {
                decode = "";
                frase = frase + "m";
            }
            //n
            if ("101111100".equals(decode)) {
                decode = "";
                frase = frase + "n";
            }
            //o
            if ("11011".equals(decode)) {
                decode = "";
                frase = frase + "o";
            }
            //p
            if ("11100".equals(decode)) {
                decode = "";
                frase = frase + "p";
            }
            //q
            if ("11101".equals(decode)) {
                decode = "";
                frase = frase + "q";
            }
            //r
            if ("11110".equals(decode)) {
                decode = "";
                frase = frase + "r";
            }
            //s
            if ("0000".equals(decode)) {
                decode = "";
                frase = frase + "s";
            }
            //t
            if ("0001".equals(decode)) {
                decode = "";
                frase = frase + "t";
            }
            //u
            if ("0010".equals(decode)) {
                decode = "";
                frase = frase + "u";
            }
            //v
            if ("0100".equals(decode)) {
                decode = "";
                frase = frase + "v";
            }
            //w
            if ("0101".equals(decode)) {
                decode = "";
                frase = frase + "w";
            }
            //x
            if ("0110".equals(decode)) {
                decode = "";
                frase = frase + "x";
            }
            //y
            if ("1000".equals(decode)) {
                decode = "";
                frase = frase + "y";
            }
            //z
            if ("1001".equals(decode)) {
                decode = "";
                frase = frase + "z";
            }
            // 
            if ("1010".equals(decode)) {
                decode = "";
                frase = frase + " ";
            }
            //\n 01001101001011011010
            if ("01001101001011011010".equals(decode)) {
                decode = "";
                frase = frase + "\n";
            }
        }
        return frase;
    }

    private String getChar(String bits) {
        // create string to hold potential character
        String character = "";
        // traverse code table to seek match
        for (int i = 0; i < pathTable.size(); i++) {
            // add to string if match is found
            if (pathTable.get(i).equals(bits)) {
                character = valueTable.get(i).toString();
            }
        }
        return character;
    }
}
