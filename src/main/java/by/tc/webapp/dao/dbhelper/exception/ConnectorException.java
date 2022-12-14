package by.tc.webapp.dao.dbhelper.exception;

public class ConnectorException extends Exception{
    public ConnectorException() {
        super();
    }

    public ConnectorException(String message) {
        super(message);
    }
    public ConnectorException(Exception e) {
        super(e);
    }

    public ConnectorException(String message, Exception e) {
        super(message, e);
    }
}
