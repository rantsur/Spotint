public class Main {
    public static void main(String args[]) {
        FileSystem sys = new FileSystem();
        sys.addDir("", "a");
        sys.addDir("a", "b");
        sys.addDir("b", "e");
        sys.addDir("e", "f");
        sys.addDir("f", "r");
        sys.addFile("b", "g", 5);
        sys.addFile("b", "h", 7);
        sys.addFile("b", "i", 8);
        sys.addFile("b", "j", 9);
        sys.addFile("f", "s", 9);
        sys.addFile("f", "t", 9);
        sys.addFile("f", "u", 10);
        sys.addDir("a", "c");
        sys.addDir("c", "k");
        sys.addFile("c", "n", 10);
        sys.addFile("c", "o", 10);
        sys.addFile("c", "m", 10);
        sys.addFile("c", "l", 10);
        sys.addDir("a", "d");
        sys.addDir("d", "q");
        sys.addDir("d", "p");
        sys.addDir("p", "v");
        sys.addFile("p", "w", 12);
        sys.showFileSystem();
        System.out.println();
        System.out.println("***********************************");
        System.out.println();

        sys.delete("c");
        sys.showFileSystem();
        System.out.println();
        System.out.println("***********************************");
        System.out.println();
        sys.addDir("a", "c");
        sys.addDir("c", "k");
        sys.addFile("c", "n", 10);
        sys.addFile("c", "o", 10);
        sys.addFile("c", "m", 10);
        sys.addFile("c", "l", 10);
        sys.showFileSystem();
    }
}
