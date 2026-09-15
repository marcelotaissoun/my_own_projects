public class Client {
    private String clientName;
    private String clientCpf;

    public Client(String clientName, String clientCpf) {
        this.clientName = clientName;
        this.clientCpf = clientCpf;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientCpf() {
        return clientCpf;
    }
}
