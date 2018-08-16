public class Main {
    public static void main(String args[]) {
        FileSystem sys = new FileSystem();
        sys.addDir("", "b");
        sys.addDir("", "a");
        sys.addDir("", "c");
        sys.addDir("a", "aa");
        sys.addDir("a", "ab");
        sys.addDir("aa", "aaa");
        sys.addDir("aa", "aab");
        sys.addFile("aab", "file one", 7);
        sys.addFile("aab", "file one1", 7);
        sys.showFileSystem();

        System.out.println("***********************************************");
        sys.delete("a");
        sys.showFileSystem();
    }
}
