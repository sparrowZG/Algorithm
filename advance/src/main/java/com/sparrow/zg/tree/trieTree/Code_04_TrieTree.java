package main.java.com.sparrow.zg.tree.trieTree;

public class Code_04_TrieTree {

	public static class TrieNode {
		public int path;
		public int end;
		public TrieNode[] map;

		public TrieNode() {
			path = 0;
			end = 0;
			map = new TrieNode[26];
		}
	}

	public static class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			if (word == null) {
				return;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.map[index] == null) {
					node.map[index] = new TrieNode();
				}
				node = node.map[index];
				node.path++;
			}
			node.end++;
		}

		public void delete(String word) {
			if (search(word)) {
				char[] chs = word.toCharArray();
				TrieNode node = root;
				int index = 0;
				for (int i = 0; i < chs.length; i++) {
					index = chs[i] - 'a';
					if (node.map[index].path-- == 1) {
						node.map[index] = null;
						return;
					}
					node = node.map[index];
				}
				node.end--;
			}
		}

		public boolean search(String word) {
			if (word == null) {
				return false;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.map[index] == null) {
					return false;
				}
				node = node.map[index];
			}
			return node.end != 0;
		}

		public int prefixNumber(String pre) {
			if (pre == null) {
				return 0;
			}
			char[] chs = pre.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.map[index] == null) {
					return 0;
				}
				node = node.map[index];
			}
			return node.path;
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println(trie.search("zhanga"));
		trie.insert("zhanga");
		System.out.println(trie.search("zhanga"));
		trie.delete("zhanga");
		System.out.println(trie.search("zhanga"));
		trie.insert("zhanga");
		trie.insert("zhanga");
		trie.delete("zhanga");
		System.out.println(trie.search("zhanga"));
		trie.delete("zhanga");
		System.out.println(trie.search("zhanga"));
		trie.insert("zhanga");
		trie.insert("zhanga");
		trie.insert("zhanga");
		trie.insert("zhanga");
		trie.delete("zhanga");
		System.out.println(trie.search("zhanga"));
		System.out.println(trie.prefixNumber("zhanga"));

	}

}
