package Lintcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;


public class SearchWordII {

	public static class TrieNode{
		public char val;
		public List<TrieNode> children;
		public TrieNode(char val){
			this.val = val;
			children = new ArrayList<TrieNode>();
		} 
	}
	public static ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        ArrayList<String> tmp = new ArrayList<String>();
        if (board == null || board.length < 1 || board[0].length < 1 || words == null || words.size() < 1){
            return tmp;
        }
        HashSet<String> set = new HashSet<String>();
        for (String s: words){
        	set.add(s);
        }
        TrieNode head = new TrieNode('0');
        setTrie(head, set, 0);
        HashSet<String> result = new HashSet<String>();
        HashSet<Integer> visited = new HashSet<Integer>();
        StringBuffer sb = new StringBuffer();
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
            	for (TrieNode curr: head.children){
            		if (curr.val == board[i][j]){
            			visited.add(i * cols + j);
                        sb.append(board[i][j]);
                        allDir(board, i, j, result, visited, sb, curr);
                        sb.setLength(0);
                        visited.clear();
            		}
            		if (result.size() == words.size()){
            			break;
            		}
            	}
            }
        }
        for (String s: result){
            tmp.add(s);
        }
        return tmp;
    }
    
	private static void setTrie(TrieNode head, HashSet<String> words, int index){
		Map<Character, HashSet<String>> map = new HashMap<Character, HashSet<String>>();
		for (String word: words){
			if (word.length() <= index){
				head.children.add(null);
				continue;
			}
			if (map.containsKey(word.charAt(index))){
				map.get(word.charAt(index)).add(word);
			}else{
				map.put(word.charAt(index), new HashSet<String>());
				map.get(word.charAt(index)).add(word);
				TrieNode newNode = new TrieNode(word.charAt(index));
				head.children.add(newNode);
			}
		}
		for (TrieNode node: head.children){
			if (node != null){
				setTrie(node, map.get(node.val), index + 1);
			}
		}
	}
	
    private static boolean onBoard(char[][] board, int row, int col){
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }
    
    private static TrieNode hasNext(TrieNode curr, int row, int col, char[][] board){
    	for (TrieNode child: curr.children){
    		if (child != null && child.val == board[row][col]){
    			return child;
    		}
    	}
    	return null;
    }
    
    private static void allDir(char[][] board, int row, int col, HashSet<String> result, HashSet<Integer> visited, StringBuffer sb, TrieNode curr){
    	if (curr.children.contains(null)){
            result.add(sb.toString());
            if (curr.children.size() == 1){
            	return;
            }
        }
        int[] rowDir = {0, 0, +1, -1};
        int[] colDir = {+1, -1, 0, 0};
        //int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rowDir.length; i++){
            int newRow = rowDir[i] + row;
            int newCol = colDir[i] + col;
            if (onBoard(board, newRow, newCol) && !visited.contains(newRow * cols + newCol) && hasNext(curr, newRow, newCol, board)!= null){
                visited.add(newRow * cols + newCol);
                sb.append(board[newRow][newCol]);
                allDir(board, newRow, newCol, result, visited, sb, hasNext(curr, newRow, newCol, board));
                sb.deleteCharAt(sb.length() - 1);
                visited.remove(newRow * cols + newCol);
            }
        }
    }
    
    public static void main(String[] args){
    	char[][] board = {
    			{'f','y','c','e','n','r','d'},
    			{'k','l','n','f','i','n','u'},
    			{'a','a','a','r','a','h','r'},
    			{'n','d','k','l','p','n','e'},
    			{'a','l','a','n','s','a','p'},
    			{'o','o','g','o','t','p','n'},
    			{'h','p','o','l','a','n','o'}};
    	ArrayList<String> words = new ArrayList<String>();
    	words.add("poland");
    	words.add("klnfinu");
    	words.add("aaarahr");
    	words.add("ndklpne");
    	words.add("alansap");
    	words.add("oogotpn");
    	words.add("hpolano");
    	words.add("fycenrdunifrlpne");
    	ArrayList<String> result = wordSearchII(board, words);
    	for (String s: result){
    		System.out.println(s);
    	}
    }
}
