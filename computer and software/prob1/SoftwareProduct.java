package problem2;

public class SoftwareProduct {
    private String name;
    private String platform;
    private int minRAM;
    private String minCPU;

    public SoftwareProduct(String name, String platform, int minRAM, String minCPU) {
        this.name = name;
        this.platform = platform;
        this.minRAM = minRAM;
        this.minCPU = minCPU;
    }

    public boolean checkCompatibility(Computer c) {
        if (c.getCPU().compareTo(minCPU) > 0 && c.getRAM() > minRAM)
            return true;
        else
            return false;
    }
}
