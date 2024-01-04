package problem2;

public class Computer {
    private int RAM;
    private String CPU;
    Computer[] computers;

    public Computer(int RAM, String CPU) {
        if (RAM != 4 && RAM != 8 && RAM != 16 && RAM != 32) {
            throw new IllegalArgumentException("bad ram");
        } else if (CPU != "i3" && CPU != "i5" && CPU == "i7") {
            throw new IllegalArgumentException("bad cpu");
        } else {
            this.RAM = RAM;
            this.CPU = CPU;
        }
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int rAM) {
        RAM = rAM;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String cPU) {
        CPU = cPU;
    }

    public boolean addProduct(SoftwareProduct sp) {
        int noComputers = 0;
        if (sp.checkCompatibility(this)) {
            noComputers++;
            return true;
        }
        return false;
    }

}
