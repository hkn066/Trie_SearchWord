public class Trie {
    private TrieNode root;
    public Trie(){
        root=new TrieNode();
    }

    public void insert(String word){
        TrieNode currentNode=root;
        char[]  chars=word.toCharArray();
        for (char currentChar : chars) {
            if (currentNode.children.containsKey(currentChar)==false){
                currentNode.children.put(currentChar,new TrieNode());
            }
            currentNode=currentNode.children.get(currentChar);
        }
        currentNode.isWord=true;
    }
    public boolean search(String word){
        TrieNode currentNode=root;
        String[] kelime=new String[word.length()];
        char[] chars=word.toCharArray();
        for (char currentChar:chars) {
            if (currentNode.children.containsKey(currentChar)==false){
                return false;
            }
            currentNode=currentNode.children.get(currentChar);
        }

        return currentNode.isWord;
    }


}

