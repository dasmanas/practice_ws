/*
package com.practice;

import java.util.*;

public class InMemoryFileSystem {

    private Map<String, SortedSet<String>> paths;
    private File root;

    class File {
        boolean isFile = false;
        String content = null;
        Map <String, File> files = new HashMap<>();

    }



    public InMemoryFileSystem(){
        root = new File();
    }

    public List<String> ls(String path) {
        List<String> ls = new ArrayList<>();
        String[] pathSplits = path.split("/");
        File f = root;
        for(int i=1; i<pathSplits.length; i++){
            if(f.files.containsKey(pathSplits[i])) {
                f = f.files.get(pathSplits[i]);
            }
            if(f.isFile){
                ls.add(pathSplits[i]);
            }
        }
        ls.addAll(f.files.keySet());
        return ls;
    }

    public void mkdir(String path) {
        String[] pathSplits = path.split("/");
        File f = root;
        for(int i=1; i<pathSplits.length; i++){
            if(f.files.containsKey(pathSplits[i])) {
                f = f.files.get(pathSplits[i]);
            } else {
                File nf = new File();
                f.files.put("pathSplits[i]", nf);
                f = nf;
            }
        }
    }

    public void addContentToFile(String filePath, String content) {

    }

    public String readContentFromFile(String filePath) {

    }
}
*/
