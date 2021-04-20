package com.haothink.leetcode.tree_depth_first_search;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by wanghao on 2021-04-19
 *
 *
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store
 * and retrieve keys in a dataset of strings. There are various applications of this data structure,
 * such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix
 * prefix, and false otherwise.
 *
 * 1.根节点不包含字符，除根节点外的每一个子节点都包含一个字符。
 * 2.从根节点到某一个节点，路径上经过的字符连接起来，为该节点对应的字符串。
 * 3.每个节点的所有子节点包含的字符互不相同。
 *
 **/
public class ImplementTrie {


  public static void main(String[] args) {


    Trie obj = new Trie();

    obj.insert("apple");
    System.out.println(obj);

    boolean searchResult = obj.search("apple");
    System.out.println(searchResult);

    boolean startResult = obj.startsWith("app");
    System.out.println(startResult);
  }



  static class Trie {

    private TreeNode root;

    /** Initialize your data structure here. */
    public Trie() {

      root = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {


      dfsInsert(word,root);
    }

    private void dfsInsert(String word,TreeNode treeNode){

      if(word == null || word.length() <=0){

        return;
      }
      char ch = word.charAt(0);
      String tailStr = word.substring(1);
      TreeNode childNode = treeNode.treeNodeMap.get(ch);
      if(Objects.nonNull(childNode)){

        dfsInsert(tailStr,childNode);
      }else {
        TreeNode newChildNode = new TreeNode(ch);
        treeNode.treeNodeMap.put(ch, newChildNode);
        dfsInsert(tailStr,newChildNode);
      }

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {


      return dfsFullSearch(word,root.treeNodeMap.get(word.charAt(0)));
    }

    private boolean dfsFullSearch(String word,TreeNode treeNode){

      if(word == null || word.length() <= 0){

        return false;
      }

      // get first ch
      char ch = word.charAt(0);
      if(word.length() == 1 && ch == treeNode.val && treeNode.treeNodeMap.isEmpty()){

        return true;
      }

      String tailStr = word.substring(1);
      char tailCh = tailStr.charAt(0);
      if(treeNode.val == ch && !treeNode.treeNodeMap.isEmpty()){

        TreeNode childNode = treeNode.treeNodeMap.get(tailCh);
        if(Objects.isNull(childNode)){

          return false;
        }
        return dfsFullSearch(tailStr,childNode);
      }
      return false;
    }



    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

      return dfsPrefixSearch(prefix,root.treeNodeMap.get(prefix.charAt(0)));
    }

    private boolean dfsPrefixSearch(String prefix,TreeNode treeNode){

      // get first ch
      char ch = prefix.charAt(0);
      if(prefix.length() == 1 && ch == treeNode.val){

        return true;
      }

      String tailStr = prefix.substring(1);
      char tailCh = tailStr.charAt(0);
      if(treeNode.val == ch && !treeNode.treeNodeMap.isEmpty()){

        TreeNode childNode = treeNode.treeNodeMap.get(tailCh);
        if(Objects.isNull(childNode)){

          return false;
        }
        return dfsFullSearch(tailStr,childNode);
      }
      return false;
    }



    class TreeNode {
      Character val;
      Map<Character,TreeNode> treeNodeMap;

      TreeNode() {
        treeNodeMap = new HashMap<>();
      }
      TreeNode(char val) {
        this.val = val;
        treeNodeMap = new HashMap<>();
      }
    }
  }

}
