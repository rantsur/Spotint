public class Main {
    public static void main(String args[]) {
        FileSystem sys = new FileSystem();
        sys.addDir("", "a");
        sys.addDir("", "b");
        sys.addDir("a", "b");
        sys.showFileSystem();
    }
}
