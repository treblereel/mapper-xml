//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package javax.xml.namespace;

import java.io.Serializable;

public class QName implements Serializable {
    private static final long serialVersionUID;
    private static final long defaultSerialVersionUID = -9120448754896609940L;
    private static final long compatibleSerialVersionUID = 4418622981026545151L;
    private static boolean useDefaultSerialVersionUID = true;
    private final String namespaceURI;
    private final String localPart;
    private final String prefix;

    public QName(String namespaceURI, String localPart) {
        this(namespaceURI, localPart, "");
    }

    public QName(String namespaceURI, String localPart, String prefix) {
        if (namespaceURI == null) {
            this.namespaceURI = "";
        } else {
            this.namespaceURI = namespaceURI;
        }

        if (localPart == null) {
            throw new IllegalArgumentException("local part cannot be \"null\" when creating a QName");
        } else {
            this.localPart = localPart;
            if (prefix == null) {
                throw new IllegalArgumentException("prefix cannot be \"null\" when creating a QName");
            } else {
                this.prefix = prefix;
            }
        }
    }

    public QName(String localPart) {
        this("", localPart, "");
    }

    public String getNamespaceURI() {
        return this.namespaceURI;
    }

    public String getLocalPart() {
        return this.localPart;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public final boolean equals(Object objectToTest) {
        if (objectToTest == this) {
            return true;
        } else if (objectToTest != null && objectToTest instanceof QName) {
            QName qName = (QName)objectToTest;
            return this.localPart.equals(qName.getLocalPart()) && this.namespaceURI.equals(qName.getNamespaceURI());
        } else {
            return false;
        }
    }

    public final int hashCode() {
        return this.namespaceURI.hashCode() ^ this.localPart.hashCode();
    }

    public String toString() {
        return this.namespaceURI.equals("") ? this.localPart : "{" + this.namespaceURI + "}" + this.localPart;
    }

    public static QName valueOf(String qNameAsString) {
        if (qNameAsString == null) {
            throw new IllegalArgumentException("cannot create QName from \"null\" or \"\" String");
        } else if (qNameAsString.length() == 0) {
            return new QName("", qNameAsString, "");
        } else if (qNameAsString.charAt(0) != '{') {
            return new QName("", qNameAsString, "");
        } else if (qNameAsString.startsWith("{}")) {
            throw new IllegalArgumentException("Namespace URI .equals(XMLConstants.NULL_NS_URI), .equals(\"\"), only the local part, \"" + qNameAsString.substring(2 + "".length()) + "\", should be provided.");
        } else {
            int endOfNamespaceURI = qNameAsString.indexOf(125);
            if (endOfNamespaceURI == -1) {
                throw new IllegalArgumentException("cannot create QName from \"" + qNameAsString + "\", missing closing \"}\"");
            } else {
                return new QName(qNameAsString.substring(1, endOfNamespaceURI), qNameAsString.substring(endOfNamespaceURI + 1), "");
            }
        }
    }

    static {
        serialVersionUID = -9120448754896609940L;
    }
}
