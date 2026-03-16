package Recursion_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class DirectorySizeCalculator {

    static class FileNode {
        String name;
        int size;
        boolean isFile;
        List<FileNode> children;

        FileNode(String name, int size, boolean isFile) {
            this.name = name;
            this.size = size;
            this.isFile = isFile;
            this.children = new ArrayList<>();
        }
    }

    public static int calculateSize(FileNode node) {

        // Base Case
        if (node.isFile) {
            return node.size;
        }

        int totalSize = 0;

        // Recursive Case
        for (FileNode child : node.children) {
            totalSize += calculateSize(child);
        }

        return totalSize;
    }

    public static void main(String[] args) {

        FileNode project = new FileNode("project", 0, false);

        FileNode src = new FileNode("src", 0, false);
        FileNode docs = new FileNode("docs", 0, false);
        FileNode guides = new FileNode("guides", 0, false);

        FileNode mainJava = new FileNode("main.java", 100, true);
        FileNode utilsJava = new FileNode("utils.java", 50, true);
        FileNode readme = new FileNode("readme.txt", 10, true);
        FileNode setup = new FileNode("setup.pdf", 200, true);
        FileNode config = new FileNode("config.xml", 20, true);

        src.children.add(mainJava);
        src.children.add(utilsJava);

        guides.children.add(setup);

        docs.children.add(readme);
        docs.children.add(guides);

        project.children.add(src);
        project.children.add(docs);
        project.children.add(config);

        int totalSize = calculateSize(project);

        System.out.println("Total Directory Size: " + totalSize + " KB");
    }
}