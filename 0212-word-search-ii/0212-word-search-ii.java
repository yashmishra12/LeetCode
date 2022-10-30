class Trie {
    HashMap<Character, Trie> children = new HashMap<>();
    String word= null;
    public Trie(){}
}

class Solution {
    char[][] _board = null;
    ArrayList<String> _result = new ArrayList<>();
    
    public List<String> findWords(char[][] board, String[] words) {
        
        //Step 1: TRIE construction
        Trie root = new Trie();
        for(String word: words) {
            Trie node = root;
            
            for(Character letter: word.toCharArray()) {
                if(node.children.containsKey(letter)){
                    node = node.children.get(letter);
                }
                else {
                    Trie newNode = new Trie();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            
            node.word=word; //last TRIE node stores the word string
        }
        
        //Step 2: Backtrack for each cell
        this._board = board;
        
        for(int row=0;row<board.length; row++) {
            for(int col=0; col<board[row].length;col++){
                if(root.children.containsKey(board[row][col])) {
                    backtracking(row,col,root);
                }
            }
        }
        
        return this._result;
    }
    
    public void backtracking(int row, int col, Trie parent) {
        Character letter = this._board[row][col];
        Trie curNode = parent.children.get(letter);
        
        if(curNode.word!=null) { //found a word
            this._result.add(curNode.word);
            curNode.word = null;
        }
        
        this._board[row][col] = '#';
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};
        
        for(int d=0;d<4;d++) {
            int newRow = row+x[d];
            int newCol = col+y[d];
            
            if(newRow<0 || newRow>=this._board.length || newCol<0 || newCol>=this._board[0].length) {
                continue;
            }
            
            if(curNode.children.containsKey(this._board[newRow][newCol])) {
                backtracking(newRow, newCol, curNode);
                }
        }

        this._board[row][col] = letter;
        if(curNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }
}