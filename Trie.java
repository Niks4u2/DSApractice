
public class Trie {

	TrieNode root;

	class TrieNode {
		TrieNode[] children;
		boolean isWord;

		TrieNode() {
			this.children = new TrieNode[26];
			this.isWord = false;
		}
	}

	Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		if (word == null || word.isEmpty()) {
			throw new IllegalArgumentException("Invalid Input");
		}
		TrieNode current = root;
		word = word.toLowerCase();
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			int index = ch - 'a';
			if (current.children[index] == null) {
				TrieNode node = new TrieNode();
				current.children[index] = node;
				current = node;
			} else {
				current = current.children[index];
			}
		}
		current.isWord = true;
	}

	public boolean search(String word) {
		if (word == null || word.isEmpty()) {
			throw new IllegalArgumentException("Invalid Input");
		}
		word = word.toLowerCase();
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			int index = ch - 'a';
			if (current.children[index] != null) {
				current = current.children[index];
			}
		}
		if(current.isWord == true) {
			return true;
		}
		return false;
	}
	
	public void display() {
		String str = "";
		TrieNode current = root;
		while(!current.isWord) {
			for(int i = 0; i < 26; i++) {
				if(current.children[i] != null) {
					int index = i + 'a';
					char ch = (char) (index);
					str += ch;
					current = current.children[i];
				}
			}
		}
		System.out.println(str);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Trie trie = new Trie();

		trie.insert("there");
//		trie.insert("their");
		trie.insert("car");
//		trie.insert("cards");
//		trie.insert("cardamom");
		System.out.println("success");
		
		System.out.println(trie.search("ther"));
		
		trie.display();

	}

}
