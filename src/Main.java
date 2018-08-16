public class Main {
    public static void main(String args[]) {
        FileSystem sys = new FileSystem();
        sys.addDir("", "a");
        sys.addDir("a", "b");
        sys.addDir("a", "c");
        sys.addDir("b", "d");
        sys.addDir("b", "e");
        sys.addDir("b", "f");
        sys.addFile("d", "d1", 7);
        sys.addFile("d", "d2", 10);
        sys.addDir("d", "g");
        sys.addDir("c", "h");
        sys.addDir("h", "i");
        sys.addFile("i", "i1", 10);
        sys.addFile("i", "i2", 18);
        sys.showFileSystem();
        sys.delete("b");
        System.out.println("***********************************************");
        sys.showFileSystem();
        System.out.println("***********************************************");
        sys.addDir("a", "b");
        sys.addDir("b", "d");
        sys.addDir("b", "e");
        sys.addDir("b", "f");
        sys.addFile("d", "d1", 7);
        sys.addFile("d", "d2", 10);
        sys.addDir("d", "g");
        sys.showFileSystem();
    }
}
