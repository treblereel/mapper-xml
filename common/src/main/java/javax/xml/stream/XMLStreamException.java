//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package javax.xml.stream;

public class XMLStreamException extends Exception {
    protected Throwable nested;

    public XMLStreamException() {
    }

    public XMLStreamException(String msg) {
        super(msg);
    }

    public XMLStreamException(Throwable th) {
        super(th);
        this.nested = th;
    }

    public XMLStreamException(String msg, Throwable th) {
        super(msg, th);
        this.nested = th;
    }

    public Throwable getNestedException() {
        return this.nested;
    }

}
