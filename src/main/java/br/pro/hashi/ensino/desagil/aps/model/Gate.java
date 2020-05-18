package br.pro.hashi.ensino.desagil.aps.model;

public abstract class Gate implements Emitter, Receiver {
    private final String name;
    private final int inputSize;

    protected Gate(String name, int inputSize) {
        this.name = name;
        this.inputSize = inputSize;
    }

    @Override
    public String toString() {
        return name;
    }

// --Commented out by Inspection START (18/05/2020 17:50):
//    public int getInputSize() {
//        return inputSize;
//    }
// --Commented out by Inspection STOP (18/05/2020 17:50)
}
